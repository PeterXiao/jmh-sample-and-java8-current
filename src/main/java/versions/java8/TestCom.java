package versions.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author xiaoy
 * @date 2020/05/11
 */
public class TestCom {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));

        List<Integer> integers = Arrays.asList(1, 12, 433, 5);
        Optional<Integer> max = integers.stream().reduce(Math::max);
        max.ifPresent(value -> System.out.println(value));

        max.ifPresent(System.out::println);

        List<String> strings = Arrays.asList("how", "to", "do", "in", "java", "dot", "com");
        List<String> sorted = strings.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
        System.out.println(sorted);
        List<String> sortedAlt = strings.stream().sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(sortedAlt);

        List<Integer> integers1 = IntStream.range(1, 100).boxed().collect(Collectors.toCollection(ArrayList::new));
        Optional<Integer> max1 = integers1.stream().reduce(Math::max);
        max1.ifPresent(System.out::println);

        Optional<Integer> canBeEmpty1 = Optional.of(5);
        canBeEmpty1.isPresent(); // returns true
        canBeEmpty1.get(); // returns 5
        System.out.println(canBeEmpty1.get());
        Optional<Integer> canBeEmpty2 = Optional.empty();
        canBeEmpty2.isPresent(); // returns false
        // System.out.println(canBeEmpty2.get().toString());

        // Assume this value has returned from a method
        Optional<Company> companyOptional = Optional.empty();
        // Now check optional; if value is present then return it,
        // else create a new Company object and retur it
        Company company = companyOptional.orElse(new Company());
        // OR you can throw an exception as well
        // Company company1 = companyOptional.orElseThrow(IllegalStateException::new);
        //
        // Optional<Company> companyOptional1 = Optional.empty();
        // companyOptional1.filter(department -> "Finance".equals(department.getName()))
        // .ifPresent(() -> System.out.println("Finance is present"));

    }

}
