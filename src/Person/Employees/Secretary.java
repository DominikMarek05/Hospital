package Person.Employees;

import Building.Rooms.Room;
import Person.Patients.Gender;

import java.util.Date;

public class Secretary extends Employee{
    public Secretary(String name, String surname, int age, Gender gender, Date dateOfBirth, double salary, Date dateOfEmployment, Room workplace) {
        super(name, surname, age, gender, dateOfBirth, salary, dateOfEmployment, workplace);
    }

    @Override
    public String description() {
        return "\u001B[35mSECRETARY INFORMATIONS" + '\n' +
                "Name: " + getName() + '\n' +
                "Surname: " + getSurname() + '\n' +
                "Age: " + getAge() + '\n' +
                "Gender: " + getGender() + '\n' +
                "Date of birth: " + getDateOfBirth().getYear() + "." + (getDateOfBirth().getMonth()+1) + "." + getDateOfBirth().getDate() + '\n' +
                "Salary: " + getSalary() + '\n' +
                "Date of employment: " + getDateOfEmployment().getYear() + "." + (getDateOfEmployment().getMonth()+1) + "." + getDateOfEmployment().getDate() + '\n' +
                "Workplace: " + getWorkplace().getName() + '\n';
    }
}
