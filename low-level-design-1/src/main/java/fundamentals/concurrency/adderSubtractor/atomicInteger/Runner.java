package fundamentals.concurrency.adderSubtractor.atomicInteger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Count c = new Count();
        ExecutorService executor = Executors.newCachedThreadPool();
        Adder adder = new Adder(c);
        Subtractor subtractor = new Subtractor(c);

        executor.execute(adder);
        executor.execute(subtractor);

        executor.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(c.getValue());
    }
}
