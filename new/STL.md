STL

Thread

1)
Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        t.start();
        t.run();

start uses new Thread
run uses main Thread

2)
How t.start() works internally
The JVM asks the OS thread scheduler to allocate a native thread.
That native thread is bound to your Java Thread object.
Once the thread finishes run(), the OS marks that native thread as dead/terminated.


3)
t.start();
t.start();

Throws expection
reason:
Once the thread finishes run(), thread will be dead
You can not reuse it. You need to create new one


Polymorpism

Access modifier
// wont work 
class Parent{
    protected void method(){
        System.out.println("Parent");
    }
}

class Child extends Parent{
    void method(){
        System.out.println("Child");
    }
}

weaker preveleage. child cannot have weaker access


Exception

// wont work 
class Parent{
    protected void method() throws IOException {
        System.out.println("Parent");
    }
}

class Child extends Parent{
    protected void method() throws Exception {
        System.out.println("Child");
    }
}

Checked exceptions (like IOException, SQLException, etc.):
The overriding(child) method cannot declare broader checked exceptions than the overridden(parent) method.

Unchecked exceptions (RuntimeException and subclasses):
no restriction.


// wont work 
class Parent{
    protected Integer method() {
        return 1;
    }
}

class Child extends Parent{
    protected int method() throws RuntimeException {
        return 1;
    }
}


Final
// wont work 
class Parent{
    final void method() {
        System.out.println("Parent");
    }
}

class Child extends Parent{
    final void method() throws RuntimeException {
        System.out.println("Child");
    }
}
overriden method cannot be final


static

class Parent{
    static void method() {
        System.out.println("Parent");
    }
}

class Child extends Parent{
    static void method() throws RuntimeException {
        System.out.println("Child");
    }
}

Parent parent = new Child();
parent.method(); //Parent

For static methods → compiler decides at compile time.


Exception order

static void method() {
        try{
            throw new IOException();
        } catch(java.lang.Exception e){
            System.out.println(e.getMessage());
        } catch(IOException io){
            System.out.println(io.getMessage());
        }
    }

Throws compile time error. Exception is already caught

// wont work
static void method() {
        try{
            throw new IOException();
        } catch(IOException | java.lang.Exception io){
            System.out.println(io.getMessage());
        }
    }



Oops
Encapsulation -> getter, setter - hiding variable
Abstraction -> Interface, Abstraction - hiding the implementation
