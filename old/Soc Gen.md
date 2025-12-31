Return Type of Overrided method
It can be different (co variant return type)

Exception handling on Overrided methos
If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception but can declare unchecked exception.
If the superclass method declares an exception, subclass overridden method can declare the same subclass exception or no exception but cannot declare parent exception.

Exception Hirarecy


Checked vs Unchecked Exception
Checked Exception - Compile time (filenot found exception)
Unchecked Exception - Run time (null pointer)

Custom Exception
class InvalidAgeException  extends Exception  
{  
    public InvalidAgeException (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
    }  } 

Java 8 improvement in HashMap
HashMap replaces linked list with a binary tree when the number of elements in a bucket reaches certain threshold.

FlatMap 
Flattning into single stream
Before
[ [2, 3, 5], [7, 11, 13], [17, 19, 23] ]
After
[ 2, 3, 5, 7, 11, 13, 17, 19, 23 ] 

Lazy Initialization 
Initialized after application context. Can be initiated by property file or using lazyInitialization(true) in spring boot application

SQL
SELECT  name, email, COUNT(*) FROM users GROUP BY name, email HAVING COUNT(*) > 1

JVM Architecture



PemGen vs Old Gen
Eden Space(Young Generation) - Object while creation
Survivor Space(Young Generation) - Object Survived from Eden space after GC
Old Generation - Object Survived from Young gen space after GC

Concurrent HashMap
FailSafe
Synchronized

Types of Thread Generation
Thread
Runnable
Thread Constructor

Garbage Collection Algorithm
All Algorithm internally uses mark and Sweep approach
Serial GC - SIngle Thread
Parallel GC - Multi Thread
Concurrent Mark Sweep GC - Multi Thread run along with System Thread
G1 GC - heap is divided into regions and then collection of regions are marked as young/old generation and gc runs on few regions and not on whole heap
Full Garbage collection can be achived by clearing Young, Old and Permanent Generation Memory
