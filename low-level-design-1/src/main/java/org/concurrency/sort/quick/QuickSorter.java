package org.concurrency.sort.quick;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

@AllArgsConstructor
public class QuickSorter implements Callable<List<Integer>> {
    private Integer start;
    private Integer end;
    private List<Integer> list;
    private ExecutorService executorService;

    public List<Integer> call() {
        System.out.println(list + " " + start + " " + end + " " +Thread.currentThread().getName());
        if (start >= end) {
            return list;
        }

//        int rand = (int) (Math.random() * (end - start + 1)) + start;
        int rand = start;
        int pivot = list.get(rand);

//        System.out.println(rand + " " + pivot);

        int p1 = start+1, p2 = end;
        while (p1 <= p2) {
            if (list.get(p1) < pivot) {
                p1++;
            } else if (list.get(p2) > pivot) {
                p2--;
            } else {
                int tmp = list.get(p1);
                list.set(p1, list.get(p2));
                list.set(p2, tmp);
                p1++;
                p2--;
            }
        }
        int tmp = list.get(p2);
        list.set(p2, list.get(start));
        list.set(start, tmp);
//        System.out.println(list);
        executorService.submit(new QuickSorter(start, p2, list,executorService));
        executorService.submit(new QuickSorter(p2+1, end, list, executorService));
        return list;
    }
}
