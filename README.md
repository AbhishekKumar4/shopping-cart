# SHOPPING CART ASSIGNMENT

## Requirements

For building and running the application you need:

- [JDK 11](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/windows-info.html)
- [Maven 3](https://maven.apache.org)

## Development
- Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.sample.shoppingcart.ShoppingCartApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html). For example :

```sh
mvn spring-boot:run
```

- App will be started on specific port (8080)

- Coverage folder will be created after running below command.

```sh
mvn clean package
```
- And coverage report will be generated on this path "target\site\jacoco\index.html"
- index.html can be opened to see coverage in browser.

#### Swagger
- Swagger Api documentation can be accessed on url : http://localhost:8080/swagger-ui/

#### Technologies used

* [Java]
* [Spring Boot]
* [MapStruct]
* [Jacoco]
* [JUnit]
* [Maven]

### Futher points

- Current code is created keeping in mind the possible hypothetical scenarios.
- Code is designed for futher modification as application scope grows.

### Screenshots

![Image](readme_data/test_coverage.PNG "Test Case Coverage")
