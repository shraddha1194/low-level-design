package fundamentals.concurrency.threads;

// Print number from 1 to 10 each from a different thread.
public class NumberPrinterRunner {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            NumberPrinter numberPrinter = new NumberPrinter(i);
            numberPrinter.start();
        }
    }
}
