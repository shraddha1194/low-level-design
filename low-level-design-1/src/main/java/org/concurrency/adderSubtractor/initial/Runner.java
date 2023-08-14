package org.concurrency.adderSubtractor.initial;

import org.concurrency.adderSubtractor.Count;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Runner {
    public static void main(String[] args) throws InterruptedException {
        // demonstrates issue when critical section is accessed by multiple thread
        // data inconsistency

        Count c = new Count();
        ExecutorService executor = Executors.newCachedThreadPool();
        Adder adder = new Adder(c);
        Subtractor subtractor = new Subtractor(c);

        executor.execute(adder);
        executor.execute(subtractor);

        executor.shutdown();
//        executor.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(c.getCount());

    }
}
