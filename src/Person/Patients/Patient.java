package Person.Patients;

import Building.Rooms.Room;
import Person.Person;

import java.util.Date;

import static Building.Rooms.Others.WaitingRoom.getPeopleInQueue;
import static Building.Rooms.Others.WaitingRoom.setPeopleInQueue;

public class Patient extends Person {
    private Date arrivalDate;
    private Room currentLocation;

    public Patient(String name, String surname, int age, Gender gender, Date dateOfBirth, Date arrivalDate, Room currentLocation) {
        super(name, surname, age, gender, dateOfBirth);
        this.arrivalDate = arrivalDate;
        this.currentLocation = currentLocation;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String description() {
        return "PATIENT INFORMATIONS" + '\n' +
                "Name: " + getName() + '\n' +
                "Surname: " + getSurname() + '\n' +
                "Age: " + getAge() + '\n' +
                "Gender: " + getGender() + '\n' +
                "Date of birth: " + getDateOfBirth().getYear() + '.' +(getDateOfBirth().getMonth()+1) + '.' + getDateOfBirth().getDate() + '\n' +
                "Arrival date: " + getArrivalDate().getYear() + '.' + (getArrivalDate().getMonth()+1) + '.' + getArrivalDate().getDate() + '\n' +
                "Current location: " + currentLocation.description() + '\n';
    }
}