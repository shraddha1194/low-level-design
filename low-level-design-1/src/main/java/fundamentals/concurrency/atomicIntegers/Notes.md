Atomic Integers:

The methods that atomic integers will provide:
- get and add (by offset)
- get and increment (by 1)
- get and subtract

What is contention?
- Contention occurs when one thread has to wait for another thread to finish using a resource.
- In normal mutex, one thread enters critical section while the others have to wait. This known as high contention.
- High contention occurs when multiple threads try to access same lock simultaneously. This results in low throughput(less work gets done).
- All the locks and semaphores have either low or medium contention.

Atomic Integers use concept of Lock Free Programming.
Lock free programming - technique that allows to avoid synchronization issue, data inconsistency without the locks. We don't see a thread blocking another thread.
Its is implemented using atomic operations at hardware level.

Compare and Swap (CAS)
looks at memory address, expected values and the actual value.
As soon as any value is updated its visible across threads

Use native methods.
