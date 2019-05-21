import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstPredicates {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("one","two","three","four","five");

        // filter strings with length greater than 3
        Predicate<String> p1 = s -> s.length() > 3;

        // filter string with given value
        Predicate<String> p2 = Predicate.isEqual("two");

        Predicate<String> p3 = Predicate.isEqual("three");

        // apply second predicate
        stream
                .filter(p2.or(p3))
                .forEach(System.out::println);
    }
}
