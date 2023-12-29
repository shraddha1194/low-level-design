package fundamentals.exceptionHandling;

public class TryCatch {
    public static void main(String[] args) {
        System.out.println(call1());
        System.out.println(call2());
    }

    private static int call1() {
        try {
            return 1;
        } catch (ArithmeticException e) {
            return 2;
        } finally {
            return 3;
        }
    }

    private static int call2() {
        try {
            throw new ArithmeticException();
        } catch (ArithmeticException e) {
            return 2;
        } finally {
            return 3;
        }
    }
}
