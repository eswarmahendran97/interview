HCL
immutable class
All fields are final
No setters, only constructor
Class is final (cannot be extended)
If it has mutable fields (like List), return defensive copies (new ArrayList<>(hobbies))
note: record is immutable


soa vs microservice
Soa - Multiple responsiblities with same DB


int[] intArray = {1, 2, 3, 4, 5};
List<Integer> list = Arrays.stream(intArray).boxed().sorted().limit(3).toList();


idempentcy
POST: A POST request typically creates a new resource, so repeated POST requests with the same payload would create multiple identical resources
GET, PUT - will return same for same input


thread lifecycle
New - Thread t = new Thread();
Runnable - t.start()
Running - picked by scheduler
Waiting - sleep()
Blocked
Terminated


es6
Arrow function
Promise
Classes
Spread opearator
generator function
map, set
For..of Loop


array dependency - dependency array in hook


redux vs contextAPI
Context API: Great for small apps, simple global state (theme, auth, language).
Redux: Better for complex apps, multiple API calls, predictable updates, large team collaboration, and debugging.


jenkins job
Create a new Jenkins item in Jenkins and select Pipeline.
Connect the job to your GitHub repository by providing the repo URL and branch.
Create a Jenkinsfile in your project repository.
Define the pipeline stages in the Jenkinsfile (Checkout, Build, Test, Deploy).
Configure build triggers (webhook, SCM polling, or scheduled builds).
Run the pipeline and monitor the stage-wise execution and logs in Jenkins.