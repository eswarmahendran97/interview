
int count=0;

Arrays.stream(new int[] {7,5,4,3,2,1,6,7,8,9,0}).forEach(x -> count++);

System.out.println(count);




System.out.println(Arrays.stream(new Integer[] {7,5,4,3,2,1,6,7,8,9,0}).collect(Collectors.groupingBy(x -> x%5)));



Why static can be used forEach:
When using lambda expressions or anonymous inner classes in Java, local variables used within these constructs must be either final or "effectively final". This means that you cannot modify these local variables after they have been initialized.

This restriction is in place because lambda expressions and anonymous inner classes can capture variables from their enclosing scope. Allowing modifications could lead to unpredictable behavior or issues with consistency, especially if the variable's value is changed outside the lambda.

So this kept it as immutability restriction in Lamda expression

Immutability of Stream Elements: Streams in Java are designed to be immutable, meaning their elements cannot be modified.
Scope of Variables: Variables declared outside a forEach loop have a wider scope than those declared inside. However, the elements of a 



what Transactional annotation accepts

create a new thread
In general, it is recommended to use the Runnable interface to create threads, unless you need to create a thread that needs to access and modify the state of another thread. The Runnable interface is easier to use and understand than the Thread class, and it is more flexible.


getvalue from environmental variable
for using in property file
java.home=${JAVA_HOME}
