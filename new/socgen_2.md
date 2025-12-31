mapping in db employee, dprt

class Employee{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id"
    Department department;
}

class Department{

    @OneToMany(mappedBy="department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Employee> employee
}



optimized memory in ui
optimize memory in java
view vs materialized view



Optimize memory in react
Use pagination, lazy load
cleanup
useMemo
Use compressed image


Reflection
used to inspect or modify classes, methods, fields, and constructors at runtime

Why It’s Usually Not Recommended
Performance overhead - types resolved at runtime
Breaks Encapsulation - It can access private methods, Reflection can bypass access modifiers


Materialized View
A physical table that stores the actual result of a query. Stores data physically on disk.


Function
Used for calcualtion. Returns one value
They cannot modify the database state
USed along with select, where, join
Does not support explicit transaction control

Stored procedure
It can perform data modification (DML operations) and does not need to return a value,
Cannot be used directly in SQL statements
Supports explicit transaction control.

Function returns a value and is used in queries.
Stored Procedure performs actions and may or may not return values.