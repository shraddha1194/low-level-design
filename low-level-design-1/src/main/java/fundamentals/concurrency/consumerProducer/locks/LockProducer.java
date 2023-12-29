package fundamentals.concurrency.consumerProducer.locks;

import fundamentals.concurrency.consumerProducer.semaphores.UnitOfWork;
import lombok.AllArgsConstructor;

import java.util.Queue;
import java.util.concurrent.locks.Lock;

@AllArgsConstructor
public class LockProducer implements Runnable{

    private String name;
    private Queue<UnitOfWork> buffer;
    private Integer maxSize;
    private Lock lock;

    @Override
    public void run() {
        //reading the queue and add to it
        //for continuous work using while thread should not die
        while (true) {
            //base case
            lock.lock();
            //critical section starts
            if (buffer.size() < maxSize) {
                buffer.add(new UnitOfWork());
                // lock.unlock(); -> is incorrect because we will run into problem if we condition is false -> lock will never be unlocked
                //critical section ends
                System.out.println(name + " produced food. Current size: " + buffer.size());
            }
            lock.unlock(); // correct implementation
        }
    }
}