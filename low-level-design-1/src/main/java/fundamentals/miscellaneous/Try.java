package fundamentals.miscellaneous;

import java.util.concurrent.*;

public class Try {
    public class Test implements Runnable {
        public void run() {
            System.out.println("This is hello from Runnable");
        }
    }

    public class TestCall implements Callable<String> {
        public String call() {
            return "This is hello from Callable";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Test test = new Test();
        Thread t = new Thread(test);
        t.start();

        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(new TestCall());
        System.out.println(future.get());
    }


}
