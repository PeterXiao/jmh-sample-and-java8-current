package versions.java8;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author xiaoy
 * @date 2020/05/11
 */
public class StreamBuilders {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        stream.forEach(p -> System.out.println(p));

        Stream<Integer> stream1 = Stream.of(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        stream1.forEach(p -> System.out.println(p));

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        Stream<Integer> stream11 = list.stream();
        stream11.forEach(p -> System.out.println(p));

        Stream<Date> streamdates = Stream.generate(() -> {
            return new Date();
        });
        streamdates.forEach(p -> System.out.println(p));

    }

}