package fundamentals.lambda.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Worksheet {
    public static void main(String[] args) {
//        question1();
//        question1WithMap();
//        question2();
//        question3();
//        question4();
//        adhoc1();
//        question5();
//        question6();
//        question7();
//        question8();
//        question9();
//        question10();
//        question11();
        question12();
    }

    private static void question1() {
        //Find below a list of integers. Iterate over it and print the square of each number.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .forEach((value) -> System.out.println(value * value));
    }
    private static void question1WithMap() {
        //Find below a list of integers. Iterate over it and print the square of each number.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .map(value -> value * value)
                .forEach(System.out::println);
    }

    private static void question2() {
        //Find below a list of integers. Iterate over it and print every even number.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .forEach(value -> {
                    if (value % 2 == 0) {
                        System.out.println(value);
                    }
                });

        numbers.stream()
                .filter(value -> value % 2 == 0)
                .forEach(System.out::println); // proxy method then use method reference
    }

    private static void question3() {
        //For the list of integers, find all the even numbers. Then, iterate over the even numbers and print each number.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()
                .filter(value -> value % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);

    }

    private static void question4() {
        //For a list of integers, return a list of the squares of each number.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> squaredNumbers = numbers.stream()
                .map(value -> value * value)
                .collect(Collectors.toList());
        System.out.println(squaredNumbers);
    }

    private static void adhoc1() {
        //Find even numbers and print sqaure
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> squaredNumbers = numbers.stream()
                .filter(value -> value % 2 == 0)
                .map(value -> value * value)
                .collect(Collectors.toList());
        System.out.println(squaredNumbers);
    }

    private static void question5() {
        //For a list of strings, return a list of the length of each string.
        List<String> names = List.of("Tantia Tope", "Rani Lakshmibai", "Mangal Pandey", "Nana Sahib");
        List<Integer> lengths = names.stream()
                .map(name -> name.length())
                .collect(Collectors.toList());
        System.out.println(lengths);
    }

    private static void question6() {
        //For a list of strings, filter out the strings which do not start with the letter T and then uppercase the remaining strings.
        List<String> names = List.of("Tantia Tope", "Rani Lakshmibai", "Mangal Pandey", "Nana Sahib");
        List<String> res = names.stream()
                .filter(name -> !name.startsWith("T"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(res);
    }

    private static void question7() {
        //For a list of strings, filter out the strings which do not start with the letter T, then uppercase the remaining strings and then sort them.
        List<String> names = List.of("Tantia Tope", "Rani Lakshmibai", "Mangal Pandey", "Nana Sahib");
        List<String> res = names.stream()
                .filter(name -> !name.startsWith("T"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(res);
    }

    private static void question8() {
        //For a list of integers, find the sum of all the numbers.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.stream()
                .reduce(0, (currentValue, currentElement) -> currentElement + currentValue.intValue());

        System.out.println(sum);
    }

    private static void question9() {
        //For a list of integers, find the sum of the squares of all the numbers.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int res = numbers.stream()
                .reduce(0, (currentValue, currentElement) -> currentValue + currentElement * currentElement);
        System.out.println(res);
    }

    private static void question10() {
        //For a list of integers, find the sum of the squares of all the even numbers.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int res = numbers.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, (currentValue, currentElement) -> currentValue + currentElement * currentElement);
        System.out.println(res);
    }

    private static void question11() {
        //Given a list of numbers, find the maximum number in the list.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer max = numbers.stream().max(Integer::compare).get();
        System.out.println(max);
    }

    private static void question12() {
        //Given a list of numbers with duplicates, find the distinct numbers in the list.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5);
        List<Integer> res = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(res);
    }

    private static void question13() {
        //Given a list of numbers, find the average of all the numbers.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        numbers.stream().mapToInt()
    }
}

//Data -> method1 -> method2 -> method3
// Method3 terminal
// Method1, method2 -> intermediate

//reduce will have single output -
// initial value known as identity, accumulator  function - lambda function
// accumulator will have currentElement, currentValue
//[1, 2, 3, 4]
//1
//currentValue: 0
//currentElement: 1
//return 0 + 1

//2
//current Value: 1
//currentElement: 2
//return 1 + 2

//3
//currentValue: 3
//currentElement: 3
//return 3 + 3

//4
//currentValue: 6
//currentElement: 4
//return 6 + 4