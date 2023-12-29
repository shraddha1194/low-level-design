package fundamentals.concurrency.adderSubtractor.locks;

import fundamentals.concurrency.adderSubtractor.Count;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    public static void main(String[] args) throws InterruptedException {

        Count c = new Count();

        //locks provide mutual exclusion in critical section
        Lock lock = new ReentrantLock();

        ExecutorService executor = Executors.newCachedThreadPool();
        Adder adder = new Adder(c, lock);
        Subtractor subtractor = new Subtractor(c, lock);

        executor.execute(adder);
        executor.execute(subtractor);

        executor.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(c.getCount());

    }
}
