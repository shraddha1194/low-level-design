package org.concurrency.sort.quick;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Runner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(5);
        list.add(6);
        list.add(2);
        list.add(4);
        list.add(3);
        list.add(0);
        list.add(7);
        list.add(8);
        list.add(1);

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<List<Integer>> res = executorService.submit(new QuickSorter(0, list.size()-1, list, executorService));

        //waits for all the tasks to finish
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("result " + res.get());
    }
}
