📝 API de Notas (Spring Boot + REST)

📌 Descripción

Este proyecto es una API REST para la gestión de notas, desarrollada con Spring Boot y PostgreSQL.
Se han aplicado buenas prácticas para garantizar seguridad, eficiencia y mantenibilidad.

🚀 Tecnologías utilizadas

    Java 21

    Spring Boot 3

        Spring Web

        Spring Data JPA

        Spring Security

    PostgreSQL

    Maven

    Lombok

    MapStruct

    JUnit & Mockito (Pruebas unitarias)

    Springdoc OpenAPI (Swagger) (Documentación)

    GitHub Actions (CI/CD)

📂 Estructura del proyecto

    notasapi/
    ├───.github/
    │   └───workflows/             # Configuración de CI/CD
    ├───.mvn/
    │   └───wrapper/               # Archivos de Maven Wrapper
    ├───.vscode/                   # Configuración de VS Code
    ├───src/
    │   ├───main/
    │   │   ├───java/notasapi/notasapi/
    │   │   │   ├───config/        # Configuración de Spring Security
    │   │   │   ├───controller/    # Controladores REST
    │   │   │   ├───dto/           # Data Transfer Objects (DTOs)
    │   │   │   ├───entity/        # Entidades JPA
    │   │   │   ├───exception/     # Manejo global de errores
    │   │   │   ├───repository/    # Repositorios JPA
    │   │   │   ├───security/      # Configuración de seguridad
    │   │   │   └───service/       # Lógica de negocio
    │   │   └───resources/
    │   │       ├───static/        # Recursos estáticos
    │   │       └───templates/     # Plantillas HTML (si aplica)
    │   └───test/
    │       └───java/notasapi/notasapi/
    │           └───service/       # Pruebas unitarias
    └───target/                    # Archivos generados por Maven

🔧 Instalación y configuración

1️⃣ Clonar el repositorio

    git clone https://github.com/tu-usuario/notasapi.git
    cd notasapi

2️⃣ Configurar la base de datos

    La aplicación soporta PostgreSQL y H2 (para pruebas unitarias).
    🌐 Para PostgreSQL (Producción y Desarrollo)

    Edita src/main/resources/application.properties y configura:

        spring.datasource.url=jdbc:postgresql://localhost:5432/notasdb
        spring.datasource.username=tu_usuario
        spring.datasource.password=tu_contraseña
        spring.datasource.driver-class-name=org.postgresql.Driver

        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true
        spring.jpa.properties.hibernate.format_sql=true

    🧪 Para H2 (Pruebas Unitarias)

    El perfil de pruebas usa H2 en memoria. Se activa automáticamente con:

        spring.datasource.url=jdbc:h2:mem:testdb
        spring.datasource.driver-class-name=org.h2.Driver
        spring.datasource.username=sa
        spring.datasource.password=
        spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

3️⃣ Ejecutar la aplicación

    mvn spring-boot:run

    📌 Endpoints de la API

    La API está documentada con Swagger. Puedes acceder a la documentación en:

    http://localhost:8080/swagger-ui/index.html

    🔹 Endpoints principales

    Método	Endpoint	Descripción
    GET	/api/notas	Obtener todas las notas
    GET	/api/notas/{id}	Obtener una nota por ID
    POST	/api/notas	Crear una nueva nota
    PUT	/api/notas/{id}	Actualizar una nota
    DELETE	/api/notas/{id}	Eliminar una nota

🛡️ Seguridad

    La API usa Spring Security con autenticación básica.

    🔹 Credenciales predeterminadas:

        Usuario: admin

        Contraseña: admin123

    Ejemplo en Postman o cURL:

    curl -u admin:admin123 -X GET http://localhost:8080/api/notas

✅ Pruebas unitarias

    Este proyecto incluye pruebas unitarias con JUnit 5 y Mockito.

    Para ejecutarlas, usa:

    mvn test

🚀 CI/CD con GitHub Actions

    El proyecto usa GitHub Actions para automatizar pruebas y garantizar calidad en cada actualización.

    🔹 Características del CI/CD:
    ✔️ Ejecuta pruebas automáticas en cada push o pull request.
    ✔️ Verifica que el código sea válido antes de hacer un deploy.
    ✔️ Se activa automáticamente desde el archivo .github/workflows/ci.yml.

Puedes ver el estado en la pestaña "Actions" de tu repositorio en GitHub.