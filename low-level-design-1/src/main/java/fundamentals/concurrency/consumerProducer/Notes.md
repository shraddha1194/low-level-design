1.  Also known as bounded buffer problem.
    You have a buffer you have a producer who adds events/items to the queue (like kafka queue)
    you have consumers who are taking things from the queue.
    We have shared resource - buffer
    we have multiple threads
    we will face race conditions/ data consistency issues

2.  Where can we actually run into data consistency issues?
    - Overflow
        -   we can have multiple producers and multiple consumers

        -   buffer size 5. Already filled 4
        -   P1 -> { 1. len = size(Q); 3. if (len < 5) add()}
        -   P2 -> { 2. len = size(Q); 4. if (len < 5) add()}
        -   If both P1 and P2 come at same time and try to add to queue

    - Underflow
        -   buffer size 5. Already filled 1
        -   Two consumers try to consume at the same time
        -   C1 -> {1. len = size(Q); 3. if(len >= 1) consume()}
        -   C2 -> {2. len = size(Q); 4. if(len >= 1) consume()}

3.  Solutions:
    1. Mutual Exclusion - via synchronized queue
        -   Only one producer will be able to add at time to buffer/queue
        -   Only one consumer will be able to consume at a time
        - Performance wise not optimal

    2.  If I have buffer size 5 and all are filled
        -   how many consumers can consume? -> 5
        -   how many producers will be able to produce? -> 0

    3. If I have buffer of size 5 and empty
        -   how many producers will be able to produce? -> 5
        -   how many consumers can consume? -> 0

    4. Multiple threads entering the critical section is Semaphore
        -   Generalization of a mutex
        -   Semaphore(n) -> n permits number -> how many threads can access critical section at a time
        -   mutex - is binary semaphore (semaphore(1))

4.  Cannot be solved with locks as it may cause performance issues - only one thread can access at a time

5.  Email sending is asynchronous flow.
    -   client doesn't have to wait, just get acknowledgement from mail server (i'll send it)
    -   the mail server can put the mail to be sent in the queue and the task worker will then send the message
    -   If it was synchronous then client would have to wait until email was sent

6.  Synchronized block and locks don't solve the problem because throughput is very low
    Number of items produced per unit time

7.  At a time how many producers and consumers must exist given we have multiple producers and consumers?
    -  #of producers = #of empty slots in buffer
    -  #of consumers = #of filled slots in buffer