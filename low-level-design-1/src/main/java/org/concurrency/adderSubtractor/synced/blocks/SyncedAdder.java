package org.concurrency.adderSubtractor.synced.blocks;

import lombok.AllArgsConstructor;
import org.concurrency.adderSubtractor.Count;

@AllArgsConstructor
public class SyncedAdder implements Runnable{

    private Count count;

    @Override
    public void run() {
        // if a code is wrapped in synchronized block then java will automatically acquire the lock and release the lock
        // synchronized takes input - monitoring variable/object could be
        synchronized(count) {
            for (int i = 1; i <= 100; i++) {
                int value = count.getCount();
                value = value + i;
                count.setCount(value);
            }
        }
    }
}
