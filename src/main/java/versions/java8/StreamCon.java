package versions.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;

/**
 * @author xiaoy
 * @date 2020/05/13
 */
public class StreamCon {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Stream.concat(Stream.concat(stream, another), more);
        // TODO Auto-generated method stub
        // Stream<Integer> stream = Stream.of(1, 2, 3);
        // Stream<Integer> another = Stream.of(4, 5, 6);
        // Stream<Integer> concat = Stream.concat(stream, another);
        //
        // List<Integer> collect = concat.collect(Collectors.toList());
        // List<Integer> expected = Lists.aslist(1, 2, 3, 4, 5, 6);
        //
        // Assertions.assertIterableEquals(expected, collect);

        Stream<Integer> stream = Stream.of(1, 2, 3);
        Stream<Integer> another = Stream.of(4, 5, 6);
        Stream<Integer> third = Stream.of(7, 8, 9);
        Stream<Integer> more = Stream.of(0);
        Stream<Integer> concat = Stream.of(stream, another, third, more).flatMap(integerStream -> integerStream);
        List<Integer> collect = concat.collect(Collectors.toList());
        // Lists.list
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        Assertions.assertIterableEquals(expected, collect);
        System.out.println(collect);
    }

}
