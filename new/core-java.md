Core java

oops
overriding
    child cannot have weaker access modifiers
    child method cannot have broader checked exceptions
    overriden method cannot be final
exception handling
    exception order
    exception vs throwable
    CustomException
    compile time vs run time



Java internals

jdk using javac compiler converts .java to class file
JVM uses ClassLoader + JIT to run class file
ClassLoader 
    Loading
        Reads .class files and stores class metadata in the Method Area
    Linking
        Responsible for preparing the loaded class for execution
    Initialization
        Assigns actual values to static variables.
        Executes static blocks
Jvm Memory
    Method Area - class-level information like class name, parent class, methods, variables, and static data
    Heap Area - Stores all objects.
    Stack Area - stack frames on method call
    PC Registers - holds memory address
    Native Method Stacks

    Heap storage
        young gen
            Eden - Initial obj created
            Survivor - survived from Eden
        old gen - survived from Survivor
        permgen -  metadata of the class, methods. before java 8 - removed because it has fixed memory, so causing OutOfMemoryError
        Metaspace - replaces permgen, present outside heap. grows dynamically

    
Execution Engine - byte code to system language
    Interpreter - line by line
    jit - whole method



Garbage collection
    Algorithm: Mark-and-Sweep
    GC used:
        Java 8 : Parallel
        Java 8 + : G1

In Mark-and-Sweep GC, the JVM starts from all GC Roots, marks all reachable objects as alive, and then sweeps the heap to delete unmarked (unreachable) objects, reclaiming memory.

Roots:
    Stack References - local variables, Static variables, Method Area
    Active Threads
    JNI

    for local variable it checks stack frames in stack memory, if not present it is marked as unreached and acquired by gc

Memory leak:
The garbage collector removes unreferenced objects periodically, but it never collects the objects that are still being referenced. This is where memory leaks can occur

eg: Static List
potential memory leak is heavy use of static variables.

How to control this?
profilers - used for memory analysis in JVM


HashMap implementation:


class Node<K,V>{
    K key;
    V value;
    Node<K,V> next;
    Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

private int getIndex(K key) {
        return Math.abs(Objects.hashCode(key)) % capacity;
    }

once capacity changes.. we need to rehash