# Programming Paradigms

Paradigms is way to do something (writing code / structure code/ organize code).

There 2 types of programming paradigms:
* **Imperative** - an imperative program consists of command for the computer to perform to change state. ex - C, Java, Python, etc.
* **Declarative** - focuses on what the program should accomplish without specifying all the details of how the program should achieve the result. ex SQL, etc.

### Procedural Programming

Procedures simply contain a series of computational steps to be carried out.

Think of all programming as managing the relationship between two fundamental concepts: state and behavior

State is the data of your program ans behavior is the logic.

Procedural Programming is based on implementing these two concepts separately.
State is held in data structures.
Behavior is held in functions (also known as procedures or subroutines). 
A procedural application therefore passes data structures into functions to produce some output.

Each function may eventually call each other function. Execution of code starts from a special procedure main.

Procedural code thinks of the actions that it has to perform as a series of steps. Imagine you want to transfer some money from one account to another. These are the following steps that you would take:
* Open the source account
* Withdraw the money
* Open the destination account
* Deposit the money in destination account

Drawbacks:
* No clear definition of what happens where.
* difficulty to understand a complex software system.
* difficult to debug a bug
* spaghetti like code

### Object-Oriented Programming

Entities are the core in OOP. 
Every entity has control of all the actions that can happen on it.

Implements state and behavior together into Object, thus providing potential for information hiding.

**Advantages**:
* Reusability - Through classes and objects and inheritance of common attributes and functions,
* Security - Hiding and protecting information through encapsulation.
* Maintenance - Easy to make changes without affecting existing objects much.
* Inheritance - Easy to import required functionality from libraries and customize them, thanks to inheritance.

**Disadvantages**:
* Beforehand planning of entities that should be modeled as classes.
* OOPS programs are usually longer than those of other paradigms
* [Banana-gorilla problem](https://dev.to/efpage/what-s-wrong-with-the-gorilla-2l4j#:~:text=Joe%20Armstrong%2C%20the%20principal%20inventor,and%20the%20entire%20jungle.%22.) - You wanted a banana but what you got was a gorilla holding the banana and the entire jungle.

### Abstraction
Representing a complex system in terms of different ideas (entities) talking to each other.

terms of idea - meaning things that have info and behavior associated with them.

Abstraction is a mechanism which represents the essential features without including implementation details.

ex - coffee machine in kitchen, we need to know methods of the object that are available to call and which parameters they need to trigger specific operation. 
We don't need to understand how the method is implemented and which kind of action it ha sto perform to create expected result.

Advantages:
* creates boundary between application and the client code. This reduces design and implementation complexity.
* Separates the responsibilities into software entities (class, method etc) that only know the required funcytionality of each other but not how it is implemented.
* makes code easier to understand and avoid code duplication. More reusability.
* easier to make changes to concrete class without affecting interfaces.
* increases the code security as only relevant details will be provided to the users.

### Encapsulation
Encapsulation refers to bundling of the data with the methods that operate on the data or restricting the direct access of some object's components, such that users cannot access state values for all of the variables of a particular object.

**Advantages:**
* Hiding data - User don't know how classes are implemented or stored but only know the values being passed and initialized.
* More Flexibility - More control over read and write operation on an object.
* Easy to reuse - easy to change and adapt to new requirements.

### Classes
A class is a blueprint for creating objects, providing initial values for the state, and implementations of the behavior.

When an object is created by a constructor of teh class, the resulting object is called an instance of the class, and the member variable specific to the object are called istance variables, to contrast with the class variables shared across the class.
to access the member variables we use dot operator(.).
------------------------------------------------




**Resources**
* [Github - Tanmay](https://github.com/kanmaytacker/fundamentals/blob/2023/august/advanced/oop/notes/01-oop-introduction.md)