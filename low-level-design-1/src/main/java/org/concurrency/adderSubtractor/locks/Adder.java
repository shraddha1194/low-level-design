package org.concurrency.adderSubtractor.locks;

import lombok.AllArgsConstructor;
import org.concurrency.adderSubtractor.Count;

import java.util.concurrent.locks.Lock;

@AllArgsConstructor
public class Adder implements Runnable {
    private Count count;
    private Lock lock;

    public void run() {

        //acquire lock
        lock.lock();
        //critical section - as value of count is updated
        for (int i = 1; i <= 100; i++) {
            int value = count.getCount();
            value = value + i;
            count.setCount(value);
        }
        lock.unlock();
        //release lock
    }
}
