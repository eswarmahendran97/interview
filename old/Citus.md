i.Types of dependency injection
1)Constructor Injection
private Address address;
    @Autowired
    public Person(Address address) {
        this.address = address;
    }
If it has more than one child class u need to use @qualifier
@Autowired
@Qualifier("address1")
    public Person(Address address) {
        this.address = address;
    }

2)Setter Injection
@Autowired
    public void setAddress(Address address) {
        this.address = address;
    }

3)Property Injection
    @Autowired
    private Address address;


ii.Clone()
If we directly copy the object, when one object gets changes the copied object also will be changed (since same memory). So Clone() is used.
To we use Clone() to make exact clone of the object with different memory(hashcode). The base class show implement Clonable

iii. Shallow and Deep Copy
Eg: Parent.java implements clonable{
@overide clone(){}
}
main{
Parent a = new Parent();
Parent b = p.clone();}
At this time a and b will have different memory but Child we have one memory.
So lets have
Child.java extends Parent{
int i;
setI(int i){this.i = i;}
getI(){return i;}
}
example a.setI(10) and we use b.getI() will not return null it will return 10. But p and p1 are different object. It is called as Shallow copy
To avoid this we Deep Copy
Deep copy is nothing but Child class should also implements Clonable. Now above issue will get resolved.


