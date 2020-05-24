package compareuntil.eclipsecollections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.collections.api.factory.Lists;

import versions.java8.modle.Person;

/**
 * @author xiaoy
 * @date 2020/05/23
 */
public class EcTest {

    // @BeforeClass
    // static public void loadData()
    // {
    // words = Lists.mutable.of((
    // "Bah, Bah, black sheep,\n" +
    // "Have you any wool?\n").split("[ ,\n?]+")
    // );
    // }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        var people = Lists.immutable.of(new Person("Alice", 19), new Person("Bob", 52), new Person("Carol", 35));

        var namesOver21 = people.select(person -> person.getAge() > 21) // Meat, no buns
            .collect(Person::getName); // Meat

        namesOver21.forEach(System.out::println);

        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();
        System.out.println(l1.getClass() == l2.getClass());
    }

}
