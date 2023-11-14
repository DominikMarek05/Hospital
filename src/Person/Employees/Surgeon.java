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
        return "\u001B[36mSURGEON INFORMATIONS" + '\n' +
                "Name: " + getName() + '\n' +
                "Surname: " + getSurname() + '\n' +
                "Age: " + getAge() + '\n' +
                "Gender: " + getGender() + '\n' +
                "Date of birth: " + getDateOfBirth().getYear() + "." + (getDateOfBirth().getMonth()+1) + "." + getDateOfBirth().getDay() + '\n' +
                "Salary: " + getSalary() + "PLN" + '\n' +
                "Date of employment: " + getDateOfEmployment().getYear() + "." + (getDateOfEmployment().getMonth()+1) + "." + getDateOfEmployment().getDay() + '\n' +
                "Workplace: " + getWorkplace().getName() + '\n' +
                "Speciality: " + getSpeciality() + '\n';
    }
}
