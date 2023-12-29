package fundamentals.exceptionHandling;

public class NullValuesException extends RuntimeException {

    public NullValuesException(String message) {
        super(message);
    }

    // not recommended as makes it less usable
    public NullValuesException() {
        super("Null values not allowed!!!");
    }
}
