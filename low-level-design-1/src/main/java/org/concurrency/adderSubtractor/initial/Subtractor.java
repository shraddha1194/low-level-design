package org.concurrency.adderSubtractor.initial;

import lombok.AllArgsConstructor;
import org.concurrency.adderSubtractor.Count;

@AllArgsConstructor
public class Subtractor implements Runnable{
    private Count count;

    public void run() {
        for (int i = 0; i < 100; i++) {
            int value = count.getCount();
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                System.out.println("Something wrong happened");
            }
            value = value - i;
            count.setCount(value);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println("Something wrong happened");
            }

            for (int j = 0; j < 10000; ++j) {
                // do something
            }
        }
    }
}
