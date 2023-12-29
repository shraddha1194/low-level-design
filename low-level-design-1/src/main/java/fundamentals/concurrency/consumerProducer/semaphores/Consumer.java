package fundamentals.concurrency.consumerProducer.semaphores;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Queue;
import java.util.concurrent.Semaphore;

@AllArgsConstructor
public class Consumer implements Runnable{

    private String name;
    private Queue<UnitOfWork> buffer;
    private Semaphore forProducer;
    private Semaphore forConsumer;

    // The ideal situation for us is that:
    // There are parallel threads that are able to consume until all the store is empty.
    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            forConsumer.acquire();
            buffer.remove();
            System.out.println(name + " consumed. Existing buffer size: " + buffer.size());
            forProducer.release();
        }
    }
}
