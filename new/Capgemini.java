Capgemini

Pridicate<> pre = (n) -> n%2 == 0;
boolean ans = pre.test(input); //forgot the method name
sout(ans);


try{

int a = 10/0;

}

catch( ArithmeticException e){ // true
S.o.p("Arithmetic Exception");
}

catch(Exception e){
S.o.p("Exception");
}

catch( NumberFormatException e){
S.o.p("NumberFormatException");
}
 


String s1 = "Java";  
String s2 = "Java";  
StringBuilder sb1 = new StringBuilder();  
sb1.append("Ja").append("va");  
System.out.println(s1 == s2);  //true
System.out.println(s1.equals(s2));  
System.out.println(sb1.toString() == s1);  //false
System.out.println(sb1.toString().equals(s1)); //true


Java 8 feature


collections to sort
PriorityQueue with any comparator it will sort automatically
TreeSet

Avoid calling the backend multiple times when handling large data (e.g., lakhs of records) in the UI.
cache it
 


Loadfactor
Hashmap -> capacity * loadfactor 
HashMap<String, String> map = new HashMap<>(16, 0.75f);
Threshold = capacity × load factor = 16 × 0.75 = 12
When the number of entries exceeds 12, the capacity will double (rehash occurs).
Default capacity: 16

ArrayList
Initial capacity = 10 (internal array size)
When you add the 11th element, ArrayList grows: 1.5
Default capacity: 10 elements