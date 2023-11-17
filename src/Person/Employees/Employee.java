package Person.Employees;

import Building.Rooms.Room;
import Person.Patients.Gender;
import Person.Person;

import java.util.Date;

public abstract class Employee extends Person {
    private double salary;
    private Date dateOfEmployment;
    private Room workplace;

    public Employee(String name, String surname, int age, Gender gender, Date dateOfBirth, double salary, Date dateOfEmployment, Room workplace) {
        super(name, surname, age, gender, dateOfBirth);
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
        this.workplace = workplace;
    }

    @Override
    public abstract String description();

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public Room getWorkplace() {
        return workplace;
    }

    public void setWorkplace(Room workplace) {
        this.workplace = workplace;
    }
}
