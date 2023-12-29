package fundamentals.lambda.functional;

import java.util.function.Function;

public class FunctionRunner {
    public static void main(String[] args) {
        //<T, R> T being input type and R being return type
        Function<String, String> printer = text -> {
            System.out.println(text);
            return text;
        };

        Function<String, String> upperCasePrinter = text -> {
            System.out.println(text.toUpperCase());
            return text;
        };

        Function<String, String> lowerCasePrinter = text -> {
            System.out.println(text.toLowerCase());
            return text;
        };

        // how to pass Function
        execute("Tantia Tope", printer);
        execute("Tantia Tope", upperCasePrinter);
        execute("Tantia Tope", lowerCasePrinter);

        //how to return Function
        String type = "upper";

    }

    private static String execute(String text, Function<String, String> function) {
        return function.apply(text);
    }

//    private static Function<String, String> decidePrinter(String type) {
//        switch (type){
//            case "normal":
//                return this::
//        }
//
//
//    }
}
