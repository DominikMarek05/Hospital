package Person.Employees;

import Building.Rooms.Room;
import Person.Patients.Gender;

import java.util.Date;

public class Nurse extends Employee{
    public Nurse(String name, String surname, int age, Gender gender, Date dateOfBirth, double salary, Date dateOfEmployment, Room workplace) {
        super(name, surname, age, gender, dateOfBirth, salary, dateOfEmployment, workplace);
    }

    @Override
    public String description() {
            return "NURSE INFORMATIONS" +
                    "Name: " + getName() + '\'' +
                    "Surname: " + getSurname() + '\'' +
                    "Age: " + getAge() + '\n' +
                    "Gender: " + getGender() + '\n' +
                    "Date of birth: " + getDateOfBirth() + '\n' +
                    "Salary: " + getSalary() + '\n' +
                    "Date of employment: " + getDateOfEmployment();
    }
}
