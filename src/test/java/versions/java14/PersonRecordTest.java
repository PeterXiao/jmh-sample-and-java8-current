package versions.java14;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonRecordTest {

    @Test
    void test() {
        Person person = new Person("Peter", "Parker");

        assertEquals("Peter", person.firstName());
        assertEquals("Parker", person.lastName());
        assertEquals("Peter", person.firstName());
        assertEquals("Parker", person.lastName());
    }

}

class PersonTest {

}