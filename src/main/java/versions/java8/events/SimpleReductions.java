package versions.java8.events;

import java.util.stream.IntStream;

/**
 * @author xiaoy
 * @date 2020/05/13
 */
public class SimpleReductions {
    public static void main(String[] args) {
        int result = IntStream.range(0, 100).filter(n -> n % 2 == 0).reduce(0, Integer::sum);
        System.out.println("Sum of odd numbers: " + result);

        int powResult = IntStream.range(0, 100).map(x -> x * x).reduce(0, Integer::sum);
        System.out.println("Sum of powed numbers: " + powResult);
    }
}