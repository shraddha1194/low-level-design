package fundamentals.concurrency.sort.merge;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@NoArgsConstructor
@AllArgsConstructor
public class Sorter implements Callable<List<Integer>> {

    private List<Integer> list;
    private ExecutorService executorService;

    @Override
    public List<Integer> call() throws Exception {
        int n = list.size();
        if (n <= 1) {
            return list;
        }

        int mid = n/2;
        List<Integer> left = list.subList(0, mid);
        List<Integer> right = list.subList(mid, n);

        Future<List<Integer>> leftFuture = executorService.submit(new Sorter(left, executorService));
        Future<List<Integer>> rightFuture = executorService.submit(new Sorter(right, executorService));

        return merge(leftFuture, rightFuture);
    }

    public List<Integer> merge(Future<List<Integer>> leftSorted, Future<List<Integer>> rightSorted) throws ExecutionException, InterruptedException {
        List<Integer> sorted = new ArrayList<>();
        int i = 0;
        int j = 0;

        List<Integer> left = leftSorted.get();
        List<Integer> right = rightSorted.get();

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                sorted.add(left.get(i));
                i++;
            } else {
                sorted.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            sorted.add(left.get(i++));
        }

        while (j < right.size()) {
            sorted.add(right.get(j++));
        }

        return sorted;
    }
}
