What callable returns?
Callable will be used only in Executur service
Even though call() -> returns type V
while executor.submit(callTask) -> returns future


callable is blocking
Callable<Integer> task = () -> {
    Thread.sleep(2000);
    return 42;
};

Integer result = task.call();  // ⛔ Blocking — waits 2 seconds here
System.out.println(result);

Future
Future → requires an ExecutorService
Future is non blocking
But future.get() is blocking


Why completeble future
It doesnt require ExecutorService
CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> 42);

It has functional-chaining

how it is truely non-blocking?
    register a callback that runs when the result becomes available


Volatile

Thread has 2 cache
    local cache
    shared cache

When not using volatile, 
one thread will not know the present value of variable because that particular thread stores that value in local cache
So when another updates the value, other threads will not know the updated value

While using volatile
Thread stores the value in shared cache, so all thread will knows it


Atomicity
Atomicity = an operation happens completely or not at all, with no partial effect.

Incase of java
variable int a = 0;
Thread t1 => increment => a++ => 1
Before t1 completes Thread t2 => increment => a++ => 1

So output is wrong, expected: 2

we can use synchronized blocks or AtomicInteger (internally uses CAS)


DB
Many to Many

2 ways
Cart
    productId
    userId
    quantity
issue here is, when user add a product which he have already in cart, we have a lookup and update

Cart
    cartId(autoincrement)
    userId
    productId
    quantity
here we use sarrogate key, user can directly insert



How to optimize query search
indexing
temp query or materialized view



clustered vs non clustered indes=x
clustered - determines order of data (primary key)
non clustered - has pointers to physical row

