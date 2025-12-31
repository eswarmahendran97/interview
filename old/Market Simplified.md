Encapsulation
 wrapping the data (variables) and code acting on the data (methods) together as a single unit. In encapsulation
Technically in encapsulation, the variables or data of a class is hidden from any other class and can be accessed only through any member function of its own class in which it is declared.
To achieve encapsulation(Data Hiding) in Java −
Declare the variables of a class as private.
Provide public setter and getter methods to modify and view the variables values.

Why Getter and Setter Method
Data Hiding - User have no idea about inner implementation. We can process the obtained data and we can set it. User cannot directly access the variable and can store invalid value in it because  in setter method we can have precheck code.
Increased flexiblity - We can make the data either readonly or write-only
Easy to test

Data Abstraction
Only the essential details are displayed to the user. If a user using a child class he knows only the functionality of child class. He dont know about the functionality of parent class
In java, abstraction is achieved by interfaces and abstract classes. We can achieve 100% abstraction using interfaces
Data Encapsulation is hiding data or information while Abstraction is hiding the implementation details.
Eg:HashMap

Java Statement
Parent class of prepared Statement. Cannot be used with parameters. Useful when creating, altering and droping a table
Statement GFG = con.createStatement();  
GFG.executeUpdate("CREATE TABLE STUDENT(ID NUMBER NOT NULL, NAME VARCHAR)"); 

Java PreparedStatement
The PreparedStatement interface is a subinterface of Statement. It is used to execute parameterized query.
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
PreparedStatement stmt=con.prepareStatement("select * from emp");  
ResultSet rs=stmt.executeQuery();  
while(rs.next()){  
System.out.println(rs.getInt(1)+" "+rs.getString(2));  
}  

BinarySearch Program
public class Main
{
    static int findElement(int arr[],int firstIndex,int lastIndex, int key){
        while(firstIndex<=lastIndex){
        int middleIndex = firstIndex+lastIndex >>> 1;
        System.out.println(middleIndex);
        if(arr[middleIndex] == key){
            return middleIndex;
        }
        else if(arr[middleIndex] > key){
            lastIndex = middleIndex - 1;
        }
        else {
            firstIndex = middleIndex +1;
        }
        }
        return -1; 
    }
	public static void main(String[] args) {
		int arr[]={1,2,3,4,5,6,7,8,9};
		int i = findElement(arr,0,(arr.length-1),11);
		System.out.println(i);
		}
}
