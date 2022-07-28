package ocp.functionalstreams;

import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Stream;

public class StreamsMain {

    public static void main(String... args) {

        Stream<Integer> stream = Stream.empty();
        Stream<Long> stream1 = Stream.of(101L, Long.MAX_VALUE);

        //Infinite Stream
        Stream<Double> stream2 = Stream.generate(Math::random);

        System.out.println("+++++++++++++++ Common methods ++++++++++++++++++");

        Stream<String> names = Stream.of("Alexander", "John", "1", "Dav");
        Optional<String> minName = names.min((v1, v2) -> v1.length() - v2.length());
        System.out.println("Min in stream is " + minName.orElseThrow());
        //or
        minName.ifPresent(System.out::println);
        names = Stream.of("Alexander", "John", "1", "Dav");
        //findAny -> Optional<T>
        System.out.println("FindAny: " + names.findAny());
        names = Stream.of("Alexander", "John", "1", "Dav");
        //findFirst -> Optional<T>
        System.out.println("FindFirst: " + names.findFirst());

        //AnyMatch, AllMatch, NoneMatch (Predicate) -> boolean
        names = Stream.of("Alexander", "John", "1", "Dav");
        System.out.println("anyMatch: " + names.anyMatch((s) -> s.startsWith("D")));
        names = Stream.of("Alexander", "John", "1", "Dav");
        System.out.println("noneNone: " + names.noneMatch((s) -> s.contains("5")));
        names = Stream.of("Alexander", "John", "1", "Dav");
        System.out.println("allMatch: " + names.allMatch((s) -> s.equalsIgnoreCase("test")));

        //Reduce
        Stream<String> chars = Stream.of("T","E","S","T");
        System.out.println(chars.reduce("", (s,s1) -> s + s1));

        //Collect
        Stream<String> letters = Stream.of("w", "r", "a", "5");
        TreeSet<String> s = letters.collect(
                TreeSet::new,//supplier
                TreeSet::add,//accumulator - adds elements
                TreeSet::addAll //combiner - taking two data collections and merging it
        );
        //or
        //TreeSet<String> s2 = letters.collect(Collectors.toCollection(TreeSet::new));
        System.out.println("TreeSet with collect: " + s);

        //distinct
        Stream<Integer> duplicates = Stream.of(4,5,6,5,4,5,6,7,8);
        duplicates.distinct().forEach(System.out::println);

        //map
        Stream<String> ss = Stream.of("wolf", "alexander","trash");
        ss.map(String::length)
                .forEach((s1) -> System.out.println("Length of word: " + s1));



    }


}
