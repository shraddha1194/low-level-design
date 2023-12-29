package fundamentals.concurrency.consumerProducer.semaphores;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

public class Runner {
    private static final Set<String> producerNames = Set.of("p1", "p2", "p3", "p4");
    private static final Set<String> consumerNames = Set.of("c1", "c2", "c3", "c4");

    public static void main(String[] args) {
        //Creating shared resource
        Queue<UnitOfWork> buffer = new ConcurrentLinkedDeque<>();

        // will control the maximum number of producers and is initialised with the max store size
        Semaphore forProducer = new Semaphore(10);

        // controls the maximum number of consumers. This starts with 0 active threads.
        Semaphore forConsumer = new Semaphore(0);

        Set<Producer> producers = producerNames.stream()
                .map(name -> new Producer(name, buffer, forProducer, forConsumer))
                .collect(Collectors.toSet());

        Set<Consumer> consumers = consumerNames.stream()
                .map(name -> new Consumer(name, buffer, forProducer, forConsumer))
                .collect(Collectors.toSet());

        producers.forEach(p -> new Thread(p).start());
        consumers.forEach(c -> new Thread(c).start());
    }
}
