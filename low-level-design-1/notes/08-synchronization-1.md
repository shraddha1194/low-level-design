# Synchronization

## Adder and Subtractor Problem

The adder and subtractor problem is a problem that is used to demonstrate the need for synchronisation in a system. The problem is as follows:
* Create a count class that has a count variable.
* Create two different classes Adder and Subtractor.
* Accept a count object in the constructor of both the classes.
* In Adder, iterate from 1 to 100 and increment the count variable by 1 on each iteration.
* In Subtractor, iterate from 1 to 100 and decrement the count variable by 1 on each iteration.
* Print the final value of the count variable.
* What would the ideal value of the count variable be?
* What is the actual value of the count variable?
* Try to add some delay in the Adder and Subtractor classes using inspiration from the code below. What is the value of the count variable now?

Check implementation: low-level-design-1/src/main/java/fundamentals/concurrency/adderSubtractor/basic

## Synchronization
Running the above code should ideally result in the count variable being 0. However, if you increase the number of iterations in the Adder and Subtractor classes, you will see that the count variable is not 0. This is because the Adder and Subtractor classes are running in parallel and are not synchronised. This means that the Adder and Subtractor classes are not waiting for each other to finish before they start their own iterations. This results in the count variable being incremented and decremented at the same time, resulting in the count variable not being 0.

The major issue is that multiple threads are accessing a shared resource at the same time.

### Characteristics of synchronization problems

1. **Critical section** - A section of code that is accessed by multiple threads. When multiple threads access the same critical section, the result is a synchronisation problem that might yield wrong or inconsistent results.
2. **Race Conditions** - When more than one thread tries to enter the critical section at the same time.
3. **Preemption** - When a thread is interrupted by another thread. It could be possible that the interrupted thread is in the middle of a critical section. This could result in the interrupted thread not being able to finish the critical section and yield inconsistent results.

### Properties of a good solution
1. **Mutual Exclusion** - Only one thread can access the critical section at a time.
2. **Progress** - If a thread wants to enter the critical section, it will eventually be able to do so.
3. **Bounded Waiting** - If a thread wants to enter the critical section, it will eventually be able to do so, but only after a finite number of other threads have entered the critical section.
4. **No busy Waiting** - If a thread wants to enter the critical section, it will not be able to do so until the critical section is free. It has to keep checking if the critical section is free. This is called busy waiting.
5. **Notification** - If a thread is waiting to enter the critical section, it should be notified when the critical section is free.

## Solutions to synchronization problem
### **1. Mutex Lock**
Mutex locks are a way to ensure that only one thread can access a critical section at a time. Mutex locks are also known as mutual exclusion locks.

A thread can only access the critical section if it has the lock. If a thread does not have the lock, it cannot access the critical section. If a thread has the lock, it can access the critical section. If a thread has the lock, it can release the lock and allow another thread to access the critical section.

Think of a room with a lock. Only one person can enter the room at a time. If a person has the key, they can enter the room. If a person does not have the key, they cannot enter the room. If a person has the key, they can leave the room and give the key to another person. This is the same as a mutex lock.

Properties of a mutex lock
* Lock - A thread can only access the critical section if it has the lock.
* Only one thread can have the lock at a time.
* Other threads cannot access the critical section if a thread has the lock and thus have to wait.
* Lock will automatically be released when the thread exits the critical section.

### **2. Synchronized Keyword or Synchronized Method**
The synchronized keyword is a way to solve the synchronisation problem. The synchronized keyword is a way to ensure that only one thread can access a critical section at a time.

A synchronized method or block can only be accessed by one thread at a time. If a thread is accessing a synchronized method or block, other threads cannot access the synchronized method or block. If a thread is accessing a synchronized method or block, other threads have to wait until the thread exits the synchronized method or block.

If you declare a method as synchronized, only one thread will be able to access any synchronized method in the class. This is because the synchronized keyword is associated with the object.

```java
public class Count {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
}
```

Two objects c1 and c2 of type Count, and two threads t1 an d t2

| Thread 1         | Thread 2          | Valid or Not                                   |
|------------------|-------------------|------------------------------------------------|
| c1.increment()   | c1.increament()   | No                                             |
| c1.increament()  | c1.decreament()   | No                                             |
| c1.increament()  | c1.getCount()     | Yes - getCount() is not synchronized           |
| c1.increament()  | c2.increament()   | Yes - synchronized methods of diffeent objects |
| c1.increament()  | c2.decreament()   | Yes - synchronized methods of diffeent objects |

## Concurrent Data Structures

If a map has A:1, and 2 threads try to access at same time and update the value we will again land into problem of lost updates and hence need synchronization.

| Hash Map           | Hash Table                                                                               | Concurrent Hash Map                               |
|--------------------|------------------------------------------------------------------------------------------|---------------------------------------------------|
| Is not thread safe | Is thread safe                                                                           | Thread safe version of hash map                   |
| NA                 | internally synchronizes the hash map, only one thread will be able to use the map a time | takes lock on bucket of keys instead of whole map |
| very fast          | very slow                                                                                | better than Hash table                            |

| String                                                                | StringBuilder   | StringBuffer   |
|-----------------------------------------------------------------------|-----------------|----------------|
| Immutable and hence thread safe, everytime we are creating new object | Not thread safe | Is thread safe |
| Slow                                                                  | Fastest         | Medium         |