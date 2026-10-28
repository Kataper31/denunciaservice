# DenunciaService – API REST de Denuncias Ciudadanas

## Descripción

API REST desarrollada con Java 21, Spring Boot y MySQL para gestionar denuncias ciudadanas relacionadas con la inseguridad.

Permite registrar denuncias, consultar sus datos, realizar búsquedas por DNI y cambiar su estado a atendida.

## Tecnologías

- Java 21
- Spring Boot 4.1.2
- Spring Data JPA
- Maven
- MySQL
- Postman para pruebas

## Endpoints

| Método | Endpoint | Función |
|---|---|---|
| POST | `/denuncias/` | Registrar denuncia |
| GET | `/denuncias/?offset=0&limit=5` | Listar con paginación |
| GET | `/denuncias/{id}` | Consultar por ID |
| GET | `/denuncias/ciudadano/{dni}` | Buscar por DNI |
| PUT | `/denuncias/{id}` | Marcar como atendida |

## Ejemplo de registro

Enviar una petición POST a `http://localhost:8080/denuncias/` con un cuerpo JSON:

```json
{
  "dni": "12345678",
  "tipo": "Robo",
  "direccion": "Av. Principal 123",
  "descripcion": "Reporte de robo en la vía pública"
}
```

## Base de datos

Crear una base de datos MySQL denominada `denuncias_db`.

La aplicación utiliza JPA para crear o actualizar la estructura de la tabla `denuncia`.

Los campos son: `id`, `dni`, `fecha`, `tipo`, `direccion`, `descripcion` y `estado`.

Los estados son:

- `1`: Pendiente.
- `0`: Atendida.

## Ejecución local

1. Instalar Java 21 y MySQL.
2. Crear la base de datos `denuncias_db`.
3. Configurar un usuario MySQL con permisos sobre dicha base de datos.
4. Ajustar la conexión en `application.properties`.
5. Configurar la variable de entorno `DB_PASSWORD` con la contraseña de MySQL.
6. Ejecutar el proyecto Spring Boot desde IntelliJ IDEA o mediante Maven.
7. Acceder a la API en `http://localhost:8080`.

La contraseña de la base de datos no se incluye en el repositorio.

## Aplicación móvil

La aplicación Android que consume esta API está disponible en:

https://github.com/Kataper31/DenunciasApp

## Finalidad

Proyecto académico desarrollado para el Taller de Desarrollo de Aplicaciones Móviles.
