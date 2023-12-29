package fundamentals.concurrency.adderSubtractor.atomicInteger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Count {
    private AtomicInteger value = new AtomicInteger(0);
}
