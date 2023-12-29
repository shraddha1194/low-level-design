package fundamentals.concurrency.adderSubtractor.atomicInteger;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Adder implements Runnable{
    private Count c;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            c.getValue().getAndAdd(i);
        }
    }
}
