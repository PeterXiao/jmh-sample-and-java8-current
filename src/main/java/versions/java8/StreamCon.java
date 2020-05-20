package versions.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

        // Java 8 使用 Stream，代码更加简洁易读；而且使用并发模式，程序执行速度更快。
        /*        
         List<Integer> transactionsIds = transactions.parallelStream(). //数值流的构造
         filter(t -> t.getType() == Transaction.GROCERY). //
         sorted(comparing(Transaction::getValue).reversed()).//排序
         map(Transaction::getId). //1 1对应
         collect(toList()); //转换数据结构
        */

        // 1. Individual values
        Stream streamex = Stream.of("a", "b", "c");
        // 2. Arrays
        String[] strArray = new String[] {"a", "b", "c"};
        streamex = Stream.of(strArray);
        streamex = Arrays.stream(strArray);
        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        streamex = list.stream();

        // 数值流的构造
        IntStream.of(new int[] {1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);

        /*        // 1. 转换成数组(Array)
        String[] strArray1 = stream.toArray(String[]::new);
        // 2. Collection(集合)
        List<String> list1 = stream.collect(Collectors.toList());
        List<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
        Set set1 = stream.collect(Collectors.toSet());
        Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));
        // 3. String(字符串)
        String str = stream.collect(Collectors.joining()).toString();*/

    }

}
