package fundamentals.exceptionHandling;

import java.util.concurrent.*;

public class ExceptionRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 1. unchecked exception
        Pair nullPair = new Pair<>(null, null);
        System.out.println("Hello World,  I have created a Pair object.");

        // 2. checked exceptions
        // added throws to the method to handle
        callThread();

        // 3. If NullValuesException is thrown then tell user you have done something bad
        callThread1();
    }

    // 1st way to handle is to delegate the responsibility of handling by using throws
    // compile time exceptions need to be handled
    private static void callThread() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> value = executor.submit(() -> "Tantia Tope");

        // force developer to handle the exception
        executor.awaitTermination(1, TimeUnit.SECONDS); //InterruptedException
        System.out.println(value.get());
    }

    // Other methods (caller) does not require to handle the exceptions
    // if exception occurs then flow is not interrupted, program continues to execute
    private static void callThread1() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> value = executor.submit(() -> "Tantia Tope");

        try {
            executor.awaitTermination(1, TimeUnit.SECONDS); //InterruptedException
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        // order of exception matters
        // both ExecutionException and Interrupted Exceptions are at same level
        // instead of multiple catchs we can use single
        try {
            System.out.println(value.get());
            //} catch (ExecutionException e) {
            //    System.out.println(e.getMessage());
            //} catch (InterruptedException e) {
            //    System.out.println(e.getMessage());
        } catch (ExecutionException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
