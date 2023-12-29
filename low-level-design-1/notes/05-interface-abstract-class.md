# Interface, Abstract Classes and Static Methods

## Interface
It as a reference in java, similar to class but accnot be instantiated. Contains only constants, method signatures, default methods, static methods and nested types. Method bodies exist only for default methods and static methods.

It is blueprint of behavior and used to achieve abstraction and multiple inheritance in Java.

**Why use interface?**
* to achieve abstraction
* due to multiple inheritance, it can achieve lose coupling
* define common behavior for unrelated classes.

```java
public interface Person {
    String getName();
    String getEmail();
}


public class User implements Person {
    private String name;
    private String email;
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getEmail() {
        return email;
    }
}
```

Interfaces can have default methods and attributes.
Attributes are static memeners ans automatically decalred as final.

## Abstract Classes
A class declared abstract is called abstract class. It may or may not include abstract methods.
Abstract classes cannot be instantiated, but they can be subclasses. When an abstract class is subclassed, teh subclass usually provides implementations for all of teh abstract methods in its parent class. 
However, if it does not, then subclass must be declared abstract.

**Why use abstract class?**
* It is used to achieve abstraction
* It can have abstract methods and non-abstract methods.
* When you don't want to provide the implementation of a method, you can make it abstract.
* When you don't want to allow instantiation of a class you can make it abstract.

```java
public abstract class Person {
    public abstract String getName();
    public abstract Strng getEmail();
}

public class User extends Person {
    private String name;
    private String email;
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getEmail() {
        return email;
    }
}
```

**Abstract class vs. Interface**

| Abstract Class                                                          | Interface                                         |
|-------------------------------------------------------------------------|---------------------------------------------------|
| Ideally define an entity.                                               | Ideally define characterization nased on behavior |
| Can have attributes                                                     | No attributes but static final constants          |
| Some or even all methods can be completely defined                      | No method is defined exception default methods    |
| One class can extend one abstract class                                 | One class can implement multiple interface        |
| Use when we want to restrict object creation or have incomplete enitity | Use to define characterization based on behavior  |
| When we have attibutes use abstract class                               | When we have no attributes use interface          |

## Static Methods
Static methods are methods that can be called without creating an isntance of the clas. They are declared using the static keyword.

Static keyword allow sto declare attributes and methods at class level instead of object level.

Static attributes ideally should only be used to declare constants. If you even need to modify a static variable, you codebase may be poorly designed. Ideal for declaring constants

**Why use static method?**
* You can call a static method without creating an instance of the class.
* You don't need to have separate implementations of the same method for each instance of the class.
* Mostly used for utility methods that don't depend on external attributes other than params passed.

```java
public class Person {
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static String getPersonInfo(Person person) {
        return person.getName() + " " + person.getEmail();
    }
}

public class User {
    public static void main(String[] args) {
        Person person = new Person("John", "Doee");

        System.out.println(Person.getPersonInfo(person));
    }
}
```


Additional:
https://www.baeldung.com/java-marker-interfaces#:~:text=A%20marker%20interface%20is%20an,also%20called%20a%20tagging%20interface.

Source:
https://github.com/kanmaytacker/fundamentals/blob/master/oop/notes/04-interfaces-abstract.md