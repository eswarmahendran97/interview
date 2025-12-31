Disable configurations in Spring Boot
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})

Safe and Impotenent methods
Safe - will not manipulate data in server
Eg:Get
Impotenent - server will not have any effect when hitting with same request method multiple times.
Eg:Delete(The call may return with a HTTP-Response 200 OK and the deleted resource as payload in the first place. In a second call, the Response will be 204 NO_CONTENT as the resource has already been deleted by the first call.After each request the server-state is the same, therefore idempotency is fulfilled. The HTTP/1.1 says nothing about the response)

Can Abstarct class can be Intantiated?
SInce it contain abstract method we cannot intantiate it.

