package fundamentals.concurrency.consumerProducer.locks;

import fundamentals.concurrency.consumerProducer.semaphores.UnitOfWork;
import lombok.AllArgsConstructor;

import java.util.Queue;
import java.util.concurrent.locks.Lock;

@AllArgsConstructor
public class LockConsumer implements Runnable{

    private String name;
    private Queue<UnitOfWork> buffer;
    private Lock lock;
    @Override
    public void run() {
        while (true) {
            lock.lock();
            //critical section starts
            if (buffer.size() > 0) {
                buffer.remove();
                //lock.unlock();
                //critical section ends
                System.out.println(name + " consumed. Existing buffer size: " + buffer.size());
            }
            lock.unlock();
        }
    }
}

// unlock in between 2 lines - but it does not help here
// it does not solve our problem