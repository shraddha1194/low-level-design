package fundamentals.miscellaneous;

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

    public static void main(String[] args) {
        Test test = new Test();
        Thread t = new Thread(test);
        t.start();

        ExecutorService service = Executor.newCachedThreadPool();
        Future<String> future = service.submit(new TestCall());
        System.out.println(future.get());
    }