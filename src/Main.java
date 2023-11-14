import Building.Hospital;
import Building.Rooms.Branch.Cardiology;
import Building.Rooms.Branch.Gynecology;
import Building.Rooms.Branch.Laryngology;
import Building.Rooms.Branch.Neurosurgery;
import Building.Rooms.Others.EmergencyDepartment;
import Building.Rooms.Others.WaitingRoom;
import Building.Rooms.Room;
import Collections.EmployeeCollections;
import Collections.PatientCollections;
import Collections.RoomCollections;
import Person.Employees.Employee;
import Person.Employees.Secretary;
import Person.Employees.Surgeon;
import Person.Patients.Gender;
import Person.Patients.Patient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static Person.Patients.Gender.Female;
import static Person.Patients.Gender.Male;
import static java.util.Calendar.*;

public class Main {
    public static void main(String[] args) {

        Hospital hospital = new Hospital("Wojewódzki Szpital im. Zofii z Zamoyskich Tarnowskiej", "Tarnobrzeg", "Szpitalna 1, 39-400 Tarnobrzeg", 1904, "Wiktor Stasiak", "15 812 34 03", 7);
        System.out.println(hospital.description());

        RoomCollections roomCollections = new RoomCollections(new ArrayList<>());
        EmployeeCollections employeeCollections = new EmployeeCollections(new ArrayList<>());
        PatientCollections patientCollections = new PatientCollections(new ArrayList<>());

        WaitingRoom waitingRoom = new WaitingRoom("Reception", 1);
        EmergencyDepartment emergencyDepartment = new EmergencyDepartment("Emergency Department", 2);
        Cardiology firstCardiology = new Cardiology("Cardiology room", 3);
        Cardiology secondCardiology = new Cardiology("Cardiology room for kids", 4);
        Laryngology firstLaryngology = new Laryngology("Laryngology room", 5);
        Laryngology secondLaryngology = new Laryngology("Laryngology room for kids", 6);
        Gynecology gynecology = new Gynecology("Gynecology room", 7);
        Neurosurgery firstNeurosurgery = new Neurosurgery("Neurosurgery room", 9);
        Neurosurgery secondNeurosurgery = new Neurosurgery("Neurosurgery room", 10);

        roomCollections.addCollections(firstCardiology, secondCardiology, firstLaryngology, secondLaryngology, gynecology, firstNeurosurgery, secondNeurosurgery);
        for(int i = 0; i < roomCollections.getListOfAllRooms().size(); i++){
            System.out.println(roomCollections.getListOfAllRooms().get(i).description());
        }

        Patient patient1 = new Patient("Dominik", "Marek", 18, Male, new Date(2005, APRIL, 9), new Date(2023, NOVEMBER, 7), waitingRoom);
        Patient patient2 = new Patient("Andrzej", "Jajko", 22, Male, new Date(2001, SEPTEMBER, 11), new Date(2023, NOVEMBER, 7), waitingRoom);
        Patient patient3 = new Patient("Stanisław", "Bartman", 25, Male, new Date(1998, APRIL, 9), new Date(2023, NOVEMBER, 7), waitingRoom);
        Patient patient4 = new Patient("Janusz", "Wiśniewski", 16, Male, new Date(2007, MARCH, 13), new Date(2023, NOVEMBER, 7), waitingRoom);
        Patient patient5 = new Patient("Gościwuj", "Sędziwój", 69, Male, new Date(1954, FEBRUARY, 28), new Date(2023, NOVEMBER, 7), waitingRoom);

        Surgeon surgeon1 = new Surgeon("Stanisław", "Rejmontowski", 46, Male, new Date(1977, JANUARY, 1), 8330, "Cardiologist", new Date(1999, Calendar.APRIL, 9), firstCardiology);
        Surgeon surgeon2 = new Surgeon("Jarosław", "Latko", 55, Male, new Date(1968, FEBRUARY, 3), 9510, "Neurologist", new Date(1989, SEPTEMBER, 1), gynecology);
        System.out.println(surgeon1.description());

        Secretary secretary1 = new Secretary("Anna", "Nowak", 24, Female, new Date(1999, MAY, 26), 3000, new Date(2021, SEPTEMBER, 3), waitingRoom);
        Secretary secretary2 = new Secretary("Monika", "Dziarek", 26, Female, new Date(1997, JULY, 11), 3000, new Date(2022, SEPTEMBER, 9), waitingRoom);
        System.out.println(secretary1.description());
    }
}