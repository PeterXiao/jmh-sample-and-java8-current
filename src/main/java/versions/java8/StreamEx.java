package versions.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xiaoy
 * @date 2020/05/16
 */
public class StreamEx {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stream<String> streamEmpty = Stream.empty();

        // Stream of Collection

        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();

        // Stream of Array

        Stream<String> streamOfArray = Stream.of("a", "b", "c");

        /* String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);*/

        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();

        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);

        // 创建无限流的另一种方法是使用iterate（）方法：

        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);

        IntStream streamOfChars = "abc".chars();

        Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a, b, c");

        // 文件流
        // Java NIO类文件允许通过lines（）方法生成文本文件的Stream <String>。文本的每一行都成为流的元素：
        /*        
         * Path path = Paths.get("C:\\file.txt");
           Stream<String> streamOfStrings = Files.lines(path);
           Stream<String> streamWithCharset = 
           Files.lines(path, Charset.forName("UTF-8"));
               //该字符集可以被指定为所述的自变量行（）方法。
        */

    }

    public Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }
}
