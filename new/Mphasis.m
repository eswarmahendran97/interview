Mphasis

checked and unchecked
Checked (Compile time)
checked at compile time
compiler forces you to hanlde(try-catch, throws)
Handle - try
eg: IOException, SQLExpection

unchecked(Runtime)
not checked at compile time
programming errors
eg: NumberFormat, Arithematic



ClassNotFoundException
checked
occurs while loading a class at runtime
Class loadedClass = Class.forName(CLASS_TO_LOAD);
NoClassDefFoundError
unchecked
when the class was present during the compile time and is not available during run time for some reasons



deep and shallow
shallow 
Employee e = new Employee();
Employee e1 = e
return e == e1; //true - same refference, both gets affected in change

deep 
Employee e = new Employee();
Employee e1 = e.clone()
return e == e1; //false - diff refference
if child is not cloned, then this also shallow clone



comparable and comparator
comparable - only one property will be sorted
    interface
    natural ordering
    compareTo()
    single sorting order
comparator - different sorting options 
    class
    compare()
    custom sorting
    multiple sorting orders.



solid
S — Single Responsibility Principle (SRP): A class should have only one reason to change.
O — Open/Closed Principle (OCP): Software entities should be open for extension, closed for modification.
L — Liskov Substitution Principle (LSP): Subtypes must be substitutable for their base types without breaking behavior. 
Use inheritance + overriding when all subclasses share the same behavior. Dont use overriding in parent class.. you can substitue child (use abstarct class or interface in case of having same behaviour)
I — Interface Segregation Principle (ISP): No client should be forced to depend on methods it does not use. "one purpose per interface" → prevents forcing unwanted methods.
D — Dependency Inversion Principle (DIP): Depend on abstractions, not on concrete implementations. Loosley coupled



concurrent and synch hashmap
concurrentHashMap
    failsafe
    no null key allowed
SynchronizedHashMap
    locked
    1 null key is allowed



Why hashMap accepts null and concurrentHashMap doesnot
Ambiguity
if (map.get("x") == null)
"x" exists but its value is null?
"x" doesn’t exist at all?
not relaible in concurrent env

In hashmap for null bucket 0 is allocated.. 
but it will cause ambiguty on if (map.get("x") == null).. use contiansKey before

since concurrentHashMap is concurrent we dont want this known ambigutiy so null is not allowed



bean
A Bean is an object managed by the Spring container. 
Spring Boot automatically scans and creates beans via component scanning (@Component, @Service, @Repository, @Controller).
You can also define beans explicitly using @Bean annotated methods in @Configuration classes.



bean lifecycle
creation -> injection -> initialization callbacks (@PostConstruct) -> destruction callbacks (@PreDestroy)



controller and restcontoller
Controller
    SpringMVC
    return ModelAndView.. used in JSP
    Controller + ResponseBody -> returns json
RestController
    @Controller + @ResponseBody
    return object(default serialized to JSON)