package Person.Patients;

import Person.Person;

import java.util.Date;

public class Patient extends Person {
    private Date arrivalDate;


    public Patient(String name, String surname, int age, Gender gender, Date dateOfBirth, Date arrivalDate) {
        super(name, surname, age, gender, dateOfBirth);
        this.arrivalDate = arrivalDate;
    }

    @Override
    public String description() {
        return null;
    }
}
