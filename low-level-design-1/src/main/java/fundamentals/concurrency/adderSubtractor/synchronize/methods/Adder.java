package fundamentals.concurrency.adderSubtractor.synchronize.methods;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Adder implements Runnable{
    private Counter count;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            count.incrementCount(i);
        }
    }
}
