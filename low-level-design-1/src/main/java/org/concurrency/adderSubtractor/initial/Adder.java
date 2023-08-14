package org.concurrency.adderSubtractor.initial;

import lombok.AllArgsConstructor;
import org.concurrency.adderSubtractor.Count;

@AllArgsConstructor
public class Adder implements Runnable {
    private Count count;

    public void run() {
        for (int i = 0; i < 100; i++) {
            int value = count.getCount();
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("Something wrong happened");
            }

            value = value + i;
            count.setCount(value);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println("Something wrong happened");
            }
        }
    }
}
