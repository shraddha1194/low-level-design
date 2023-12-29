1.  Prefer Synchronized block over methods?
    Blocks gives better (fine grain) control over which line you need to block. 
    Whereas, method blocks the whole method. 
    If whole method is critical section then synchronized method is used but if not then use synchronized block.


2.  How synchronized class works?
    Synchronize over the whole class ie. only one thread will be able to access the class at a time.


3.  A a = new A();
    thread i) new B(a); 
    thread ii) new B(a);
    Which one will be blocked by synchronized  block?
    - will block second thread


4.  A a1 = new A();
    A a2 = new A();
    thread i) new B(a1)
    thread ii) new B(a2)
    Which one will be blocked by synchronized  block?
    - will not block any as both are different objects


5.  Can't use static variable in synchronized block - it will again be class level synchronization then its bad practice.


6.  Class cannot be synchronized - it can only be synchronized at block level and method level


7.  Polling/ Busy Waiting - when a thread keeps polling to check if lock is available to acquire


8.  Mutual Exclusion - Only one thread can access the critical section


9.  Semaphores - is generalization of mutual exclusion multiple threads can access critical section at atime







