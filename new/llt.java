llt

Wrapper class
A wrapper class in Java is a class that wraps a primitive data type's value in an object. 
EgL int -> Integer
Autoboxing: The automatic conversion of a primitive type to its corresponding wrapper class object.
Unboxing: The automatic conversion of a wrapper class object to its corresponding primitive type.



hashmap vs concurrent hashmap vs synchronizedHashMap

Thread-Safe
hashmap - not safe to multiple threads wihtout synchronization
synchronizedHashMap - Safe
concurrentHashmap - safe to multiple threads

Locking 
hashmap - No internal locking
synchronizedHashMap- locks the entire map(one operation at a time)
concurrent hashmap - locking only buckets(on update or insert) so thread safe

Null key 
hashmap - Allowed
synchronizedHashMap - Allowed
concurrentHashmap- not Allowed

iterator 
synchronizedHashMap, Hashmap - failFast
concurrentHashmap - FailSafe

Synchronized map
Map<K,V> map = Collections.synchronizedMap(new HashMap<>());



marker interface
A marker interface in Java is an interface with no methods or fields. Says complier to handle differently
Eg:
public interface Serializable { }  // no methods → marker interface
If a class implements Serializable... jvm will recognize it and treat differently(basically a patch work)



Serialization
Serialization is the process of converting an object’s state (its data) into a byte stream (eg: to sent over network)



Lazy in streams
Intermediate operations are not executed immediately when they are defined. Instead, their execution is deferred until a terminal operation is invoked on the stream.
Why?
boolean res = Arrays.stream(input1).map(e -> {
            System.out.println("trans:"+ e);
            return e*2;
        }).anyMatch(e -> e == 4);
It will run through whole data in stream... will terminate when condition meet



Qualifier
@Qualifier is an annotation used to resolve ambiguity when you have multiple beans of the same type and Spring doesn’t know which one to inject.
Exception: NoUniqueBeanDefinitionException: expected single matching bean but found 2

@Component
@Qualifier("paypalService")
class PayPalPaymentService implements PaymentService {
    public void pay() { System.out.println("Paid via PayPal"); }
}

@Component
@Primary
class CardPaymentService implements PaymentService {
    public void pay() { System.out.println("Paid via Card"); }
}

// service
@Autowired
private PaymentService cardService; // cardService cause of name
@Autowired
private PaymentService something; // CardPaymentService cause of Primary



ResponseEntity
generic class that represents the entire HTTP response
It has not just the body, but also the status code and headers


Code:
String[] input = new String[] {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"}; //output 1,4,13
List<Integer> val = Arrays
                    .stream(input)
                    .flatMap( e -> Arrays.stream(e.split(","))) //[1, 3, 4, 7, 13], [1, 2, 4, 13, 15]
                    .map( e -> e.trim())
                    .map(e -> Integer.parseInt(e))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter(e -> e.getValue() > 1)
                    .map(e -> e.getKey())
                    .sorted().toList();


learnt 
    Function.identity() -> passing directly.. no lamda
    String[] to stream -> Array.stream(stringArr)



int[] arr1 = new int[]{3,4,5};
	    int[] arr2 = new int[]{4,6,1};
	    
	    
	    String a = IntStream.range(0, arr1.length).map(i -> arr1[arr1.length-1 - i]).mapToObj(e -> String.valueOf(e)).collect(Collectors.joining());
	    String b = IntStream.range(0, arr2.length).map(i -> arr2[arr2.length-1 - i]).mapToObj(e -> String.valueOf(e)).collect(Collectors.joining());

	    int sum = Integer.parseInt(a) + Integer.parseInt(b);
	    System.out.println(sum);
	    int[] res = String.valueOf(sum).chars().map(e -> e-'0').toArray();
	    
	    
		System.out.println(Arrays.toString(res));


statefull and stateless
stateless - sorted(), distinct(), limit() - process each element independently, without needing information about other elements in the stream
Stateful - filter(), map(), flatMap()


public static int getVowelCount(String word){
        long count = word.chars().filter(e -> "aeiou".indexOf(e) >= 0).count();
        return (int)count;
    }
    
	public static void main(String[] args) {
	    String input = "I have an apple and orange";
	    int k =2;
	    List<String> res = Arrays.stream(input.split(" ")).filter(e -> getVowelCount(e) >= k).toList();
		System.out.println(res);
	}



flatMap
multiple stream to single stream