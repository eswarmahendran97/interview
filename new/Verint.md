Verint

Blocking queue
It’s commonly used in the Producer–Consumer pattern, where one or more producer threads put data into the queue and one or more consumer threads take data from it.
queue.put -> inserting
queue.take -> getting
queue.put or queue.take will be waiting when queue is empty (for consumers) or full (for producers)



Design pattern
Creational - Singleton
Structural - Adaptor : Adapting to Interfaces
Behavioral - Observer



spring security for jwt
1) pom.xml
2) create filter
3) Add filter SecurityConfig class



Threads

Thread vs Runnable
Thread - Class, Runnable - Functional interface(more preffered)

Runnable
Runnable task = () ->  System.out.println("Hello");
To execute a Runnable, you must pass it to a Thread or ExecutorService or Completable future
Thread t2 = new Thread(task);
t2.start();

Thread
new Thread(() -> System.out.println("Hello from a lambda expression!")).start();

Thread pool
Collection of reuable threads. It is done by ExecutorService
ExecutorService executor = Executors.newFixedThreadPool(3);
Future<String> future = executor.submit(task);
It returns future

Asynchronous programming
Future, CompletableFuture
use it when you want asynchronous and non-blocking operations

CompletableFuture.supplyAsync(() -> "Hello");

Deadlock
Thread waits for each other
Example: Ordering 2 items at a time. Order A check for shipping(locks), same time Order checks payment(locks). Now order A looks for payment and order looks for shipping charge
Solution:Use timeout

Live lock
Threads react to each other cause endless uncompleteble operation
Example: 2 customer trying to use same coupon code at same time... Both will retry for multiple times
Solution:Use delay

Stravation
Thread is not strarted because of low priority

Countdown latch
It is an aid which makes thread to wait until certain countdown of thread is completed

Cyclic barrier
Barrier to stop group of thread still that line code.



Flex and Flex box
Flexbox — layouts in a row or column(either one - one dimensional). It gives precise control over alignment, spacing, and item growth/shrinkage



Spread operator
allows an iterable (such as an array, string, or object) to be expanded or "spread" into its individual elements 
eg:
    Array
        const arr1 = [1, 2, 3];
        const arr2 = [...arr1, 4, 5]; // arr2 will be [1, 2, 3, 4, 5]

    Object
        const obj1 = { a: 1, b: 2 };
        const obj2 = { c: 3, d: 4 };
        const mergedObj = { ...obj1, ...obj2 }; // mergedObj will be { a: 1, b: 2, c: 3, d: 4 }



scroll, bind, apply
window.scrollTo({top:0}) -> scroll effect
document.getElementById("btn").addEventListener("click", this.handleClick.bind(this)); 
  handleClick() { console.log("Button says:", this.label);} -> binding object to a function (this to handleClick function)
const max = Math.max.apply(null, numbers); -> passes this and some arguments to function