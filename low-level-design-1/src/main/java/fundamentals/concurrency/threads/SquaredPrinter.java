package fundamentals.concurrency.threads;

import java.util.concurrent.Callable;

public class SquaredPrinter implements Callable<Integer> {
    private Integer num;

    public SquaredPrinter(int num) {
        this.num = num;
    }

    public Integer call() {
        return num * num;
    }
}
