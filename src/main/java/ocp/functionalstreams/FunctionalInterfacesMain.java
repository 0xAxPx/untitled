package ocp.functionalstreams;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfacesMain {

    public static void main(String... args) {


        System.out.println("+++++++++ SUPPLIER ++++++++++++");
        /*
         * Supplier(T)
         * T get() returns T
         */

        Supplier<LocalDate> s1 = LocalDate::now;
        System.out.println("LocalDate is " + s1.get());


        System.out.println("+++++++++ CONSUMER ++++++++++++");
        /*
         * Consumer(T) + BiConsumer(T,U) - DO NOT RETURN ANYTHING
         * Consumer is used when you want to do smth with parameter but return anything
         * void accept(T)
         * void accept(T,U)
         */

        Consumer<String> c1 = System.out::println;
        c1.accept("Hello");
        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> c2 = (k, v) -> map.put(k,v);
        c2.accept("Name",4444);
        System.out.println(map);

        Consumer<String> stringConsumer = s -> System.out.println("1:" + s);
        Consumer<String> stringConsumer1 = s -> System.out.println("2:" + s);
        stringConsumer.andThen(stringConsumer1).accept("Test");


        System.out.println("+++++++++ PREDICATE ++++++++++++");
        /*
         * Predicate(T) + BiPredicate(T,U) return boolean
         * Used for filtering, matching
         * boolean test(T)
         * boolean test(T,U)
         */

        Predicate<String> p1 = String::isEmpty;
        System.out.println(p1.test(""));
        BiPredicate<String, Integer> p2 = (s, v) -> {
            System.out.println(s);
            if (v / 2 == 0) {
                System.out.println(v + " is even number");
                return true;
            } else {
                System.out.println(v + " is odd number");
                return false;
            }
        };
        System.out.println(p2.test("", 11));

        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");
        System.out.println("Is egg and brown: " + egg.and(brown).test("eggAndbrown"));
        System.out.println("Is egg and not brown: " + egg.and(brown.negate()).test("eggAndbrown"));


        System.out.println("+++++++++ FUNCTION ++++++++++++");
        /*
         * Function(T) + BiFunction(T,U) turns one parameter into another
         * R apply(T, R)
         * R apply(T,U,R)
         */

        Function<String, Character[]> stringFunction = (s) -> s.chars()
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new);

        System.out.println(Arrays.toString(stringFunction.apply("Hello and Bye")));

        Function<Integer,Integer> function = x -> x + 1;
        Function<Integer,Integer> function2 = x -> x  %  3;
        System.out.println("Compose function: " + function.compose(function2).apply(10));

        System.out.println("+++++++++ UNARYOPERATOR ++++++++++++");
        /*
         * UnaryOperator(T) transform its value into one of the same type
         * BinaryOperator(T) transform two values into one
         * T apply(T)
         * T apply(T,T)
         */

        UnaryOperator<String> stringUnaryOperator = String::toLowerCase;
        System.out.println(stringUnaryOperator.apply("errttt"));
        BinaryOperator<String> stringStringBinaryOperator = (s, sAdd) -> s + sAdd;
        System.out.println(stringStringBinaryOperator.apply("asdasd", "12121"));

    }





}
