
1) Nth largest salary
Select * from Employee e1 where N-1 = (Select COUNT(DISTINCT e2.salary) from Employee e2 where e1.salary < e2.salary);


2) Employee with duplicate name
Select * from Employee e1 where e1.emp_id IN (Select emp_id from Employee e2 group by e2.emp_id having count(*) > 1);


3) Department wise max salary
Select department, MAX(salary) from Employee group by department;

Select * from Employee e1 where salary = (select MAX(salary) from Employee e2 where e1.department = e2.department)


4) N+1 Problem
Occurs when using ORM

Query 1 (The "1"):

SQL

SELECT * FROM authors;
(This fetches N authors, let's say N=100).

Queries N (The "N"): Inside a loop that iterates over the N authors, a query is executed for each author to get their books:

SQL

SELECT * FROM books WHERE author_id = 1; -- For Author 1
SELECT * FROM books WHERE author_id = 2; -- For Author 2
...
SELECT * FROM books WHERE author_id = 100; -- For Author 100

so 100+1 queries here

instead we can use joins


5) Join vs Fetch join
Fetch join -> eager fetching