package fundamentals.annotations;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class DivideRunner {
    //marker annotations
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        int result = divide(10, 2);
        result = divide(10, 0);
        System.out.println(result);
    }

    // meta annotations
    @Deprecated
    private static int divide(int dividend, int divisor) {
        try {
            int res =  dividend / divisor;
            System.out.println("Good bye: " + 5);
            return res;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            // do not suppress exception ideally throw exception
            return 0;
        } finally {
            System.out.println("Good Bye!");
        }
    }

    // converts compile time exceptions to runtime exception
    // @SneakyThrows(Exception.class) - don user generic exception

    // @SneakyThrows(value = Exception.class)
    @SneakyThrows({InterruptedException.class, ExecutionException.class})
    private static void callThread() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> value = executor.submit(() -> "Tantia Tope");

        // force developer to handle the exception
        executor.awaitTermination(1, TimeUnit.SECONDS); //InterruptedException
        System.out.println(value.get());
    }
}
