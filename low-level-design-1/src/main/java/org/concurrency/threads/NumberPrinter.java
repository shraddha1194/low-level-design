package org.concurrency.threads;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NumberPrinter extends Thread {
    private int num;
    public void run() {
        System.out.println(num + " " + Thread.currentThread().getName());
    }

}
