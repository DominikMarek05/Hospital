package Person.Employees;

import Person.Patients.Gender;

import java.util.Date;

public class Surgeon extends Employee {
    private String speciality;

    public Surgeon(String name, String surname, int age, Gender gender, Date dateOfBirth, double salary, String speciality, Date dateOfEmployment) {
        super(name, surname, age, gender, dateOfBirth,salary, dateOfEmployment);
        this.speciality = speciality;
    }

    @Override
    public String description() {
        return null;
    }
}
