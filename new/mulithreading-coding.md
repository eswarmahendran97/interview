# mulithreading coding


## Thread vs Runnable
Thread is a class. It is used to create a thread 
Runnable is task created to execute using Thread or Executor service


##Create a Thread
Thread t = new Thread(() -> System.out.println(Thread.currentThread().getName()));


## Thread lifecycle
Thread t = new Thread() - NEW,
t.start() - RUNNABLE, 
obj.wait() - WAITING, //inside synchronized block
Thread.sleep() - TIMED_WAITING, 
t.stop() - TERMINATED //deprecated


##run() vs start()
t.run() // main
t.start() //Thread-0


##reuse code inside Thread
Runnable run = () -> {
    System.out.println(Thread.currentThread().getName());
    };

Thread t = new Thread(run);
Thread t1 = new Thread(run);


## make main thread to wait
Thread t = new Thread(run);
t.start();
t.join(); // main waits


## use 2 threads, 1 should print even, another should prints odd.. but synchronously

note: we need to use notify and wait. But you use it only in synchronized block
public class Test {
    
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        Thread t = new Thread(test::printOdd);
        Thread t1 = new Thread(test::printEven);
        t.start();
        t1.start();
        t.join();

    }

    private synchronized void printOdd() {
        for(int i=0; i<100; i++){
            if(i % 2 == 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            } else {
                System.out.println(i);
                notify();
            }
        }
    }

    private synchronized void printEven() {
        for(int i=0; i<100; i++){
            if(i % 2 == 1){
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            } else {
                System.out.println(i);
                notify();
            }
        }
    }
}


## notify() vs notifyAll()

notify - wakes only one waiting thread. Not safe because it can wake any thread (No order guarantee)
notifyAll - wakes all waiting thread. safe if condition to wait is used in while loop (even wrong thread wakes up, it goes back to sleep)

while(i%2 == 0)
    wait();


## sleep()
Thread.sleep()

note:
declaration is not like wait() or notify(). it is a static method.


## stop a thread
thread.stop(); // depricated and unsafe
use executorservice instead


## control one thread by another
Threads control with each other using shared memory (heap).

variable with static and volatile present in heap.
but static variable always gives you stale one

even though static is present in heap... for optimization each thread will caches it
so, modification will not be visible other threads

but in case of volatile, memory of the variable is present on in main memory(not cached)
so, each read need to be read from main memory.(which will have latest value)

note:
when you use synchronized, the JVM and CPU ensure that threads do not use stale cached values.
so, synchronization method or block is used, volatile is not needed.
Then how other thread knows the latest value:
When a thread exits a synchronized block, all changes to shared variables are flushed to main memory.
When another thread enters a synchronized block on the same lock, it reads the latest values from main memor


## control using volatile
down volatile is needed because synchronized blocks are not used

public class Test {

    static volatile boolean isEven = false;

    public static void main(String[] args) throws InterruptedException {

        Test test = new Test();
        Thread t = new Thread(test::printOdd);
        Thread t1 = new Thread(test::printEven);
        t.start();
        t1.start();
        t.join();

    }

    private void printOdd() {
        if(!isEven){
            System.out.println("Odd");
            isEven = true;
        }
    }
    private void printEven() {
        if(isEven){
            System.out.println("Even");
        }
    }
}


## producer-consumer
here volatile is not used, but memory is shared because of synchronization

public class Test {

    static int lag = 0;
    static int lag_limit = 10;


    public synchronized void produce() throws InterruptedException {
        while(lag >= lag_limit)
            wait();
        System.out.println("produced");
        lag++;
    }

    public synchronized void consume(){
        lag--;
        System.out.println("consumed");
        notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        Thread t = new Thread(() ->{
            for(int i=0; i<15; i++){
                try {
                    test.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t1 = new Thread(() ->{
            for(int i=0; i<15; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                test.consume();
            }
        });

        t.start();
        t1.start();
        t1.join();

    }
}


## synchronized block
public class Test {

    private final Object lock = new Object();
    private final List<String> list = new ArrayList<>();
    private final int limit = 5;

    public void produce() throws InterruptedException {
        synchronized (lock) {
            while (list.size() == limit) {
                System.out.println("Producer waiting");
                lock.wait();
            }

            list.add(String.valueOf(new Random().nextInt()));
            System.out.println("Produced");

            lock.notifyAll();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            while (list.isEmpty()) {
                System.out.println("Consumer waiting");
                lock.wait();
            }

            list.remove(list.size() - 1);
            System.out.println("Consumed");

            lock.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        Thread t = new Thread(() ->{
            for(int i=0; i<15; i++){
                try {
                    if(i == 5) {
                        Thread.sleep(5000);
                    }
                    if(i == 0) {
                        Thread.sleep(500);
                    }
                    test.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t1 = new Thread(() ->{
            for(int i=0; i<15; i++){
                try {
                    if(i!=0)
                        Thread.sleep(1500);
                    test.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();
        t1.start();
        t.join();
        t1.join();
    }
}


## concurrent hashmap

ConcurrentHashMap can be used in a multi-threaded environment without synchronized blocks, and concurrent get/put operations on the same key do NOT corrupt the map.
However, compound operations like read-modify-write are NOT atomic and can lead to race conditions.

ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

//safe
map.put("A", 1);
map.get("A");
map.remove("A");

but here also we have race condition.

//not safe
// THREAD 1
map.put("A", map.get("A") + 1);

// THREAD 2 (same time)
map.put("A", map.get("A") + 1);


So correct way using atomic apis

1) use atomic apis
map.merge("A", 1, Integer::sum);

2) compute
map.compute("A", (k, oldVal) -> UUID.randomUUID().toString()); // this is an atomic operation

3) atomic value type
concurrentHashMap<String, AtomicInteger> map = new ConcurrentHashMap<>();

map.computeIfAbsent("A", k -> new AtomicInteger())
   .incrementAndGet();


## get number of cores
int cores = Runtime.getRuntime().availableProcessors();


## executorservice

ExecutorService service = Executors.newFixedThreadPool(5, daemonFactory);
for(int i=0; i<10; i++){
    service.execute(() -> {
        System.out.println("Hi");
        Thread.sleep(1000);
    });
}
service.shutdown();
service.awaitTermination(5, TimeUnit.SECONDS);

if you dont use shutdown, your application wont terminate
if you dont use awaitTermination, your application will terminate before all sysout is printed (second 5 Hi wont be printed)
Its like t.join()


## use executor service as asynchronous

List<Future> futures = new ArrayList<>();
ExecutorService service = Executors.newFixedThreadPool(5, daemonFactory);

for(int i=0; i<20; i++){
    futures.add(service.submit(() -> {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // simulate work
        } catch (InterruptedException e) {}
    }));
}

for(Future f: futures){
    f.get();
}

Here no need to use shutdown or awaitTermination. f.get() will block everything and terminates once all executed


Important Note: 
By default, threads inside an ExecutorService are non-daemon threads, which means the JVM will not terminate until all these threads complete, even if the main thread has finished.
So, the application won’t stop immediately, and you can see that all System.out.println() calls are executed.
If you want the JVM to exit even while tasks are still running, you can use daemon threads for the pool.


## completeble future
With a normal Future
f.get() will block calling thread until task complete

//non-blocking asynchronous
 CompletableFuture.supplyAsync(() -> {
            Thread.sleep(2000);
            return 1;
        }
        ).thenAccept(System.out::println);
        System.out.println("Main completed");

result is not printed, since it is async


## Single CompletableFuture
CompletableFuture.supplyAsync(() -> 1).thenAccept(System.out::println);


## Two CompletableFuture with main wait

CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 1);
CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> 2);

// this will block still result comes
System.out.println(f1.get()); // Result 1
System.out.println(f2.get()); // Result 2


## Based on cores:

List<CompletableFuture<Integer>> futures = new ArrayList<>();

int cores = Runtime.getRuntime().availableProcessors();

for (int i = 0; i < cores; i++) {
    futures.add(CompletableFuture.supplyAsync(() -> 2));
}

// Wait for all futures to complete - add CompletableFuture using addoff and use join
CompletableFuture<Void> combined = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
combined.join(); // blocks until all are done

// Print results
for (CompletableFuture<Integer> f : futures) {
    System.out.println(f.join());
}


## supplyAsync vs runAsync
supplyAsync - return values
runAsync - return nothing


## large employee list computation

main(){
    int cores = Runtime.getRuntime().availableProcessors();
    System.out.println(cores);
    ConcurrentHashMap<String, Integer> dprtCount = new ConcurrentHashMap<>();
    List<List<Employee>> splitList = getSubList(inputEmployeeList, cores); //inputEmployeeList is input

    ExecutorService service = Executors.newFixedThreadPool(cores);
    for (int i = 0; i < splitList.size(); i++) {
        final int index = i;
        service.execute(() -> {
            Map<String, Long> localCount = splitList.get(index).stream()
                    .collect(Collectors.groupingBy(Employee::getDprt, Collectors.counting()));
            localCount.forEach((k, v) -> {
                dprtCount.compute(k, (key, oldVal) -> (oldVal == null ? 0 : oldVal) + v.intValue());
            });
        });
    }
    service.shutdown();
    service.awaitTermination(5, TimeUnit.SECONDS);
    System.out.println(dprtCount);
}

private static List<List<Employee>> getSubList(List<Employee> employees, int cores) {
    List<List<Employee>> splitList = new ArrayList<>();
    int chunkSize = employees.size() / cores;
    int prev = 0;
    for (int i = 0; i < cores; i++) {
        int next = Math.min(prev + chunkSize, employees.size());
        splitList.add(employees.subList(prev, next));
        prev = next;
    }
    return splitList;
}


## read file using multi threading

To read a file

Files.lines(path).forEach( line -> //execute line)

so,
1) we need to use Files.line
2) input to Files.line is Path (path of each file)
3) to get Path[] (files from directory) -> Files.walk(Path.get("file-path")).list();
4) iterate this file array and read files using Files.lines



Path path = Paths.get("/Users/e0m0k2a/Downloads");
Files.walk(path)