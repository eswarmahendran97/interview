compareTo vs equals
BigDecimal a = new BigDecimal("0.0");
BigDecimal b = new BigDecimal("0.00");
a.equals(b) => false
a.compareTo(b) => 0 (true)

Actuators
For monitoring the application
endpoints - like /health
metrics - Jvm metrics, System metrics, Application metrics
Audit - Userlogin(with help of security), Application start/stop

SpringBoot Starter dependencies
spring-boot-starter-web
spring-boot-starter-security
spring-boot-starter-data-jpa
spring-boot-starter-batch
spring-boot-starter-cache
spring-boot-starter-actuator
spring-boot-starter-tomcat
spring-boot-starter-log4j2

Copy constructor:
Used to create copy of Object similar to Clone(). It uses already created object in constructor to create a copy
Class Test{
	int id;
	Test(int id){
		this.id = id;
	}
	Test(Test t){
		id = t.id;
	}
}
Class Main{
	static void main(){
		Test t = new Test(1);
		Test t2 = new Test(t);
	}
}

Why Static in main method?
If main is not static then we need to create object for that which may not be starting point of application

Abstraction vs Encapsulation
Abstraction - Hiding uncessary details - Abstract class, Interface
Encapsulation - Hides code and data into single unit - Public, Private, Protected
