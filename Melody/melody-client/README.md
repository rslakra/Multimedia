# Melody Client

Web frontend application for the Melody music management system.

## Overview

Melody Client is a Spring Boot web application that provides a user-friendly interface for managing artists, songs, users, roles, and contacts. It communicates with the Melody Service REST API to perform all data operations.

## Technology Stack

- **Spring Boot**: 3.5.7
- **Java**: 21
- **Templating**: Thymeleaf
- **Build Tool**: Maven
- **Packaging**: WAR
- **No Database**: Stateless frontend that consumes REST API

## Features

- Modern web interface with Thymeleaf templates
- REST client integration with melody-service
- User management interface
- Artist and Song management
- Contact form for user inquiries
- Responsive design with custom CSS
- File upload/download support (CSV, Excel)

## Getting Started

### Prerequisites
- Java 21 or higher
- Maven 3.6+
- **melody-service** must be running (default: http://localhost:8016/melody)

### Running the Application

```bash
# Using Maven
mvn spring-boot:run

# Or using the provided script
./runMaven.sh
```

The client will start on **port 9016** with context path `/melody`.

**Client URL:** http://localhost:9016/melody

### Building the Application

```bash
# Build the WAR file
mvn clean package

# Or using the provided script
./buildMaven.sh
```

The WAR file will be generated in the `target/` directory.

## Configuration

Main configuration file: `src/main/resources/application.properties`

Key configuration:
- Server port: `9016`
- Context path: `/melody`
- API Base URL: `http://localhost:8016/melody/rest` (points to melody-service)
- Thymeleaf templates enabled
- No database (JPA excluded)

## Web Pages

The application provides the following web interfaces:

- **Home**: `/melody/home` - Main landing page
- **Artists**: `/melody/artists` - Artist management
- **Songs**: `/melody/songs` - Song management
- **Users**: `/melody/users` - User management
- **Roles**: `/melody/roles` - Role management
- **Contact Us**: `/melody/contact-us` - Contact form

## API Integration

The client communicates with melody-service using REST endpoints:

- **Users**: `/rest/users`
- **Roles**: `/rest/roles`
- **Artists**: `/rest/artists`
- **Songs**: `/rest/songs`
- **Contacts**: `/rest/contacts`

All API calls are made through the `ApiRestClient` configured in `ClientConfig`.

## Project Structure

```
melody-client/
├── src/main/java/com/rslakra/melody/ews/
│   ├── account/              # User and Role client modules
│   │   ├── controller/web/   # Web controllers
│   │   ├── service/         # Client services
│   │   ├── payload/         # DTOs for API communication
│   │   ├── filter/          # Query filters
│   │   └── parser/          # File parsers
│   ├── artist/              # Artist and Song client modules
│   │   ├── controller/web/
│   │   ├── service/
│   │   ├── payload/
│   │   ├── filter/
│   │   └── parser/
│   ├── contact/             # Contact client module
│   │   ├── controller/web/
│   │   ├── service/
│   │   └── payload/
│   ├── config/              # Configuration (ApiRestClient)
│   └── framework/           # Shared client framework
└── src/main/resources/
    ├── application.properties
    ├── templates/           # Thymeleaf templates
    │   ├── views/           # Page templates
    │   ├── layouts/         # Layout templates
    │   └── fragments/       # Reusable fragments
    └── static/              # Static resources (CSS, JS, images)
```

## Dependencies

The client application:
- Excludes JPA/Hibernate (no database)
- Uses Spring Web for MVC
- Uses Thymeleaf for templating
- Uses Spring's RestTemplate for API calls
- Includes Lombok for reducing boilerplate

## References

* [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
* [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)
* [Spring Web MVC](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html)

## Authors

- Rohtash Lakra
