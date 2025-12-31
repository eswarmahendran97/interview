Put vs Patch mapping
The PUT HTTP method is used to update an existing resource, while the PATCH HTTP method is used to apply a partial update to a resource.

PUTMapping should be used when you need to replace the entire resource with new data. For example, if you have a user resource and you want to update the user's name, email address, and password, you would use a PUT request.

PatchMapping should be used when you only need to update a subset of the resource's fields. For example, if you only want to update the user's name, you would use a PATCH request.



Which is idempotent method

If you send a PUT request to the same endpoint multiple times with the same data, the resource will be updated to the same state which we call as idempotent method (eg: get, put, patch, delete)


@Component vs @service
@Component is a general-purpose annotation that can be used to annotate any class that Spring should manage as a bean. @Service is a more specific annotation that is used to annotate classes that provide business logic. Only purpose of using @Service to make your code more readable and maintainable.


@component instead @controller
yes possible, but need to specify @ResponseBody under method


Verify vs assert
Mockito.verify() is used to verify that a method was called on a mock object. This is useful for testing the behavior of your code without having to worry about the implementation details of the mock object.
    // Verify that the save() method was called on the myRepository mock object.
       verify(myRepository).save(new MyEntity());

Assert() is used to verify the state of your code. This is useful for testing the output of your code or the values of variables.
    // Assert that the name returned by the getName() method is equal to "John Doe".
       assertEquals("John Doe", name);



How to use two DB connection

	Two enitites with different schemas
	Eg: 1 transaction manager for user and 1 for prodct
	configure
		@EnableJpaRepositories(
    		basePackages = "com.baeldung.multipledb.dao.user", 
    		entityManagerFactoryRef = "userEntityManager", 
    		transactionManagerRef = "userTransactionManager"
		)
		class{
		DataSourceProperties userDataSource()
		EntityManagerFactory userEntityManager()
			userEntityManager.setDataSource(userDataSource)
		TransactionManager userTransactionManager()
			transactionManager.setEntityManagerFactory(userEntityManager().getObject());
		}
	
	Same for product
		
	Test:
	 @Transactional("userTransactionManager")
    	public void whenCreatingUser_thenCreated() {
        User user = new User();
        user.setName("John");
        user.setEmail("john@test.com");
        user.setAge(20);
        user = userRepository.save(user);

        assertNotNull(userRepository.findOne(user.getId()));
    	}


Normalization in db
In database management systems (DBMS), normal forms are a series of guidelines that help to ensure that the design of a database is efficient, organized, and free from data anomalies


ACID
A-Atomicity (All transactions should be commited or none should be commited)
C-Consistency (All tansactions should be consitent)
I-Isolation (The intermediate state of a transaction is invisible to other transactions)
D-Durability (Completed transaction should be saved securely)


Projection in JPA
Only if we want a value from table using id, we will use
public interface EmployeeRepository extends Repository<Employee, Long> {
    List<Employee> getByFirstName(String firstName);
}

But in this case all the fields will be retrived. In case If we want have only specific field we can use projection
Interface based Projections
public interface EmployeeView {
    String getFirstName();
    String getLastName();
    String getEmail();
}
public interface EmployeeRepository extends Repository<Employee, Long> {
    List<EmployeeView> getByFirstName(String firstName);
}
Behind the scenes, Spring creates a proxy instance of the projection interface for each entity object, and all calls to the proxy are forwarded to that object.



implement custom repository

Interface CustomRepository{
	void deleteById(Employee employee);
}

Interface CustomRepositoryImpl implements CustomRepository {
	@Autowired
	private EntityManager entityManager;

	void deleteById(Employee employee){
		entityManager.remove(employee)
	}
}


Interface EmployeeRepository extends JpaRepository<Employee, Long>, CustomRepository{

}



Factory Design patter

Interface Notification{}
Class SMSNotification implements Notification{}
Class PushNotification implements Notification{}
Class MailNotification implements Notification{}

Class NotificationFactory{
	getNotification(String type){
		return object based on type
	}
}

Main Class{
Notification notify = NotificationFactory.getNotification("SMS");
}



Map max()
Collection.max(map.entryset(), Map.Entry.comparingByValue()).getValue();

Fibanocci using recrussion






