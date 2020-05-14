package versions.java8.events;

/**
 * @author xiaoy
 * @date 2020/05/13
 */

import java.util.Objects;

public class ValidationExamples {

    public static void doFoo(String aVar) {
        // will throw a NPE with the given message
        Objects.requireNonNull(aVar, "Got a null argument");

        System.out.println("Requires non-null: " + aVar);
    }

    public static void doBar(String anotherVar) {
        if (Objects.isNull(anotherVar))
            System.out.println("Got a null");
        else
            System.out.println("Got a non-null: " + anotherVar);
    }
}
