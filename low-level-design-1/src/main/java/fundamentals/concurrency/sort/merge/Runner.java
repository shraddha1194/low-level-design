package fundamentals.concurrency.sort.merge;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = List.of(1, 4, 5, 2, 7, 3, 8, 9, 0, 6);
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<List<Integer>> sorted = executorService.submit(new Sorter(list, executorService));
        System.out.println(sorted.get());
    }
}
