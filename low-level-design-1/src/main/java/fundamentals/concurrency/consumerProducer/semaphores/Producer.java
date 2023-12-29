package fundamentals.concurrency.consumerProducer.semaphores;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Queue;
import java.util.concurrent.Semaphore;

@AllArgsConstructor
public class Producer implements Runnable{

    private String name;
    private Queue<UnitOfWork> buffer;
    private Semaphore forProducer;
    private Semaphore forConsumer;

    // The ideal situation for us is that:
    // There are parallel threads that are able to produce until all the store is filled.
    //  to achieve this we use each producer thread to signal to the consumer that it has added a new unit.

    @SneakyThrows
    @Override
    public void run() {
        //reading the queue and add to it
        //for continuous work using while thread should not die
        while (true) {
            forProducer.acquire();
            buffer.add(new UnitOfWork());
            System.out.println(name + " produced food. Current size: " + buffer.size());
            forConsumer.release();
        }
    }
}
