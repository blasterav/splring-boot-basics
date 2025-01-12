# Spring Boot Basics

A Spring Boot project of basic KYC implementation with Domain-Driven Design (DDD) principles, built with Java 21 and Spring Boot 3.3.0.

## Features

- Domain-Driven Design architecture
- RESTFUL API endpoints
- GraphQL API endpoints
- MySQL database integration with Spring Data JDBC
- Spring Modulith for modular application design
- Testing setup with TestContainers

## Prerequisites

- Java 21
- MySQL Server
- Maven 3.x
- Docker (for running TestContainers)

## Technology Stack

- **Spring Boot** 3.3.0
- **Spring Modulith** 1.2.0
- **Spring Data JDBC**
- **GraphQL**
- **MySQL**
- **Lombok**
- **TestContainers**

## Project Structure

The project follows DDD principles with a clear separation of concerns:

```
src/
├── main/
│   ├── java/
│   │   └── com/phoosop/spring_boot_basics/
│   │       ├── common/             # Common utils, connectors and constants
│   │       ├── configs/            # Configurations
│   │       ├── exceptions/         # Exceptions classes and error handling
│   │       └── <domain>/           # Domain services, controllers and DTOs
│   │           └── internal/       # Repositories, listeners and others internal domain classes
│   │               └── converters/ # Converters
│   └── resources/
│       └── graphql/           # GraphQL schema definitions
└── test/
    └── java/                  # Test cases with TestContainers
```

## Getting Started

1. Clone the repository:
```bash
git clone https://github.com/yourusername/spring-boot-basics.git
cd spring-boot-basics
```

2. Configure MySQL database properties in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Testing

The project uses TestContainers for integration testing, ensuring tests run against a real MySQL database in a container:

```bash
mvn test
```

## Monitoring

Access Spring Boot Actuator endpoints at:
- Health check: `http://localhost:8080/actuator/health`
- Metrics: `http://localhost:8080/actuator/metrics`

## GraphQL API

Access the GraphQL playground at `http://localhost:8080/graphiql` to interact with the API.