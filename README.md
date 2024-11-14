# Configuración de la base de datos en MySQL:

CREATE DATABASE nodoantivirusdb;

CREATE USER 'antivirus_nodo'@'localhost' IDENTIFIED BY 'grupo1backend';
GRANT ALL PRIVILEGES ON nodoantivirusdb.* TO 'antivirus_nodo'@'localhost';
FLUSH PRIVILEGES;

# Tablas que se crean en la base de datos al ejecutar el proyecto:

- categoria_oportunidad
- estado_oportunidad
- informacion_oportunidad
- instituciones
- instituciones_oportunidades
- oportunidades
- tipos_oportunidad
- ubicacion_region
- roles
- usuarios
- usuario_oportunidades

# Tablas que se cargan con datos al ejecutar el proyecto:

- roles
- ubicacion_region
- instituciones
- tipos_oportunidad
- categoria_oportunidad
- estado_oportunidad
- informacion_oportunidad
- oportunidades

# Relaciones entre las tablas

1. **`ubicacion_region` y `instituciones`:**
   - Relación de uno a muchos: Una región puede tener muchas instituciones, pero cada institución solo pertenece a una región.
   - Llave foránea: `id_region` en la tabla `instituciones` referencia a `id` en `ubicacion_region`.

2. **`estado_oportunidad` y `oportunidades`:**
   - Relación de uno a muchos: Un estado puede aplicarse a muchas oportunidades, pero cada oportunidad tiene solo un estado.
   - Llave foránea: `estado_id` en `oportunidades` referencia a `id` en `estado_oportunidad`.

3. **`informacion_oportunidad` y `oportunidades`:**
   - Relación de uno a muchos: Una información puede aplicarse a muchas oportunidades, pero cada oportunidad tiene solo una información.
   - Llave foránea: `info_id` en `oportunidades` referencia a `id` en `informacion_oportunidad`.

4. **`tipos_oportunidad` y `oportunidades`:**
   - Relación de uno a muchos: Un tipo de oportunidad puede tener muchas oportunidades, pero cada oportunidad tiene solo un tipo.
   - Llave foránea: `tipo_oportunidad_id` en `oportunidades` referencia a `id` en `tipos_oportunidad`.

5. **`categoria_oportunidad` y `oportunidades`:**
   - Relación de uno a muchos: Una categoría puede estar asociada a muchas oportunidades, pero cada oportunidad tiene solo una categoría.
   - Llave foránea: `categoria_id` en `oportunidades` referencia a `id` en `categoria_oportunidad`.

6. **`instituciones` y `instituciones_oportunidades`:**
   - Relación de muchos a muchos: Una institución puede ofrecer muchas oportunidades y una oportunidad puede ser ofrecida por muchas instituciones.
   - Llave foránea: `institucion_id` y `oportunidad_id` en `instituciones_oportunidades` referencian `id` en `instituciones` y `oportunidades`, respectivamente.

7. **`usuarios` y `roles`:**
   - Relación de uno a muchos: Un rol puede ser asignado a muchos usuarios, pero cada usuario tiene solo un rol.
   - Llave foránea: `id_rol` en la tabla `usuarios` referencia a `id` en `roles`.

8. **`usuarios` y `usuario_oportunidades`:**
   - Relación de muchos a muchos: Un usuario puede estar inscrito en muchas oportunidades y una oportunidad puede tener muchos usuarios inscritos.
   - Llave foránea: `usuario_id` y `oportunidades_id` en `usuario_oportunidades` referencian `id` en `usuarios` y `id` en `oportunidades`, respectivamente.

# Ejemplo de datos en las tablas:

### Tabla: `ubicacion_region`

| id  | region            |
|-----|-------------------|
| 1   | Sur               |
| 2   | Noroccidental     |
| 3   | Suroriental       |
| 4   | Centro Occidental |
| 5   | Centro Oriental   |
| 6   | Suroccidental     |
| 7   | Centro            |
| 8   | Nororiente        |

### Tabla: `instituciones`

| id   | nombre                                     | direccion                              | region_id  |
|------|--------------------------------------------|----------------------------------------|------------|
| 1    | Institución Universitaria de Envigado      | Cra 27 B # 39 A Sur 57                 | 1          |
| 2    | Colegio Mayor de Antioquia                 | Calle 65#77-126 Robledo                | 2          |
| 3    | ESA Débora Arango                          | CALLE 39 SUR 39-8 Envigado             | 1          |
| 4    | Universidad Nacional (sede Medellín)       | Cra. 65 # 59A - 110                    | 2          |
| 5    | Universidad EAFIT                          | Carrera 49 N° 7 Sur - 50               | 3          |
| 6    | Universidad Católica Luis Amigó            | Transversal 51A #67B 90                | 4          |
| 7    | Universidad Nacional Abierta y a Distancia | Carrera 45 # 55-19                     | 5          |
| 8    | Universidad de Medellín                    | Carrera 87 N° 30 – 65                  | 6          |
| 9    | Corporación Universitaria Americana        | Calle 50 # 43-65                       | 7          |
| 10   | Universidad de Antioquia                   | Ciudad Universitaria Calle 57 #53 -108 | 8          |
| 11   | Universidad de Antioquia                   | Cra. 51d #62-29                        | 2          |


### Tabla: `estado_oportunidad`

| id   | estado   |
|------|----------|
| 1    | Activo   |
| 2    | Inactivo |

### Tabla: `informacion_oportunidad`

| id   | info                       |
|------|----------------------------|
| 1    | Abierto para inscripciones |
| 2    | Inscripciones cerradas     |
| 3    | Suspendido                 |

### Tabla: `tipos_oportunidad`

| id | nombre                              | url                                                                                                                                                                   |
|----|-------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1  | Cursos Virtuales SENA               | https://www.sena.edu.co/                                                                                                                                              |
| 2  | Arroba Medellín                     | https://arrobamedellin.edu.co/                                                                                                                                        |
| 3  | Cursos Comfama                      | https://www.comfama.com/                                                                                                                                              |
| 4  | Floqq                               | https://www.floqq.com/                                                                                                                                                |
| 5  | Beca del municipio de Itagüí        | https://www.semitagui.gov.co/                                                                                                                                         |
| 6  | Matrícula Cero Distrito de Medellín | https://sapiencia.gov.co/matricula-cero/                                                                                                                              |
| 7  | Jóvenes en acción                   | https://prosperidadsocial.gov.co/sgpp/transferencias/jovenes-en-accion/inscripciones/                                                                                 |
| 8  | Fondo Sapiencia EPM - Universidades | https://sapiencia.gov.co/fondos-sapiencia/epm-y-universidades/                                                                                                        |
| 9  | Sena                                | https://sena.edu.co/es-co/formacion/media/forms/allitems.aspx?rootfolder=/es-co/formacion/media/bootcamps&folderctid=0x0120d520a808007402f768f739d245b5d314d3c165801e |
| 10 | Nodo Eafit                          | https://es.nodoeafit.com/                                                                                                                                             |
| 11 | Open Bootcamp                       | https://open-bootcamp.com/                                                                                                                                            |
| 12 | MinTic                              | https://cursoscortossenatec.co/                                                                                                                                       |


### Tabla: `categoria_oportunidad`

| id | categoria      |
|----|----------------|
| 1  | Formativa      |
| 2  | Socioeconómica |
| 3  | Bootcamps      |


### Tabla: `oportunidades`

| id    | Estado Oportunidad | Información Oportunidad | Tipo Oportunidad | Categoría Oportunidad |
|-------|--------------------|-------------------------|------------------|-----------------------|
| 1     | 1                  | 1                       | 1                | 1                     |
| 2     | 2                  | 3                       | 5                | 2                     |
| 3     | 1                  | 1                       | 11               | 3                     |
| 4     | 2                  | 1                       | 6                | 2                     |
| 5     | 1                  | 1                       | 4                | 1                     |
| 6     | 2                  | 2                       | 7                | 2                     |
| 7     | 1                  | 1                       | 3                | 1                     |
| 8     | 1                  | 1                       | 9                | 3                     |
| 9     | 1                  | 1                       | 8                | 2                     |
| 10    | 1                  | 1                       | 10               | 3                     |
| 11    | 2                  | 2                       | 2                | 1                     |
| 12    | 1                  | 1                       | 12               | 3                     |


### Tabla: `instituciones_oportunidades`

| id | institucion_id | oportunidad_id |
|----|----------------|----------------|
| 1  | 1              | 2              |
| 2  | 2              | 11             |
| 3  | 2              | 4              |
| 4  | 2              | 6              |
| 5  | 3              | 6              |
| 6  | 4              | 6              |


### Tabla: `roles`

| id  | rol   | 
|-----|-------| 
| 1   | User  | 
| 2   | Admin |

### Tabla: `usuarios`

| id | nombre | apellido | birthday   | email             | password      | id_rol |
|----|--------|----------|------------|-------------------|---------------|--------|
| 1  | Pepe   | De Tales | 2005-03-07 | admin@example.com | pepe1234      | 1      |
| 2  | Pepita | De Tal   | 1990-05-15 | user@example.com  | detalpepita12 | 2      |

### Tabla: `usuario_oportunidades`

| id | usuario_id | oportunidades_id | 
|----|------------|------------------|
| 1  | 1          | 1                | 
| 2  | 1          | 2                | 
| 3  | 2          | 3                | 
| 4  | 2          | 1                | 

**En el package postmancollection hay una colección para hacer las pruebas CRUD de las tablas.**