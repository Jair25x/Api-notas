📝 API de Notas (Spring Boot + REST)

📌 Descripción

Este proyecto es una API REST para la gestión de notas, desarrollada con Spring Boot y PostgreSQL. Implementa buenas prácticas como:

Uso de DTOs con MapStruct.

Validaciones con javax.validation.

Manejo de errores con @ControllerAdvice.

Seguridad con Spring Security (autenticación básica).

Documentación con Springdoc OpenAPI (Swagger).

Pruebas unitarias con JUnit y Mockito.

CI/CD con GitHub Actions.

🚀 Tecnologías utilizadas

Java 17

Spring Boot 3 (Spring Web, Spring Data JPA, Spring Security)

PostgreSQL

Maven

Lombok

MapStruct

JUnit y Mockito

Springdoc OpenAPI (Swagger)

GitHub Actions (para CI/CD)

📂 Estructura del proyecto

🔧 Instalación y configuración

1️⃣ Clonar el repositorio

git clone https://github.com/tu-usuario/notas-api.git
cd notas-api

2️⃣ Configurar la base de datos

Crear un archivo application.properties o application.yml y agregar:

spring.datasource.url=jdbc:postgresql://localhost:5432/notas_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update

3️⃣ Ejecutar la aplicación

mvn spring-boot:run

📌 Endpoints de la API

La API está documentada con Swagger. Puedes acceder a la documentación interactiva en:

http://localhost:8080/swagger-ui/index.html

Algunos endpoints clave:

GET /api/notas → Obtener todas las notas

GET /api/notas/{id} → Obtener una nota por ID

POST /api/notas → Crear una nueva nota

PUT /api/notas/{id} → Actualizar una nota

DELETE /api/notas/{id} → Eliminar una nota

🛡️ Seguridad

La API usa Spring Security con autenticación básica. Credenciales por defecto:

Usuario: admin

Contraseña: admin123

Ejemplo en Postman o cURL:

curl -u admin:admin123 -X GET http://localhost:8080/api/notas

✅ Pruebas unitarias

Para ejecutar las pruebas unitarias:

mvn test

🚀 CI/CD con GitHub Actions

Este proyecto usa GitHub Actions para CI/CD.

Se ejecutan pruebas automáticamente en cada push o pull request.

Verifica que el código sea válido antes de hacer un deploy.

Puedes ver el estado en la pestaña "Actions" de tu repositorio en GitHub.
