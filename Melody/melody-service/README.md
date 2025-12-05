# Melody Service

Backend REST API service for the Melody music management application.

## Overview

Melody Service is a Spring Boot application that provides REST API endpoints for managing:
- **Account Management**: Users and Roles with authentication
- **Artist Management**: Artists and their profiles
- **Song Management**: Songs associated with artists
- **Contact Management**: Contact form submissions

## Technology Stack

- **Spring Boot**: 3.5.7
- **Java**: 21
- **Database**: H2 (file-based, can be configured for other databases)
- **ORM**: JPA/Hibernate
- **Database Migrations**: Liquibase
- **Build Tool**: Maven
- **Packaging**: JAR

## Features

- RESTful API endpoints
- JPA-based data persistence
- Database migrations with Liquibase
- Audit trail support (created/updated timestamps and users)
- Filter-based querying
- File upload/download support (CSV, Excel)
- Web interface for data management

## Getting Started

### Prerequisites
- Java 21 or higher
- Maven 3.6+

### Running the Application

```bash
# Using Maven
mvn spring-boot:run

# Or using the provided script
./runMaven.sh
```

The service will start on **port 8016** with context path `/melody`.

**Service URL:** http://localhost:8016/melody

### Building the Application

```bash
# Build the JAR file
mvn clean package

# Or using the provided script
./buildMaven.sh
```

The JAR file will be generated in the `target/` directory.

### Running the JAR File

After building, you can run the application directly:

```bash
java -jar target/melody-service-0.0.0.jar
```

## API Endpoints

All REST endpoints are prefixed with `/rest/`:

### Account Management
- `GET /rest/users` - Get all users
- `POST /rest/users` - Create a user
- `PUT /rest/users` - Update a user
- `DELETE /rest/users/{id}` - Delete a user
- `GET /rest/users/filter` - Filter users
- `GET /rest/roles` - Get all roles
- `POST /rest/roles` - Create a role
- `PUT /rest/roles` - Update a role
- `DELETE /rest/roles/{id}` - Delete a role

### Artist Management
- `GET /rest/artists` - Get all artists
- `POST /rest/artists` - Create an artist
- `PUT /rest/artists` - Update an artist
- `DELETE /rest/artists/{id}` - Delete an artist
- `GET /rest/artists/filter` - Filter artists

### Song Management
- `GET /rest/songs` - Get all songs
- `POST /rest/songs` - Create a song
- `PUT /rest/songs` - Update a song
- `DELETE /rest/songs/{id}` - Delete a song
- `GET /rest/songs/filter` - Filter songs

### Contact Management
- `GET /rest/contacts` - Get all contacts
- `POST /rest/contacts` - Create a contact
- `PUT /rest/contacts` - Update a contact
- `DELETE /rest/contacts/{id}` - Delete a contact
- `GET /rest/contacts/filter` - Filter contacts

## Database

The application uses H2 database by default (file-based at `~/Downloads/H2DB/Melody`).

### H2 Console
Access the H2 console at: http://localhost:8016/melody/h2

### Database Migrations
Database schema is managed by Liquibase. Migration scripts are located in:
`src/main/resources/db/changelog/dbchangelog.xml`

## Configuration

Main configuration file: `src/main/resources/application.properties`

Key configuration:
- Server port: `8016`
- Context path: `/melody`
- Database: H2 (configurable)
- REST prefix: `/rest`

## Project Structure

```
melody-service/
├── src/main/java/com/rslakra/melody/iws/
│   ├── account/              # User and Role management
│   │   ├── controller/       # REST and Web controllers
│   │   ├── service/          # Business logic
│   │   ├── persistence/      # Entities and repositories
│   │   ├── filter/           # Query filters
│   │   └── parser/           # File parsers (CSV, Excel)
│   ├── artist/               # Artist and Song management
│   │   ├── controller/
│   │   ├── service/
│   │   ├── persistence/
│   │   ├── filter/
│   │   └── parser/
│   ├── contact/              # Contact management
│   │   ├── controller/
│   │   ├── service/
│   │   ├── persistence/
│   │   └── filter/
│   └── framework/            # Shared framework code
│       ├── controller/       # Base controllers
│       ├── service/          # Base services
│       ├── persistence/     # Base entities and repositories
│       └── filter/           # Base filter classes
└── src/main/resources/
    ├── application.properties
    └── db/changelog/         # Liquibase migrations
```

## References

* [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
* [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
* [Liquibase Documentation](https://docs.liquibase.com/)
* [H2 Database](https://www.h2database.com/html/main.html)

## Authors

- Rohtash Lakra
