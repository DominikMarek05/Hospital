import Building.Hospital;
import Building.Rooms.Others.WaitingRoom;
import Person.Patients.Gender;
import Person.Patients.Patient;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Hospital hospital = new Hospital("Wojewódzki Szpital im. Zofii z Zamoyskich Tarnowskiej", "Tarnobrzeg", "Szpitalna 1, 39-400 Tarnobrzeg", 1904, "Wiktor Stasiak", "15 812 34 03", 7);
        System.out.println(hospital.description());

        Patient patient1 = new Patient("Dominik", "Marek", 18, Gender.Male, new Date(2005, Calendar.APRIL, 9), new Date(2023, Calendar.NOVEMBER, 7), new WaitingRoom("First waiting room", 1));
        Patient patient2 = new Patient("Andrzej", "Jajko", 22, Gender.Male, new Date(2001, Calendar.SEPTEMBER, 11), new Date(2023, Calendar.NOVEMBER, 7), new WaitingRoom("First waiting room", 1));
        Patient patient3 = new Patient("Stanisław", "Bartman", 25, Gender.Male, new Date(1998, Calendar.APRIL, 9), new Date(2023, Calendar.NOVEMBER, 7), new WaitingRoom("First waiting room", 1));
        Patient patient4 = new Patient("Janusz", "Wiśniewski", 16, Gender.Male, new Date(2007, Calendar.MARCH, 13), new Date(2023, Calendar.NOVEMBER, 7), new WaitingRoom("First waiting room", 1));
        Patient patient5 = new Patient("Gościwuj", "Sędziwój", 69, Gender.Male, new Date(1954, Calendar.FEBRUARY, 28), new Date(2023, Calendar.NOVEMBER, 7), new WaitingRoom("First waiting room", 1));

    }
}