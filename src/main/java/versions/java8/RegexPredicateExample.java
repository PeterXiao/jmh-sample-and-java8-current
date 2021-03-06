package versions.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.junit.Test;

public class RegexPredicateExample {
    public static void main(String[] args) {
        // Compile regex as predicate
        Predicate<String> emailFilter = Pattern.compile("^(.+)@example.com$").asPredicate();
        // Input list
        List<String> emails = Arrays.asList("alex@example.com", "bob@yahoo.com", "cat@google.com", "david@example.com");
        // Apply predicate filter
        List<String> desiredEmails = emails.stream().filter(emailFilter).collect(Collectors.<String>toList());
        // Now perform desired operation
        desiredEmails.forEach(System.out::println);
    }

    @Test
    public static void test(String[] args) {
        Pattern pattern = Pattern.compile("^(.+)@example.com$");
        // Input list
        List<String> emails = Arrays.asList("alex@example.com", "bob@yahoo.com", "cat@google.com", "david@example.com");
        for (String email : emails) {
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                System.out.println(email);
            }
        }
    }
}