package com.backendproject.springBackend.institucionesoportunidades.repository;

import com.backendproject.springBackend.categoriaoportunidad.model.CategoriaOportunidad;
import com.backendproject.springBackend.instituciones.model.Instituciones;
import com.backendproject.springBackend.institucionesoportunidades.dto.FiltrarOportunidadesDTO;
import com.backendproject.springBackend.institucionesoportunidades.model.InstitucionesOportunidades;
import com.backendproject.springBackend.oportunidades.model.Oportunidades;
import com.backendproject.springBackend.tiposoportunidad.model.TiposOportunidad;
import com.backendproject.springBackend.ubicacionregion.model.UbicacionRegion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomInstitucionesOportunidadesRepositoryImpl implements CustomInstitucionesOportunidadesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<InstitucionesOportunidades> filtrarOportunidades(FiltrarOportunidadesDTO filtrarOportunidadesDTO) {

        // Construye el Criteria Builder
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<InstitucionesOportunidades> query = cb.createQuery(InstitucionesOportunidades.class);
        Root<InstitucionesOportunidades> root = query.from(InstitucionesOportunidades.class);

        Join<InstitucionesOportunidades, Oportunidades> oportunidadesJoin = root.join("oportunidadId", JoinType.LEFT);

        Join<InstitucionesOportunidades, Instituciones> institucionJoin = root.join("institucionId", JoinType.LEFT);

        // Lista de predicados
        List<Predicate> predicates = new ArrayList<>();

        if (filtrarOportunidadesDTO.getNombre() != null && !filtrarOportunidadesDTO.getNombre().isEmpty()) {

            Join<Oportunidades, TiposOportunidad> tiposOportunidadJoin = root.join("oportunidadId", JoinType.LEFT);

            predicates.add(cb.like(cb.lower(tiposOportunidadJoin.get("tiposOporId").get("nombre")), "%" + filtrarOportunidadesDTO.getNombre().toLowerCase() + "%"));
        }

        if (filtrarOportunidadesDTO.getIdRegion() != null) {

            Join<Instituciones, UbicacionRegion> ubicacionJoin = root.join("institucionId", JoinType.LEFT);

            predicates.add(cb.equal(ubicacionJoin.get("idRegion").get("id"), filtrarOportunidadesDTO.getIdRegion()));
        }

        if (filtrarOportunidadesDTO.getIdInstitucion() != null) {
            predicates.add(cb.equal(institucionJoin.get("id"), filtrarOportunidadesDTO.getIdInstitucion()));
        }

        if (filtrarOportunidadesDTO.getIdCategoria() != null) {

            Join<Oportunidades, CategoriaOportunidad> categoriaOportunidadJoin = root.join("oportunidadId", JoinType.LEFT);

            predicates.add(cb.equal(categoriaOportunidadJoin.get("id"), filtrarOportunidadesDTO.getIdCategoria()));
        }

        // Aplica los predicados a la consulta
        query.where(cb.and(predicates.toArray(new Predicate[0])));

        // Crea la consulta
        TypedQuery<InstitucionesOportunidades> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}