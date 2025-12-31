Athena

Java
Stack Implementation

Design pattern

React

DB
SELECT c.first_name, c.last_name, sum(o.amount) as sumAmount,count(order_id), o.amount from Customers c join Orders o on c.customer_id = o.customer_id group by o.customer_id having sum(o.amount) > 500;