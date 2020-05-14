package versions.java8;

import java.time.ZoneId;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IterationExamples {
    public static void main(String[] args) {
        List<String> alphabets = Arrays.asList(new String[] {"a", "b", "b", "d"});
        for (String letter : alphabets) {
            System.out.println(letter.toUpperCase());
        }

        List<String> alphabets1 = Arrays.asList(new String[] {"a", "b", "b", "d"});
        Iterator<String> iterator = alphabets1.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toUpperCase());
        }

        alphabets.forEach(l -> l.toUpperCase());

        String joined = String.join("/", "usr", "local", "bin");
        System.out.println(joined);
        String ids = String.join(", ", ZoneId.getAvailableZoneIds());
        System.out.println(ids);
    }
}