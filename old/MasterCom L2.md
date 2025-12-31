1) Why non primitive datatypes are used in Collections
Collections are used to manipulate object so non-primitive is used
New memory is created for each non-primitive type.. so while manipulating it useful

2) In HashMap how values gets Overwrite if exsists? How it finds newly added key already exsists?
 Eg: HashSet<String> myMap = new HashSet<String>(); 
        myMap.add("Hi");
        myMap.add("Hi"); 
Ans: HashMap works based on hashcode(). So "Hi" has a unique hashcode of its own. When "Hi" gets added again, if its hashcode is already present so it gets replaced.

3) Why userDefined Class need to override hashCode and equals?
Only then hashCode value will same for  userDefined  class object with same values.
Eg:
 ClassA a = new ClassA("hi");
ClassA b = new ClassA("hi");
if not override equals() and hashCode()
a and b will have different hashcode values
if equals() and hashCode() overrided
a and b will have same hashcode values

4) Use userDefined class  as a key's value in HashMap or  Set
 Eg: HashSet<ClassA> myMap = new HashSet<ClassA>(); 
Ans: 
userDefined class  Need to Override equals() and hashCode(), 
if not
HashSet<ClassA> myMap = new HashSet<ClassA>(); 
 ClassA a = new ClassA("hi");
ClassA b = new ClassA("hi");
myMap.add(a);
myMap.add(b);
In this case object are having same values but it will not get overwrite by another while adding in hashSet... Since hashcode values are different. Both the objects gets added in Hashset.(It should not happen)
So equals() and hashCode() method should be overloaded in ClassA.. which restricts above case.

5) Storing in Hashing?
Index = hashcode(Key) & (n-1)  ---n size of array in hashmap which is 16 (fixed)
Using above formula we calculate index(which will between 1 -16) and Stores the key in that palce. Which is called as bucket.

6)Hash Collison
While calculating index, two different keys can have same index. Will it replace the index?

Inside Index(Bucket) it works as linkedlist... So new key with different value for that index is stored in next node.

