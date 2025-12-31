when one microservice is slow, it can drag down others, causing cascading failures across the system?
timeout in webclient + circuit breaker + bulkhead(allocat threads for service call)

Possible cause for hashmap slowness
too many hash collison
high load factor -> results too many collision
Frequest rehashing -> when resize happens


