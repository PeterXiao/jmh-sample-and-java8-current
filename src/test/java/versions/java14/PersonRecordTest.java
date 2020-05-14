 package versions.java14;

import static org.junit.Assert.*;

import org.junit.Test;

import versions.java14.*;

public class PersonRecordTest {

    @Test
    void test() {
        Person person = new Person("Peter", "Parker");

        assertEquals("Peter", person.firstName());
        assertEquals("Parker", person.lastName());
    }

}




class PersonTest {


}