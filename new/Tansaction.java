List<Transaction> transactions = Arrays.asList(
    new Transaction("user1","Amazon", 4950,"10:00"),
    new Transaction("user1","Flipkart", 5000,"10:10"),
    new Transaction("user1","Paytm", 5050,"10:13"),
    new Transaction("user1","Swiggy", 2000,"10:15"),
    new Transaction("user2","Zomato", 3000,"11:00"),
    new Transaction("user2","Zomato", 3050,"11:01"),
    new Transaction("user2","Zomato", 3100,"11:02")
);
 
same user
different vendor
value difference is Rs.50
within 15 mins
 

 // streams

List<Transaction> filtered = transactions.stream()
    .collect(Collectors.groupingBy(Transaction::getName))
    .entrySet()
    .stream()
    .map( e -> {
        ListTransaction> trans = e.value().stream().collect(
        Collectors.groupingBy(Transaction::getVendor), Collectors.counting())
        .entrySet().stream()
        .filter(a -> a.getValue() == 1)
        .map(e.getValue())
        .toList();

        return 
        }).toList();
 


 