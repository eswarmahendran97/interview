ACID Priciple in SQL
A-Atomicity(Transaction fully completed else rollback)
C-Consistency(DB should be relaible or consistent)
I-Isolation(Multiple transactions should be Isolated from one another)
D-Durability(Transaction should be successfull even though system failure occurs)

CAP Theorm in NoSQL
C-Consistency(Database should be consistent, Read and write should not throw error)
A-Availablity(all working nodes in the distributed system return a valid response for any request, without exception)
P-Partition Tolerance(System continuos to run despite the node is down)

Advantages of NoSql:
Can Store non uniform data(text,email,images)
Can store large data easily

Postgresql
ORDMS-Object Relational Database model system
Opensource
Supports table inheritance and function overloading

Procedure vs Function
Function-Must return a single value. Uses only select query inside it. No Try catch
Procedure-Can return multiple values, zero and single values. Uses all type of queries inside it. We can use try catch

Difference between Agile and Waterfall model
Agile performs testing concurrently with software development whereas in Waterfall methodology testing comes after the “Build” phase.

SOAP(Simple Object Access Protocol) vs REST(Representational State Transfer)
SOAP-Uses only XML format for request and response. More secure due to WS security
Rest-Uses XML,JSON,TEXT,HTML(get,post,put,patch and delete) format for request and response. Less secure than SAOP

PUT vs Patch
Both used for Updating a record
PUT - when you want to change the first name of a person in a database, you need to send the entire resource when making a PUT request. Response dont have body
PATCH - When you want to update the first name on a database, you will only be required to send the first parameter; the first name when making PATCH request. Response has body

CI/CD
CI-Continuos Integration(Continuosly developed and merged by developer)
CD-Continuos Deployment(Directly deployed by Developer and used by customer)
CD-Continuos delivery(Delivered to operational team and they deploy it. Then it is used by Customer

Scrum Methodology
Scrum in Agile is a process that allows software development teams to focus on delivering. Here we use Sprint(helps for rapid delivery)

Connection Pooling
As per the Object pooling design pattern, the application creates an object in advance and place them in Pool or Container. Whenever our application requires such objects, it acquires them from the pool rather than creating a new one.

Parallel Calls
Use @Async before a method. This parallely executes methods without any delay

Token vs Session

throttling 
When requests Exceeds the threshload limit, the server throttles and send error 429

JSON Batching
JSON batching allows you to optimize your application by combining multiple requests into a single JSON object. Thus avoids throttling

ArrayList vs Vector
Both implements List
Vector Synchronized and Arraylist non-synchronized

Kafka
distributed event streaming platform. Kafka is a platform that stores data from producer and sends to consumer.
why? If system got failed with out kafka, It again restarts the job from first. So to avoid it kafka is used. Kafka uses check points to know the failure area.
Kafka also handles millions of messages or data in a second.
Using Kafka we can handle message between system or application or services

MicroService
Microservices are an architectural style that develops a single application as a set of small services. Each service runs in its own process. 

JIRA
This software is used for bug tracking, issue tracking, and project managemen

GIT vs Stash
Git - This repository tracks all changes made to files in your project, building a history over time. 
Stash or GitLab or GitHub- Stash is a repository management system. It can be used to manage Git repositories(version control system ).
Git and Stash are working together.
Why Stash or GitLab or GitHub?
Security,Tools can be integrated(bamboo, JIRA, SONAR) etc
