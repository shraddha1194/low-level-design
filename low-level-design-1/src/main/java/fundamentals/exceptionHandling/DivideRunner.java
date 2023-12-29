package fundamentals.exceptionHandling;

public class DivideRunner {
    public static void main(String[] args) {
        int result = divide(10, 2);
        result = divide(10, 0);
        System.out.println(result);
    }

    private static int divide(int dividend, int divisor) {
        try {
            int res =  dividend / divisor;
            System.out.println("Good bye: " + 5);
            return res;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            // do not suppress exception ideally throw exception
            return 0;
        } finally {
            System.out.println("Good Bye!");
        }
    }
}
