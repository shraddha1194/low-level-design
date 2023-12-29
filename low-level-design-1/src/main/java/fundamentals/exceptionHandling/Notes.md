1. Why exception handling?

- To handling the failure case or cases that disrupt the normal behavior/set of instructor.

2. Where is used?

- If user creates Pair with null values then throw exception so that. STop objection creation so the use knows its invalid case. If we provide default values user will never know if its invalid case.
- Stop the control flow so user cannot proceed.

3. Fail Fast - Throw error as soon as possible

4. What is exception?

- condition that disrupts the normal behavior or normal flow of instructions.

5. Types of exceptions?
 
- Checked (compile time exception) and Unchecked exceptions (runtime exceptions).

6. Checked exceptions - checked at compile time, fileNotFound. Are very likely to happen. Mandatory to handle at compile time. 

7. Unchecked exceptions - is very dynamic we might not know what the data/value be when code runs. NullPointerExceptions, DivideByZero, IndexOutOfBounds.

8. Hierarchy of exceptions:

- Objects -> Throwable -> Exception, Error
- Exception -> Runtime exception
- Throwable - parent class of the errors or exceptions that mey occur
- Exception - condition that can be handled by developer
- Error - condition that more over cannot be handled by developer. Only at runtime (OutOfMemory, JVM Errors)

9. throw keyword - (method level) How to emit an exception?
- to throw an exception create object of exception
- then use throw keyword to raise exception and stop flow of control

10. throws keyword - used to raise an exception, to handle exception.  At method declaration.
- Is like passing around the responsibility. The caller method should be responsible to handle the exception.
- If method at every level throws exception then its responsibility of main method to handle it.

11. try catch block - try mean you will try to execute some line of codes but in case if some exception occurs then in that case you can catch it then handle what to do.
- try can exist without catch.

12. finally - for resource management and is always called.

13. final, finally, finalize
- final - cannot change the value of the field
- finally - resource management, always executed
- finalize - In Object call, just to perform operation before object shutdown

14. throw vs throws






