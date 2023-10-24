package Person;
import Person.Patients.Gender;

import java.util.Date;

public abstract class Person {
    private String name;
    private String surname;
    private int age;
    private Gender gender;
    private Date dateOfBirth;

    public abstract String description();

    public Person(String name, String surname, int age, Gender gender, Date dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}
