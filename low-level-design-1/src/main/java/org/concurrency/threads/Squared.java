package org.concurrency.threads;

public class Squared implements Runnable{
    private Integer num;

    public Squared(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(num * num + " " + Thread.currentThread().getName());
    }
}
