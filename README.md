### Documentation

http://localhost:8080/swagger-ui/index.html

### Requiriments
* Java 21
* Gradle 8.3

### Layers
* Controller

  Definições dos endpoints da API REST
* Entity

  Object-relational mappings
* Repository

  Database data access layer
* Service

  Layer with business rules and data transformations
* DTO

  Data transfer objects returned by the REST API

## Tests
To run the applications tests

`./gradlew test`

## Run
To run the application use the command

`./gradlew build`

`./gradlew bootRun`