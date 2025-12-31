Handle large number of request
FrontEnd: Checking Logic, minification, gzif(ziffing html and sending)
BackEnd: MicroService, optimized code
Database: Ecache, Connection Pooling
Handling large number of user requests primarily depends on the computing power of your platform layer. How much load your infrastructure can take. That is stress/load testing of the app.
Good Cloud Server	
Multiple Servers with load balancer

Same Domain for 2 Servers
Yes its possible. When a client uses the domain name and sends the request, Loadbalancer distributes between one of the two server.

Load Balancer
Load Balancer is a Physical device which is mapped with the required servers, which analysis state of those server(like disk memory,cpu performance..) and then send the receiving request to one of the server. It help when large number of request are receving. At that time it checks which server is free and sends request to that server.

Apache Ignite
Its an inmemory database, Instead of storing values in request we can store in it. Reason is, in rare case request may be changed from one server to other server by load balancer at that time values in the request will be erased.
