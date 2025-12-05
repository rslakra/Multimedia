# Melody

A music management application with a microservices architecture, consisting of a REST API backend service and a web frontend client.

## Architecture

Melody follows a client-server architecture:

- **melody-service**: Backend REST API service that handles business logic, data persistence, and provides REST endpoints
- **melody-client**: Frontend web application that provides a user interface and consumes the melody-service API

## Projects

### [melody-service](./melody-service/)
REST API backend service providing endpoints for:
- **Account Management**: Users and Roles
- **Artist Management**: Artists and their information
- **Song Management**: Songs associated with artists
- **Contact Management**: Contact form submissions

**Technology Stack:**
- Spring Boot 3.5.7
- Java 21
- JPA/Hibernate
- H2 Database
- Liquibase (database migrations)
- REST API endpoints at `/rest/*`

**Default Port:** 8016

### [melody-client](./melody-client/)
Web frontend application providing:
- User-friendly web interface using Thymeleaf templates
- Integration with melody-service REST API
- Web pages for managing artists, songs, users, roles, and contacts

**Technology Stack:**
- Spring Boot 3.5.7
- Java 21
- Thymeleaf (server-side templating)
- REST client for API communication
- No database (stateless frontend)

**Default Port:** 9016

## Getting Started

### Prerequisites
- Java 21 or higher
- Maven 3.6+

### Running the Applications

1. **Start melody-service:**
   ```bash
   cd melody-service
   ./runMaven.sh
   # Or: mvn spring-boot:run
   ```
   Service will be available at: http://localhost:8016/melody

2. **Start melody-client:**
   ```bash
   cd melody-client
   ./runMaven.sh
   # Or: mvn spring-boot:run
   ```
   Client will be available at: http://localhost:9016/melody

### Building the Applications

```bash
# Build melody-service
cd melody-service
./buildMaven.sh
# Or: mvn clean package

# Build melody-client
cd melody-client
./buildMaven.sh
# Or: mvn clean package
```

## API Endpoints

The melody-service provides REST endpoints at `http://localhost:8016/melody/rest/`:

- `/rest/users` - User management
- `/rest/roles` - Role management
- `/rest/artists` - Artist management
- `/rest/songs` - Song management
- `/rest/contacts` - Contact form submissions

## Project Structure

```
Melody/
├── melody-service/          # Backend REST API service
├── melody-client/           # Frontend web application
└── melody-webapp/           # Web application deployment scripts
```

## References

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/html/)

## Authors

- Rohtash Lakra
