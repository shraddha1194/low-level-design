package fundamentals.concurrency.adderSubtractor.basic;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        Thread adderThread = new Thread(adder);
        Thread subtractorThread = new Thread(subtractor);

        adderThread.start();
        subtractorThread.start();

        //Waits for this thread to die.
        //Throws: InterruptedException – if any thread has interrupted the current thread.
        //The interrupted status of the current thread is cleared when this exception is thrown.
        adderThread.join();
        subtractorThread.join();

        System.out.println(count.getCount());
    }
}
