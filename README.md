# Generate check project

## Functionality

- Generate check with list of products and total price and so on

## Technologies used

### Stack:

- Java 17
- Spring: SpringBoot, Web, Data JPA, Validation
- Gradle
- PostgreSQL
- Lombok
- MapStruct
- Liquibase
- SpringFox

### Environment

- Docker for containerization

## Quick start

### Required:

- Java 17
- Gradle 7.5
- Docker

### Steps:

```
- git clone https://github.com/AlekseiKasperovich/GenerateCheck.git
- cd GenerateCheck
- gradle build
- docker-compose -f docker-compose.yml up -d --build
- Go to http://localhost:8080/swagger-ui/ - read api documentation
```