package org.concurrency.threads;

public class NumberPrinterRunner {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            NumberPrinter numberPrinter = new NumberPrinter(i);
            numberPrinter.start();
        }
    }
}
