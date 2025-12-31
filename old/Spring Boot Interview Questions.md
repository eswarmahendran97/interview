Spring boot

Why Spring boot
annotations
 easy to work with in-memory database(h2 database uses disk sapce)
JDBC, ORM, Security, Batch
Embedded Tomcat
Build in tool like maven, gradle

Spring Boot Actuator
Spring Boot Actuator is a sub-project of the Spring Boot Framework. It includes a number of additional features that help us to monitor and manage the Spring Boot application.

Spring Batch
Processing bulk data without manual intreption.
contains item reader, optional item processor and item writer

Auto-Configuration
Spring Boot auto-configuration attempts to automatically configure your Spring application based on the jar dependencies that you have added.

AOP
AOP enables you to dynamically add or remove concern before or after the business logic.

Dev-tools
reload changes without the need of restarting of the server.

Spring Initializer
It is a web tool provided by Spring on its official website. However, you can also create Spring Boot project by entering project details.

Request Body vs Response Body
Request body - De-serializes http request to object format
Response body - serializes java  object to http response

QueryParam vs PathParam
QueryParam - http://localhost:8080/backoffice?id=1
pathParam -  http://localhost:8080/backoffice/{1}

 bean scopes in spring
Singleton, Reqest, Session, Prototype, global session

Custom exception
Declare a class(eg: ProductNotfoundException.java) which should extend exception
use this exception class for specific methods you need the exception to invoke  Spring boot -@ExceptionHandler(value = ProductNotfoundException.class),       java - make a condition and  use "throw new InvalidAgeException("not valid");"
@ControllerAdvice should be added in top of the class. It handles the exception globally.

@CrossOrigin
Allows data from one application to another application


