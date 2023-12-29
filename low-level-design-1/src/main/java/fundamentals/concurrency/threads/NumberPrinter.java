package fundamentals.concurrency.threads;

import lombok.AllArgsConstructor;

// Print number from 1 to 10 each from a different thread.
@AllArgsConstructor
public class NumberPrinter extends Thread {
    private int num;
    public void run() {
        System.out.println(num + " " + Thread.currentThread().getName());
    }

}
