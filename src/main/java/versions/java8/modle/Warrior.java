package versions.java8.modle;

/**
 * @author xiaoy
 * @date 2020/05/13
 */
public class Warrior {
    private Person person;
    private String type;

    public Warrior(Person person) {
        this.person = person;
        type = "Warrior " + person.getAge();
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return type;
    }

}
