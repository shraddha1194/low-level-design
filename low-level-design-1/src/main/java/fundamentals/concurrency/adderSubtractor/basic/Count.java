package fundamentals.concurrency.adderSubtractor.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Count {

    private int count;

    public void increment(int offset) {
        this.count += offset;
    }

    public  void decrement(int offset) {
        this.count -= offset;
    }

}
