package Person.Employees;

import Person.Patients.Gender;

import java.util.Date;

public class Secretary extends Employee{
    public Secretary(String name, String surname, int age, Gender gender, Date dateOfBirth, double salary, Date dateOfEmployment) {
        super(name, surname, age, gender, dateOfBirth, salary, dateOfEmployment);
    }

    @Override
    public String description() {
        return null;
    }
}
