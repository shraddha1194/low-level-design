package fundamentals.generics.worksheet_1;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Pair1 {
    private String left;
    private String right;

    //static initializer and is more readable
    public static Pair1 of(String left, String right) {
        return new Pair1(left, right);
    }
}
