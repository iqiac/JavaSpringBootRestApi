# Java Spring Boot REST API

The small project is a Java Spring Boot REST API.
It is a web application that exposes RESTful APIs for managing products.
The project uses Spring Boot as the framework for building the application.

It has the following components:
- [`pom.xml`](pom.xml): Maven project configuration file. Defines dependencies and plugins.
- [`JavaSpringBootRestApiApplication`](src/main/java/com/example/JavaSpringBootRestApi/JavaSpringBootRestApiApplication.java): Main application class, starts Spring Boot application.
- [`ProductController`](src/main/java/com/example/JavaSpringBootRestApi/controller/ProductController.java): Controller class to handle HTTP requests and responses.
- [`ProductService`](src/main/java/com/example/JavaSpringBootRestApi/service/ProductService.java): Service class that provides methods for managing database entities.
- [`ProductRepository`](src/main/java/com/example/JavaSpringBootRestApi/repository/ProductRepository.java): Repository interface to perform CRUD operations on entites in the database.
- [`Product`](src/main/java/com/example/JavaSpringBootRestApi/entity/Product.java): Represents an entity from the database.
- [`WebConfig`](src/main/java/com/example/JavaSpringBootRestApi/config/WebConfig.java): Configuration class to configure CORS (Cross-Origin Resource Sharing).
- [`docker-compose.yml`](docker-compose.yml): Configuration for containers used here:
  - DevContainer to develop in
  - MySQL server
  - Swagger UI tool

> The Java code is mostly implemented by following this [tutorial](https://www.geeksforgeeks.org/easiest-way-to-create-rest-api-using-spring-boot/).

## How to run via VS Code's DevContainer

Open Project inside VS Code, then

1. Open Command Palette.
2. Execute `Dev Containers: Reopen in Container`.
3. In terminal type `mvn spring-boot:run`.
4. In the browser, open `localhost:8081` to access Swagger UI and send HTTP requests to the Java application.

## Improvements

- [ ] Better error-handling in Java code.
- [ ] Upgrade to newer build automation tools.
- [ ] For security, don't store database username and password as plain text. Use something like docker secrets.
- [ ] Unit tests, although too late for TDD now.
- [ ] Define a docker stage and service to just run the applications without the developer environment.
- [ ] CI/CD