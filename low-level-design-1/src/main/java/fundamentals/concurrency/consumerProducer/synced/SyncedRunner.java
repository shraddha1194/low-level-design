package fundamentals.concurrency.consumerProducer.synced;

import fundamentals.concurrency.consumerProducer.locks.LockConsumer;
import fundamentals.concurrency.consumerProducer.locks.LockProducer;
import fundamentals.concurrency.consumerProducer.semaphores.UnitOfWork;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class SyncedRunner {
    private static final Set<String> producerNames = Set.of("p1", "p2", "p3", "p4");
    private static final Set<String> consumerNames = Set.of("c1", "c2", "c3", "c4");

    public static void main(String[] args) {
        //Creating shared resource
        Queue<UnitOfWork> buffer = new ArrayDeque<>();
        int maxSize = 10; //max size of buffer

        Set<SyncedProducer> producers = producerNames.stream()
                .map(name -> new SyncedProducer(name, buffer, maxSize))
                .collect(Collectors.toSet());

        Set<SyncedConsumer> consumers = consumerNames.stream()
                .map(name -> new SyncedConsumer(name, buffer))
                .collect(Collectors.toSet());

        producers.forEach(p -> new Thread(p).start());
        consumers.forEach(c -> new Thread(c).start());
    }
}

/* Observation:
We have solved the problem of the synchronization but throughput is very less -
Not more than one consumer can consume at a time, or more than one producer can produce at a time.
 */
