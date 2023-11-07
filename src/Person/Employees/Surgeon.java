package Person.Employees;

import Building.Rooms.Room;
import Person.Patients.Gender;

import java.util.Date;

public class Surgeon extends Employee {
    private String speciality;

    public Surgeon(String name, String surname, int age, Gender gender, Date dateOfBirth, double salary, String speciality, Date dateOfEmployment, Room workplace) {
        super(name, surname, age, gender, dateOfBirth,salary, dateOfEmployment, workplace);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    @Override
    public String description() {
        return "SURGEON INFORMATIONS" +
                "Name: " + getName() + '\'' +
                "Surname: " + getSurname() + '\'' +
                "Age: " + getAge() + '\n' +
                "Gender: " + getGender() + '\n' +
                "Date of birth: " + getDateOfBirth() + '\n' +
                "Salary: " + getSalary() + '\n' +
                "Date of employment: " + getDateOfEmployment() + '\n' +
                "Speciality: " + getSpeciality();
    }
}
