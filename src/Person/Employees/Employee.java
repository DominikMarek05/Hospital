package Person.Employees;

import Person.Patients.Gender;
import Person.Person;

import java.util.Date;

public abstract class Employee extends Person {
    private double salary;
    private Date dateOfEmployment;

    public Employee(String name, String surname, int age, Gender gender, Date dateOfBirth, double salary, Date dateOfEmployment) {
        super(name, surname, age, gender, dateOfBirth);
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
    }

    @Override
    public abstract String description();
}
