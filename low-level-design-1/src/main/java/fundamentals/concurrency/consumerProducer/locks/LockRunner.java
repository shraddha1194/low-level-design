package fundamentals.concurrency.consumerProducer.locks;

import fundamentals.concurrency.consumerProducer.semaphores.UnitOfWork;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class LockRunner {
    private static final Set<String> producerNames = Set.of("p1", "p2", "p3", "p4");
    private static final Set<String> consumerNames = Set.of("c1", "c2", "c3", "c4");

    public static void main(String[] args) {
        //Creating shared resource
        Queue<UnitOfWork> buffer = new ArrayDeque<>();
        int maxSize = 10; //max size of buffer

        Lock lock = new ReentrantLock();
        Set<LockProducer> producers = producerNames.stream()
                .map(name -> new LockProducer(name, buffer, maxSize, lock))
                .collect(Collectors.toSet());

        Set<LockConsumer> consumers = consumerNames.stream()
                .map(name -> new LockConsumer(name, buffer, lock))
                .collect(Collectors.toSet());

        producers.forEach(p -> new Thread(p).start());
        consumers.forEach(c -> new Thread(c).start());
    }
}

// Once a thread gets hold of lock it continues to execute
// Affinity -