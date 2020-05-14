package versions.java8.events;

import java.util.List;
import java.util.stream.Stream;

import versions.java8.modle.Person;

public class StreamFilterTest {

    public static void main(String[] args) {
        List<Person> persons = Person.getList();

        // get the stream (sequential version) to apply the filter operation
        Stream<Person> personsStream = persons.stream();

        // apply the filter
        Stream<Person> personsFilters = personsStream.filter(p -> p.getAge() >= 18);
        System.out.println("Persons filtered:");
        personsFilters.forEach((p) -> System.out.println(p));
    }
}