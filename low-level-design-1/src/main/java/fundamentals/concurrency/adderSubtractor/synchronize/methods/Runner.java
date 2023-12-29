package fundamentals.concurrency.adderSubtractor.synchronize.methods;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Adder adder = new Adder(counter);
        Subtractor subtractor = new Subtractor(counter);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(adder);
        executorService.execute(subtractor);

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (Exception ex) {
            System.out.println("Something went wrong!");
        }

        System.out.println(counter.getCount());

    }
}
