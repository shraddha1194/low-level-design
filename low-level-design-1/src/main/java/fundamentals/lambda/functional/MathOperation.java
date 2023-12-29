package fundamentals.lambda.functional;

@FunctionalInterface
public interface MathOperation {
    int operate(int a, int b);

    //default is allowed
    default void test() {
        System.out.println("I am default from functional interface.");
    }
}
