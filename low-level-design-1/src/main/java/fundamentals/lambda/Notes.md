Java is too verbose.

Requires a lot of code to just print multiple threading Hello world
- create class that implements Runnable

### 1. you can pass anonymous class to Thread
For anonymous classes - class file is created
Syntactic sugar.
```java
Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("Tantia Tope is on: " + Thread.currentThread().getName());    
    }
});
thread.start();
```

### 2. SAM - Single Abstract Methods

What is functional interface? - An interface that has only one abstract method
We can replace functional interface with one liner.
ex. Runnable, Comparable (method compareTo)

Inline replacing functional interfaces:

we are providing the implementation of that only one abstract method:
This works because we are using constructor of Thread which accepts Runnable
```java
Thread thread = new Thread(() -> System.out.println("Tentia Tole"));
thread.start();
```
is same as:
```java
Runnable runnable = () -> System.out.println("Tentia Tole"));
Thread thread = new Thread(runnable);
thread.start();
```

Parametrised Lambda Functions:
```java
(a, b) -> {}
```
parameter list, arrow (separate parameter from lambda body), lambda body

In case single operation:
String is return type.
if without {} then it will return the value of the lambda body.
```java
Callable<String> callable = () -> "Tentia Tope";

Future<String> value = Executors.newSingleThreadExecutor().submit(callable);
Syste.out.println(value.get());
```
Method reference - just less code, looks cool.
Why use lambda functions to just call a method, use method reference
Won't be able to pass arguments - explicitly

In case of multiple lines of codes:


Functional interfaces can have default and overloaded methods

Why lambda used for only functional interface? - if multiple abstract methods who will compiler know fo which method the implementation is provide.
