package org.concurrency.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Runner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Hello world!");

        // Thread creation using Thread
        Thread thread = new Thread(new Squared(5));
        thread.start();

        // Executor executes given runnable command
        // no need to create thread, just pass the task to be executed
        // no need to create Executor obj, static initializer in Executors
        // Redis uses Single Thread Executor
        // by default single thread executor
        // fixed thread pool executor - set upper limit to number of threads
        // cache thread pool - if a thread is available - reuse, if not available - it will create - use when not sure how many threads needed
        List<Integer> values = List.of(1,2,3,4,5,6,7,8,9);
        Executor executor = Executors.newCachedThreadPool();
        for (Integer value : values) {
            executor.execute((new Squared(value)));
        }

        // ExecutorService - Callable
        // Submits a Runnable task for execution and returns a Future representing that task.
        // The Future's get method will return the given result upon successful completion
        List<Integer> values1 = List.of(1,2,3,4,5,6,7,8,9);
        ExecutorService executor1 = Executors.newCachedThreadPool();

        List<Future<Integer>> squaredValues = new ArrayList<>();
        for (Integer value : values1) {
            squaredValues.add(executor1.submit(new SquaredPrinter(value)));
        }

        Thread.sleep(1000);

        for (Future<Integer> squaredValue : squaredValues) {
            System.out.println(squaredValue.get());;
        }
    }
}
