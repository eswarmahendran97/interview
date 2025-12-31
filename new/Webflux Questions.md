Webflux Questions

1) how to use blocking jdbc with webflux
Wrap JDBC calls in:
Mono.fromCallable(() -> jdbcCall()).subscribeOn(Schedulers.boundedElastic());

2) sample code
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

Flux.fromIterable(names)
    .filter(name -> name.length() > 3)                // Filter names with length > 3
    .map(String::toUpperCase)                         // Convert each to uppercase
    .doOnNext(name -> System.out.println("Filtered: " + name)) // Log each element
    .flatMap(name -> simulateRemoteCall(name))        // Simulate async operation
    .onErrorResume(e -> Flux.just("Fallback"))        // Handle errors gracefully
    .collectList()                                    // Convert back to List
    .subscribe(result -> System.out.println("Final List: " + result));
Thread.sleep(3000);