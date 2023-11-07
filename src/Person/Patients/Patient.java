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
        setPeopleInQueue(getPeopleInQueue()+1);
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String description() {
        return "PATIENT INFORMATIONS" +
                "Name: " + getName() + '\'' +
                "Surname: " + getSurname() + '\'' +
                "Age: " + getAge() + '\n' +
                "Gender: " + getGender() + '\n' +
                "Date of birth: " + getDateOfBirth() + '\n' +
                "Arrival date: " + getDateOfBirth() + '\n' +
                "Current location: " + currentLocation.description();
    }
}