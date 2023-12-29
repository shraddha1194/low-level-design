package fundamentals.exceptionHandling;

public class Pair<LEFT_TYPE, RIGHT_TYPE> {

    private LEFT_TYPE left;
    private RIGHT_TYPE right;

    public Pair(LEFT_TYPE left, RIGHT_TYPE right) {
        // create object of exception
        // pass msg to exception to know what went wrong
        // throw the exception
        // throw is possible because Exception extends Throwable class
        // throw new Integer(10); is not possible
       if (left == null || right == null) {
           // Too generic - Rule#1
           // throw new RuntimeException("Null values are not allowed");
           throw new NullValuesException("Null values are not allowed in Pair!!");
       }
        this.left = left;
        this.right = right;
    }

    public LEFT_TYPE getLeft() {
        return left;
    }

    public RIGHT_TYPE getRight() {
        return right;
    }
}
