package org.concurrency.adderSubtractor.synced.blocks;

import org.concurrency.adderSubtractor.Count;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public static void main(String[] args) {
        Count count = new Count();

        SyncedAdder syncedAdder = new SyncedAdder(count);
        SyncedSubtractor syncedSubtractor = new SyncedSubtractor(count);

        ExecutorService executors = Executors.newCachedThreadPool();

        executors.execute(syncedAdder);
        executors.execute(syncedSubtractor);
        executors.shutdown();
        System.out.println(count.getCount());
    }
}
