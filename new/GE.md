JVM is platform independent?
No it is platform dependent

What is Reflection?
Reflection in Java lets you inspect and manipulate classes, methods, and fields at runtime

How springboot uses reflection?
@ComponentScan -> tells Scan the classpath starting from this package for @Component-annotated classes.

scans package:
eg: com.example.service

1) converts the package to folder stricture -> com/example/service/
2) In that folder we will have .class files
3) get the class by Reflection 
    1) find the className -> String className = "com.example.service." + fileName.replace(".class", "");
    2) Class<?> clazz = Class.forName(className);
4) Using reflection it checks whether it have annotations in ir
    1) if (clazz.isAnnotationPresent(Component.class)) {
        // added to ApplicationContext
    }

In AOP also it uses reflection
Method.invoke()


Exception propogation
Exception propagation means how an exception moves up the call stack until it’s either caught or causes the program to terminate.

Exception in thread "main" java.lang.ArithmeticException: / by zero
    at Test.method2(Test.java:12)
    at Test.method1(Test.java:8)
    at Test.main(Test.java:4)

Runtime -> automatically propogated up
Complie time -> use throws 


Application context:
The interface ApplicationContext represents the IoC container. The Spring container is responsible for instantiating, configuring and assembling Spring beans, as well as managing their life cycles.