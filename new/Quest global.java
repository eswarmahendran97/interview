Quest global


Exception with causeException
throw new Exception("Wrapped", new IllegalException("hi"));

static
The static keyword in Java is mainly used for memory management, allowing variables and methods to belong to the class itself rather than individual instances.

Global exception handler

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}



ResponseEntity
new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);



second distinct largest
int largest = Integer.MIN_VALUE;
int second = Integer.MIN_VALUE;


for(int num : input){
    if(num == largest)
        continue;
    if(num > largest){
        second = largest; //min
        largest = num; //10
    } else if (num > second){
        second = num; // 5
    }
}

return second;


//RestAPI

@RestcController
@RequestMapping("api/v1/cart") // missed
class CartController{

    @Autowired
    CartService cartService;

    @GetMapping
    // @GetMapping("/{id}")
    public ResponseEntity<CardDto> getCartResponse(@RequestParam("id")int id, @RequestParam("name")String name) throws CustomeException{ //missed
        CardDto cartList = cartService.getCartBy(id, name);
        return new ResponseEntity<CardDto>(cartList, HttpStatus.SUCCESS); //missed
    }
}

@Service
class CartService{

    @Autowired
    CartRepository repo;

    public CardDto getCartBy(int id, int name) throws CustomeException{
        Optional<Cart> cart = repo.findById(id);
        if(cart.isPresent()){ //missed
            new ArrayList<Cart>(cart);
        }
        throw new CustomeException("Error occured");
    }

}

@Repository
interface CartRepository implements JpaRepository<Cart, int>{ //missed
}

@ControllerAdvice
public class GlobalExceptionHandler { //missed

    @ExceptionHandler(CustomeException.class)
    public ResponseEntity<String> handleIllegalArgumentException(CustomeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}



public class Test{	
	static int a = 0;
	int b=0;
	Test() {
	System.out.println(++a);
	System.out.println(++b);
	}
     public static void main(String []args){	
       	Test t1 = new Test();
	    Test t2 = new Test();
     }	
}
o/p:
1
1
2
1



Sort by second number

Arrays.sort(boxed, (a, b) -> {
            int lastDigitA = a % 10;
            int lastDigitB = b % 10;
            return lastDigitA-lastDigitB;
        });

        vs


int[] arr = {11, 23, 32, 45, 64};

List<List<Integer>> buckets = new ArrayList<>();
for (int i = 0; i < 10; i++) {
    buckets.add(new ArrayList<>());
}

for (int num : arr) {
    int rem = num % 10;
    buckets.get(rem).add(num);
}

Integer[] sorted = buckets.stream()
        .flatMap(List::stream)
        .toList()
        .toArray(new Integer[0]);