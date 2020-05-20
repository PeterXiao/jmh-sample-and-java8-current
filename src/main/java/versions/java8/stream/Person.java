package versions.java8.stream;

import lombok.Data;

/**
 * @author xiaoy
 * @date 2020/05/15
 */
@Data
public class Person {
    private String firstName, lastName, job, gender;
    private int salary, age;

    public Person(String firstName, String lastName, String job, String gender, int age, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.job = job;
        this.salary = salary;
    }
    // Getter and Setter
    // . . . . .

    /*public Object getFirstName() {
        // TODO Auto-generated method stub
        return firstName;
    }
    
    public Object getLastName() {
        // TODO Auto-generated method stub
        return lastName;
    }
    
    public int getSalary() {
        // TODO Auto-generated method stub
        return salary;
    }
    
    public Object setSalary(int i) {
        // TODO Auto-generated method stub
        this.salary = i;
        return null;
    }
    
    public Object getGender() {
        // TODO Auto-generated method stub
        return gender;
    }
    
    public int getAge() {
        // TODO Auto-generated method stub
        return age;
    }*/
}
