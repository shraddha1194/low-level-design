package org.concurrency.adderSubtractor.synced.methods;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Counter {
    private int count;

    public synchronized void incrementCount(int offset) {
        this.count += offset;
    }

    public synchronized void decrementCount(int offset) {
        this.count -= offset;
    }
}
