Java Interview questions

Java 8 date

LocalDate.now(); //2025-08-08
LocalTime.now(); //08:45:13.472311
LocalDateTime.now(); //2025-08-08T08:45:13.472315

timestamp
Instant now = Instant.now();


create
LocalDate date = LocalDate.of(2025, 8, 8);

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
LocalDate date = LocalDate.parse("08-08-2025", formatter); //2025-08-08

Format
date.format(formatter) //08-08-2025

compare two dates
LocalDate.now().isAfter(otherDate);
LocalDate.now().isBefore(otherDate);

add/subtract days, months, years
LocalDate.now().plusDays(10);
LocalDate.now().minusMonths(2);


HashMap

1)HashMap<K,V> map = new HashMap<>(); 
creates bucket of size 16

2) map.put(K,v) 
will create a hash for key 
int index = (n - 1) & hash;
find the index based on that key

3) 3 possiblities
Bucket empty -> insert new node
While hashing the key, and getting the index. we may get same index(bucket)
Bucket has same key(find by equals method) -> replace it
Bucket has different key → insert it as LinkedList until size 8 and map size less than 64. 
after 8 Treeify will happen and table capacity ≥ 64. will convert to RedBlack tree. if reduce to 6 untreeify will happen