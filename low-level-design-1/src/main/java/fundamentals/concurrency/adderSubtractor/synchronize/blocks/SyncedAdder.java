package fundamentals.concurrency.adderSubtractor.synchronize.blocks;

import lombok.AllArgsConstructor;
import fundamentals.concurrency.adderSubtractor.Count;

@AllArgsConstructor
public class SyncedAdder implements Runnable{

    private Count count;

    @Override
    public void run() {
        // if a code is wrapped in synchronized block then java will automatically acquire the lock and release the lock
        // synchronized takes input - monitoring variable/object could be any type object
        // monitoring object could be an instance of class or class itself
        // using class as monitor is bad idea - cause only one thread can access the class
        synchronized(count) {
            for (int i = 1; i <= 100; i++) {
                int value = count.getCount();
                value = value + i;
                count.setCount(value);
            }
        }
    }
}
