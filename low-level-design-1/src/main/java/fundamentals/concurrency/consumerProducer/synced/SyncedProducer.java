package fundamentals.concurrency.consumerProducer.synced;

import fundamentals.concurrency.consumerProducer.semaphores.UnitOfWork;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Queue;

@AllArgsConstructor
@NoArgsConstructor
public class SyncedProducer implements Runnable {
    private String name;
    private Queue<UnitOfWork> buffer;
    private int maxSize;

    @Override
    public void run() {
        while(true) {
            synchronized (buffer) {
                if (buffer.size() < maxSize) {
                    buffer.add(new UnitOfWork());
                    System.out.println(name + " produced food. Current size: " + buffer.size());
                }
            }
        }
    }
}
