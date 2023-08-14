package org.concurrency.adderSubtractor.synced.methods;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Subtractor implements Runnable{
    private Counter count;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            count.decrementCount(i);
        }
    }
}
