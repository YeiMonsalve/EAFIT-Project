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

# Datos que se agregan en la tabla "roles" de la base de datos al ejecutar el proyecto:

- User
- Admin

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

| id  | region         |
|-----|----------------|
| 1   | Norte          |
| 2   | Sur            |
| 3   | Oriente        |
| 4   | Occidente      |
| 5   | Noroccidente   |
| 6   | Suroccidente   |
| 7   | Nororiente     |
| 8   | Suroriente     |

### Tabla: `instituciones`

| id  | nombre                   | direccion    | region_id  |
|-----|--------------------------|--------------|------------|
| 1   | Universidad Random       | Avenida X    | 1          |
| 2   | Universidad EAFIT        | Avenida Y    | 2          |
| 3   | Universidad EAFIT Bello  | Avenida Z    | 3          |

### Tabla: `estado_oportunidad`

| id   | estado    |
|------|-----------|
| 1    | Activo    |
| 2    | Inactivo  |

### Tabla: `informacion_oportunidad`

| id   | info                         |
|------|------------------------------|
| 1    | Abierto para inscripciones   |
| 2    | Inscripciones cerradas       |
| 3    | En proceso de acreditación   |

### Tabla: `tipos_oportunidad`

| id   | nombre       | descripcion                         |
|------|--------------|-------------------------------------|
| 1    | Curso        | Curso online sobre tecnología       |
| 2    | Beca         | Beca universitaria completa         |
| 3    | Bootcamp     | Bootcamp intensivo en programación  |

### Tabla: `categoria_oportunidad`

| id   | categoria         |
|------|-------------------|
| 1    | Formativa         |
| 2    | Socioeconómica    |

### Tabla: `oportunidades`

| id    | nombre                | estado_id  | info_id  | tipo_oportunidad_id  | categoria_id  |
|-------|-----------------------|------------|----------|----------------------|---------------|
| 1     | Curso programación    | 2          | 2        | 1                    | 1             |
| 2     | Beca completa         | 1          | 3        | 2                    | 2             |
| 3     | Bootcamp intensivo    | 1          | 1        | 3                    | 1             |

### Tabla: `instituciones_oportunidades`

| id   | institucion_id | oportunidad_id |
|------|----------------|----------------|
| 1    | 1              | 1              |
| 2    | 1              | 2              |
| 3    | 2              | 1              |
| 4    | 3              | 3              |
| 5    | 2              | 3              |

### Tabla: `roles`

| id  | rol   | 
|-----|-------| 
| 1   | Admin | 
| 2   | User  |

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