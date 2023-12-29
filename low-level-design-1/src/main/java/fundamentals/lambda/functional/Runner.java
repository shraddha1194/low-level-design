package fundamentals.lambda.functional;

public class Runner {
    public static void main(String[] args) {
        MathOperation add = (a,b) -> {return a + b;};

        //above can be reduced to
        MathOperation add1 = (a, b) -> a+b;
        MathOperation subtract = (a, b) -> a-b;

        //how to use
        System.out.println(add.operate(1, 2));
        System.out.println(subtract.operate(1, 2));

        // If we want to pass 3 vars we can't cause we are providing implementation for operate method

        MathOperation multiply = (a, b) -> a * b;
        // if we need more complicated implementation
        MathOperation divide = (a, b) -> {
            if (b == 0) {
                return 0;
            }

            double value = a / b;
            return (int) value;
        };

        System.out.println(multiply.operate(1, 2));
        System.out.println(divide.operate(4, 2));

        //passing around the object
        //suppose we need to log something
    }

    private static int calculate(int a, int b, MathOperation operation) {
        System.out.println(a + " ------- " + b);
        return operation.operate(a, b);
    }

}
