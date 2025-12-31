mark and sweep algorithim


Children c = new Parent(); // ❌ Compile error
Children c = (Children) new Parent(); // compiles but ❌ throws ClassCastException at runtime

Amazon sales

Notification service:

requirements
    notification by amazon to user
    kinds of notification -> sales started, order based, userLastAction
    avg users > 10M RPS
    High Throughput
    High Available
    User having account


Actors
    Notifier -> notify ther user
    User -> gets notified
    Device -> way of notification



Objects:

Take it in DDD(Domain driven development)


Domain: Ecommerce
SubDomain: Notification


Bounded Context -> NofiyUser
    Application layer:           
        NotificationService
            Conumer:
                key <string>: value<NoficationData>
            
           strategy pattern
            sendNotification

            Adaptor pattern
                emailAdpatee
                phineAdpartee
                whatAdaptee

                
        ACL

    Domain layer:
        SalesNotifcation -> Agreegate root (validations)
            SalesNotifcationData -> Original Objects
         OrderNotification -> Agreegate root (validations)
            OrderNotifcationData -> Original Objects
    Infrastructure layer:


Bounded Context -> Ana


 classs Nofication{


 }

class SalesNotifcation extends Nofication{
    
}

class OrderNotification extends Nofication{
    uuid productId;
}

class AvailablityNotification extends Nofication{
    uuid productId;
}

// DB

NoSql -> 
    SalesNotifcation
        {

        }
    OrderNotification
        orderStatus: {
            orderId;
            orderStatus;
            customer: Customer;
            msgSentTime;
        }
    AvailablityNotification
    Customer
        {
            id:
            name:
            Address: Address;
            phone: ''
            email:
        }
    Address{
        
    }



kafka -> msgTopic -> msgConsumer -> 



split and process list
Thumb rule: number of threads = number of cores

Parallel stream:
Map<String, Long> result =
    employees.parallelStream()
             .collect(Collectors.groupingBy(Employee::getDept,
                     Collectors.counting()));

ExecutorService:
ExecutorService pool = Executors.newFixedThreadPool(4);

Map<String, Long> finalResult = new ConcurrentHashMap<>();

List<List<Employee>> batches = split(employees, 200);

for (List<Employee> batch : batches) {
    pool.submit(() -> {
        Map<String, Long> local =
            batch.stream().collect(Collectors.groupingBy(Employee::getDept,
                    Collectors.counting()));

        local.forEach((k, v) -> finalResult.merge(k, v, Long::sum));
    });
}

pool.shutdown();
pool.awaitTermination(1, TimeUnit.MINUTES);

System.out.println(finalResult);



CompletableFuture:
int batchSize = 200;

List<CompletableFuture<Map<String, Long>>> futures = new ArrayList<>();

for (int i = 0; i < employees.size(); i += batchSize) {
    List<Employee> batch =
        employees.subList(i, Math.min(i + batchSize, employees.size()));

    CompletableFuture<Map<String, Long>> future =
        CompletableFuture.supplyAsync(() ->
            batch.stream().collect(
                Collectors.groupingBy(Employee::getDept, Collectors.counting())
            )
        );

    futures.add(future);
}

Map<String, Long> result = new ConcurrentHashMap<>();

futures.forEach(f -> {
    f.join().forEach((k, v) -> result.merge(k, v, Long::sum));
});

System.out.println(result);
