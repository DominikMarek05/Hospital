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
import Exceptions.CouldNotFind;
import Person.Employees.Employee;
import Person.Employees.Secretary;
import Person.Employees.Surgeon;
import Person.Patients.Gender;
import Person.Patients.Patient;
import com.sun.source.tree.Tree;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

import static Person.Patients.Gender.Female;
import static Person.Patients.Gender.Male;
import static java.util.Calendar.*;

public class Main {
    public static void main(String[] args) {

        Scanner inputNumber = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        Scanner inputDouble = new Scanner(System.in);
        Hospital hospital = new Hospital("Wojewódzki Szpital im. Zofii z Zamoyskich Tarnowskiej", "Tarnobrzeg", "Szpitalna 1, 39-400 Tarnobrzeg", 1904, "Wiktor Stasiak", "15 812 34 03", 7);
        System.out.println(hospital.description());

        // Creating room objects, adding them to RoomCollections object.

        RoomCollections roomCollections = new RoomCollections(new ArrayList<>());

        WaitingRoom waitingRoom = new WaitingRoom("Reception", 1);
        EmergencyDepartment emergencyDepartment = new EmergencyDepartment("Emergency Department", 2);
        Cardiology firstCardiology = new Cardiology("Cardiology room", 3);
        Cardiology secondCardiology = new Cardiology("Cardiology room for kids", 4);
        Laryngology firstLaryngology = new Laryngology("Laryngology room", 5);
        Laryngology secondLaryngology = new Laryngology("Laryngology room for kids", 6);
        Gynecology gynecology = new Gynecology("Gynecology room", 7);
        Neurosurgery firstNeurosurgery = new Neurosurgery("Neurosurgery room", 9);
        Neurosurgery secondNeurosurgery = new Neurosurgery("Neurosurgery room", 10);

        roomCollections.addCollections(waitingRoom, emergencyDepartment, firstCardiology, secondCardiology, firstLaryngology, secondLaryngology, gynecology, firstNeurosurgery, secondNeurosurgery);

        // Creating employee objects, adding them to EmployeeCollections object.

        EmployeeCollections employeeCollections = new EmployeeCollections(new ArrayList<>());

        Surgeon surgeon1 = new Surgeon("Stanisław", "Rejmontowski", 46, Male, new Date(1977, JANUARY, 1), 8330, "Cardiologist", new Date(1999, Calendar.APRIL, 9), firstCardiology);
        Surgeon surgeon2 = new Surgeon("Stanisław", "Latko", 55, Male, new Date(1968, FEBRUARY, 3), 9510, "Neurologist", new Date(1989, SEPTEMBER, 1), gynecology);
        Secretary secretary1 = new Secretary("Anna", "Nowak", 24, Female, new Date(1999, MAY, 26), 3000, new Date(2021, SEPTEMBER, 3), waitingRoom);
        Secretary secretary2 = new Secretary("Monika", "Dziarek", 26, Female, new Date(1997, JULY, 11), 3000, new Date(2022, SEPTEMBER, 9), waitingRoom);

        employeeCollections.addCollections(surgeon1, surgeon2, secretary1, secretary2);

        // Creating patient objects, adding them to PatientCollections object.

        PatientCollections patientCollections = new PatientCollections(new ArrayList<>());

        Patient patient1 = new Patient("Dominik", "Marek", 18, Male, new Date(2005, APRIL, 9), new Date(2023, NOVEMBER, 7), waitingRoom);
        Patient patient2 = new Patient("Andrzej", "Jajko", 22, Male, new Date(2001, SEPTEMBER, 11), new Date(2023, NOVEMBER, 7), waitingRoom);
        Patient patient3 = new Patient("Stanisław", "Bartman", 25, Male, new Date(1998, APRIL, 9), new Date(2023, NOVEMBER, 7), waitingRoom);
        Patient patient4 = new Patient("Janusz", "Wiśniewski", 16, Male, new Date(2007, MARCH, 13), new Date(2023, NOVEMBER, 7), waitingRoom);
        Patient patient5 = new Patient("Gościwuj", "Sędziwój", 69, Male, new Date(1954, FEBRUARY, 28), new Date(2023, NOVEMBER, 7), waitingRoom);

        patientCollections.addCollections(patient1, patient2, patient3, patient4, patient5);

        // starting application

        System.out.println("\u001B[39m\t");
        System.out.println("Welcome in hospital management application!\n");
        System.out.println("Write 1 if you want to show datas.");
        System.out.println("Write 2 if you want to modify datas.");
        System.out.println("Write 3 if you want to delete datas.");
        System.out.println("Write 4 if you want to add datas.");
        System.out.println("If you want to quit application, write 0");
        try {
            int decision = inputNumber.nextInt();
            switch (decision) {
                case 0 ->{
                    System.exit(0);
                }
                case 1 -> {
                        System.out.println("Which informations do you want to see?\n");
                        System.out.println("Write 1 for list of all rooms.");
                        System.out.println("Write 2 for list of all employees.");
                        System.out.println("Write 3 for list of all patients.");
                        int decisionShow = inputNumber.nextInt();
                        switch (decisionShow) {
                            case 1 -> {
                                for (int i = 0; i < roomCollections.getListOfAllRooms().size(); i++) {
                                    System.out.println("Number of room: " + roomCollections.getListOfAllRooms().get(i).getNumberOfRoom() + " - " + roomCollections.getListOfAllRooms().get(i).description());
                                }
                            }
                            case 2 -> {
                                for (int i = 0; i < employeeCollections.getListOfAllEmployees().size(); i++) {
                                    System.out.println(employeeCollections.getListOfAllEmployees().get(i).description());
                                }
                            }
                            case 3 -> {
                                for (int i = 0; i < patientCollections.getListOfAllPatients().size(); i++) {
                                    System.out.println(patientCollections.getListOfAllPatients().get(i).description());
                                }
                            }
                            default -> {
                                System.out.println("Wrong value");
                            }
                        }
                }
                case 2 ->{
                    System.out.println("Which informations do you want to update?\n");
                    System.out.println("Write 1 for rooms");
                    System.out.println("Write 2 for employees");
                    System.out.println("Write 3 for patients");
                    int decisionUpdate = inputNumber.nextInt();
                    switch(decisionUpdate){
                        case 1->{
                            System.out.println("Existing numbers of rooms:");
                            for (int i = 0; i < roomCollections.getListOfAllRooms().size(); i++) {
                                System.out.print(roomCollections.getListOfAllRooms().get(i).getNumberOfRoom() + " ");
                            }
                            System.out.println();
                            System.out.println("Write a number of room which you want to update");
                            int decisionRoom = inputNumber.nextInt();
                            Room newNumberRoom = roomCollections.searchRoom(decisionRoom);
                            System.out.println("Insert the new number of room.");
                            int newNumber = inputNumber.nextInt();
                            newNumberRoom.setNumberOfRoom(newNumber);
                        }
                        case 2->{
                            System.out.println("What do you want to change?\n");
                            System.out.println("Write 1 for name");
                            System.out.println("Write 2 for surname");
                            System.out.println("Write 3 for salary");
                            System.out.println("Write 4 for workplace");
                            System.out.println("Write 5 for speciality");
                            int decisionEmployee = inputNumber.nextInt();
                            switch(decisionEmployee){
                                case 1->{
                                    System.out.println("Existing names:");
                                    for(int i = 0; i < employeeCollections.getListOfAllEmployees().size(); i++){
                                        System.out.print(employeeCollections.getListOfAllEmployees().get(i).getName() + " " + employeeCollections.getListOfAllEmployees().get(i).getSurname() + "\n");
                                    }
                                    System.out.println();
                                    System.out.println("Write a name you want to update");
                                    String foundName = inputString.nextLine();
                                    ArrayList<Employee> employeeNames = employeeCollections.searchEmployeeByName(foundName);
                                    if(employeeNames.isEmpty()) System.out.println("Names no found.");
                                    else {
                                        for(int i = 0; i < employeeNames.size();i++){
                                            System.out.println((i+1) + ". " + employeeNames.get(i).getName() + " " + employeeNames.get(i).getSurname());
                                        }
                                        System.out.println("Choose name to change");
                                        int numberOfNameToChange = inputNumber.nextInt();
                                        if(numberOfNameToChange < 0 || numberOfNameToChange-1 > employeeNames.size()){
                                            System.out.println("You took the wrong number");
                                        }
                                        else {
                                            System.out.println("Insert the new name of employee.");
                                            String newName = inputString.nextLine();
                                            employeeNames.get(numberOfNameToChange-1).setName(newName);
                                        }
                                    }
                                }
                                case 2->{
                                        System.out.println("Existing surnames:");
                                        for(int i = 0; i < employeeCollections.getListOfAllEmployees().size(); i++){
                                            System.out.print(employeeCollections.getListOfAllEmployees().get(i).getName() + " " + employeeCollections.getListOfAllEmployees().get(i).getSurname() + "\n");
                                        }
                                        System.out.println();
                                        System.out.println("Write a surname you want to update");
                                        String foundSurname = inputString.nextLine();
                                        ArrayList<Employee> employeeSurnames = employeeCollections.searchEmployeeBySurname(foundSurname);
                                        if(employeeSurnames.isEmpty()) System.out.println("Surnames no found.");
                                        else {
                                            for(int i = 0; i < employeeSurnames.size();i++){
                                                System.out.println((i+1) + ". " + employeeSurnames.get(i).getName() + " " + employeeSurnames.get(i).getSurname());
                                            }
                                            System.out.println("Choose surname to change");
                                            int numberOfSurnameToChange = inputNumber.nextInt();
                                            if(numberOfSurnameToChange < 0 || numberOfSurnameToChange-1 > employeeSurnames.size()){
                                                System.out.println("You took the wrong number");
                                            }
                                            else {
                                                System.out.println("Insert the new surname of employee.");
                                                String newSurname = inputString.nextLine();
                                                employeeSurnames.get(numberOfSurnameToChange-1).setSurname(newSurname);
                                            }
                                        }
                                }
                                case 3->{
                                    System.out.println("Existing salaries:");
                                    for(int i = 0; i < employeeCollections.getListOfAllEmployees().size(); i++){
                                        System.out.print(employeeCollections.getListOfAllEmployees().get(i).getName() + " " + employeeCollections.getListOfAllEmployees().get(i).getSurname() + " " + employeeCollections.getListOfAllEmployees().get(i).getSalary() + "\n");
                                    }
                                    System.out.println();
                                    System.out.println("Write a salary you want to update");
                                    Double foundSalary = inputDouble.nextDouble();
                                    ArrayList<Employee> employeeSalaries = employeeCollections.searchEmployeeBySalary(foundSalary);
                                    if(employeeSalaries.isEmpty()) System.out.println("Salaries no found.");
                                    else {
                                        for(int i = 0; i < employeeSalaries.size();i++){
                                            System.out.println((i+1) + ". " + employeeSalaries.get(i).getName() + " " + employeeSalaries.get(i).getSurname() + " " + employeeSalaries.get(i).getSalary());
                                        }
                                        System.out.println("Choose salary to change");
                                        int numberOfSalaryToChange = inputNumber.nextInt();
                                        if(numberOfSalaryToChange < 0 || numberOfSalaryToChange-1 > employeeSalaries.size()){
                                            System.out.println("You took the wrong number");
                                        }
                                        else {
                                            System.out.println("Insert the new name of employee.");
                                            double newSalary = inputDouble.nextDouble();
                                            employeeSalaries.get(numberOfSalaryToChange-1).setSalary(newSalary);
                                        }
                                    }
                                }
                                case 4 ->{
                                    System.out.println("Existing workplaces:");
                                    for(int i = 0; i < employeeCollections.getListOfAllEmployees().size(); i++){
                                        System.out.print(employeeCollections.getListOfAllEmployees().get(i).getName() + " " + employeeCollections.getListOfAllEmployees().get(i).getSurname() + " " + employeeCollections.getListOfAllEmployees().get(i).getWorkplace().getName() + "\n");
                                    }
                                    System.out.println();
                                    System.out.println("Write a workplace you want to update");
                                    String foundWorkplace = inputString.nextLine();
                                    ArrayList<Employee> employeeWorkplaces = employeeCollections.searchEmployeeByWorkplaceName(foundWorkplace);
                                    if(employeeWorkplaces.isEmpty()) System.out.println("Salaries no found.");
                                    else {
                                        for(int i = 0; i < employeeWorkplaces.size();i++){
                                            System.out.println((i+1) + ". " + employeeWorkplaces.get(i).getName() + " " + employeeWorkplaces.get(i).getSurname() + " " + employeeWorkplaces.get(i).getWorkplace().getName());
                                        }
                                        System.out.println("Choose workplace to change");
                                        int numberOfWorkplaceToChange = inputNumber.nextInt();
                                        if(numberOfWorkplaceToChange < 0 || numberOfWorkplaceToChange-1 > employeeWorkplaces.size()){
                                            System.out.println("You took the wrong number");
                                        }
                                        else {
                                            System.out.println("Insert the new workplace name of employee.");
                                            String newWorkplaceName = inputString.nextLine();
                                            int newWorkplaceNumber = inputNumber.nextInt();
                                            System.out.println("Chooce in which room employee will work");
                                            for (int i = 0; i < roomCollections.getListOfAllRooms().size(); i++) {
                                                System.out.println((i+1) + ". " + roomCollections.getListOfAllRooms().get(i).getName() + " " + roomCollections.getListOfAllRooms().get(i).getNumberOfRoom());
                                            }
                                            int numberOfWorkplace = inputNumber.nextInt();
                                            if(numberOfWorkplace < 0 || numberOfWorkplace-1 > roomCollections.getListOfAllRooms().size()){
                                                System.out.println("You took the wrong number");
                                            }
                                            else {
//                                            employeeWorkplaces.get(numberOfWorkplaceToChange-1).setWorkplace(new Room(newWorkplaceName, newWorkplaceNumber));
                                                System.out.println("nwm");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        catch (InputMismatchException e){
            System.out.println("Introduced wrong value.");
        }
        catch(CouldNotFind e){
            System.out.println(e.getMessage());
        }
    }
}