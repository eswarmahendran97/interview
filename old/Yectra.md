Yectra Interview Questions
1) Difference between Set and List
Set is unordered -  doesnot maintains insertion order(LinkedHashSet can maintain insertion order), list is ordered - maintains insertion order
set is unique(if same value is added, it will replace old one), list is not unique
2)LinkedHashSet
It can maintain both insertion order and uniqueness. Using doubly linked option will maintain its insertion order.
3)Equals Operator
If two objects are compared, it will return false beacuse its hash code are different.
note : String class already overrides equals() method int it. So comparition works fine here.
Equals and hashCode in Java are two fundamental methods which are declared in Object class and part of core Java library. equals() method
You must override hashCode() in every class that overrides equals(). Failure to do so will result in a violation of the general contract for Object.hashCode(), which will prevent your class from functioning properly in conjunction with all hash-based collections, including HashMap, HashSet, and Hashtable.
equals() method is used to compare Objects for equality while hashCode() is used to generate an integer code corresponding to that object.
Default - equals() class provided by java.lang.Object compares memory location and only return true if two reference variable is pointing to the same memory location i.e. essentially they are the same object. 
HashMap and Hashtable in Java rely on equals() and hashCode() method for comparing keys and values
4)Steps to Override equals method in Java
Do this check
Do null check
if((obj == null) || (obj.getClass() != this.getClass())) { 
return false;
 }
Then compare the values of object
return 
id == guest.id && 
(firstName == guest.firstName || (firstName != null && firstName.equals(guest.getFirstName()))) && 
(lastName == guest.lastName || (lastName != null && lastName .equals(guest.getLastName())));

EG:
@Override public boolean equals(Object obj) { 
if (obj == this) { 
return true; 
} 
if (obj == null || obj.getClass() != this.getClass()) { 
return false;
 }
 Person guest = (Person) obj; 
return id == guest.id && 
(firstName == guest.firstName || (firstName != null && firstName.equals(guest.getFirstName()))) && 
(lastName == guest.lastName || (lastName != null && lastName .equals(guest.getLastName()))); 
}

5)We have two columns in a table(studentId, Dept). Find number persons in each department.
We can use groupBy for it.
SELECT COUNT(studentId), Dept
FROM College
GROUP BY Dept;

6) Comparing "null"  with equals()
eg:String i=null; String j=null;
if(i.equals(j))
Ans: throws nullpointer exception

