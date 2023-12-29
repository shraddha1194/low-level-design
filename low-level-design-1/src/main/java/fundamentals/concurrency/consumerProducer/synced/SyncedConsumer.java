package fundamentals.concurrency.consumerProducer.synced;

import fundamentals.concurrency.consumerProducer.semaphores.UnitOfWork;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Queue;

@AllArgsConstructor
@NoArgsConstructor
public class SyncedConsumer implements Runnable {
    private String name;
    private Queue<UnitOfWork> buffer;

    @Override
    public void run() {
        while(true) {
            synchronized (buffer) {
                if (buffer.size() > 0) {
                    buffer.remove();
                    System.out.println(name + " consumed. Existing buffer size: " + buffer.size());
                }
            }
        }
    }
}
