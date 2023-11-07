package Person.Employees;

import Building.Rooms.Room;
import Person.Patients.Gender;
import Person.Person;

import java.util.Date;

public abstract class Employee extends Person {
    private double salary;
    private Date dateOfEmployment;
    private static int numberOfEmployees;
    private Room workplace;

    public Employee(String name, String surname, int age, Gender gender, Date dateOfBirth, double salary, Date dateOfEmployment, Room workplace) {
        super(name, surname, age, gender, dateOfBirth);
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
        this.workplace = workplace;
        numberOfEmployees++;
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

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public static int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public static void readNumberOfEmployees(){
        System.out.println("The number of employees is " + getNumberOfEmployees());
    }
}
