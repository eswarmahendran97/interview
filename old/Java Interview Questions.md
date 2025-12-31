Collections Interview Questions

Use of Collection
Collections are used to manuipulate and store data in form of object

Lamda Expression
The Lambda expression is used to provide the implementation of an interface which has functional interface
 new Thread(()-> {System.out.println("New thread created");}).start();

Functional Interface
A functional interface is an interface that contains only one abstract method

 interfaces used in Collection framework
List,Set,Map,Queue,Dequeue

Class in List
ArrayList, LinkedList and Vector

Vector vs Arraylist
vector-synchronized
Arraylist- non Synchronized

ArrayList vs LinkedList
ArrayList- ArrayList is better to store and fetch data.
LinkedList- LinkedList is better to manipulate data since it uses doubly linked list

List vs Set
List-Contains Duplicate elements
Set-Contains only unique elements

Set Internal working
Set/HashSet internally uses map. add() method in hashset contains map.put() method inside it.

Hashset vs Treeset
HashSet maintains no order whereas TreeSet maintains ascending order.
HashSet impended by hash table whereas TreeSet implemented by a Tree structure.

Set vs Map
Map-key(unique) and value(non unique)
Set-value(Unique) only

override equals() method?
The equals method is used to check whether two objects are the same or not. If values are equal for object hashcode() can generate same hashnumber for the values

The default size of load factor is 0.75

Stream.reduces()
Reduces the large number of data into single data

Stream.map()
Transforms a list a value to list of another values
 list.stream().map(number -> number * 3).forEach(System.out::println);
now new list have multiple of 3

JDK,JRE,JVM
JDK=JRE+Development tool(to provide an environment to develop your java programs, also have JavaC compiler)
JDK converts .java file to .class file using JavaC compiler and sends it to JRE
JRE=JVM+Library class(io libraries)
JVM
Class loader-loads the class file(initializes the static class)
byte code verifier-verifies the byte code in .class file
Execution Engine - JIT compiler interprets the byte code to native code and makes the execution

Inner Class vs Sub-Class
Inner class - nested class
sub-class - Inherited class

Access specifiers
Public,private,protected and default
default(can be accessed only from package not from other package)

Break vs Continue
Break-breaks from for loop
Continue-Continue the next iteration without execute remaining

Replacing Switch
Instead of switch we can use functional interface and Map in java and Object literals in JS

Compiling Java file in CMD
Assuming we are in .java file location
javac <filename.java>   --> generates class file
java <class file name>

serialization
Object is converted to bytestream and transmitted over the network.

Supplier
Functional Interface.. consist of get() method
can store any Type T and can retrived using get() method

String literal and New String object
String Literal - String name = "eswar";
New String Object - String name = new String("eswar");
Both get stored in heap memory. But new String Object() creates new reference, if String with same value is declared already present. String literal gets stored in string pool, if new string literal is declared with same value already present in pool it does not store it again in pool.

String immutable:
once value has been assigned to a string, it can't be changed and if changed, a new object is created. 

Garbage Collection
Deamon tread is used for garbage collection. When a object has no reference it get garbage collected.

Object creation using Constructor
If constructor is not defined then using default constructor object is created

States of Thread
Ready,Running,Waiting ,Dead

failfast
While using iterator in list, map, set in collection when we try to add or put element while iterating(inside the loop). It throughs exception. It is done by failfast.

failsafe
Using a CopyOnWriteArrayList type of List and adding a element while iterating the list will not through error or expection becuase failsafe handles it as seperate collection but will not add it in current iteration.
Using ConcurrentHashMap we can add value while iterating without any error

methods in Object class
getClass(),clone(),hasCode(),equals(),toString(),notify(),notifyAll(),wait(),finalize()

Comparable and Comparator

Fetch Second Largest - Query





