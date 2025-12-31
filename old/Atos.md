Sream.Map()
Converts one form to another form

Default methods in interace
To add new implemented class and also for backward comapatablity

@controller and @restcontroller
@restController = @controller+@responseBody

Spring to Accept XML response type
Initially spring consumes json response and converts to object using  jackson jar internally. So to change response from json to XML we need to do the following
PostMan Content-Type - XML
SpringBoot Consumes - XML
Jackson-dataformat-xml jar should be added - using thiss XML is converted into object

Spring Vs Spring Boot
embeded server, internal h2 database in Spring boot
Authconfiguration in springboot

What is Autoconfiguration in SpringBoot
spring based applications have a lot of configuration.
when we use spring mvc, we need to configure a component scan, the dispatcher servlet, a view resolver, web jars (for delivering static content), among other things.
While using spring boot based jar autoconfiguration automatically configures the required things. (only when @enableautoconfiguration is used)
Eg: while adding spring boot web dependency.... autoconfiguration configures dispatcher servlet, a view resolver etc... while adding spring boot data dependency... .... autoconfiguration configures datasource.

Spring Container
The Spring container is the core of Spring Framework. The container, use for creating the objects and configuring them. Also, Spring IoC Containers use for managing the complete lifecycle from creation to its destruction. It uses Dependency Injection (DI) to manage components and these objects are called Spring Beans
Types
Spring Bean Factory

Application Context
During startup, Spring bean factory instantiates objects and adds them to the application context. Objects in the application context are called “Spring beans” or “components”.

@Component Scan
 @ComponentScan annotation along with the @Configuration annotation to tell Spring to scan classes that are annotated with any stereotype annotation

JPA changes
pom.xml
Model file
Datasource changes
