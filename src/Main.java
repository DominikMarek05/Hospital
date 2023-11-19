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
import Person.Employees.Nurse;
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

        int decision;
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

        try {
            System.out.println("\u001B[39m\t");
            System.out.println("Welcome in hospital management application!\n");
            do{
            System.out.println("\u001B[39m\t");
            System.out.println("Welcome in hospital management application!\n");
            System.out.println("Write 1 if you want to show datas.");
            System.out.println("Write 2 if you want to modify datas.");
            System.out.println("Write 3 if you want to delete datas.");
            System.out.println("Write 4 if you want to add datas.");
            System.out.println("Write 0 if you want to quit application.");
            decision = inputNumber.nextInt();
            switch (decision) {
                case 0 -> {
                    System.exit(0);
                }
                case 1 -> {
                    // show
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
                            System.out.println("Introduced wrong value.");
                        }
                    }
                }
                case 2 -> {
                    // update
                    System.out.println("Which informations do you want to update?\n");
                    System.out.println("Write 1 for rooms");
                    System.out.println("Write 2 for employees");
                    System.out.println("Write 3 for patients");
                    int decisionUpdate = inputNumber.nextInt();
                    switch (decisionUpdate) {
                        case 1 -> {
                            System.out.println("Existing numbers of rooms:");
                            for (int i = 0; i < roomCollections.getListOfAllRooms().size(); i++) {
                                System.out.print(roomCollections.getListOfAllRooms().get(i).getNumberOfRoom() + " ");
                            }
                            System.out.println("\nWrite a number of room which you want to update");
                            int decisionRoom = inputNumber.nextInt();
                            Room newNumberRoom = roomCollections.searchRoom(decisionRoom);
                            System.out.println("Insert the new number of room.");
                            int newNumber = inputNumber.nextInt();
                            newNumberRoom.setNumberOfRoom(newNumber);
                        }
                        case 2 -> {
                            System.out.println("Existing employees:\n");
                            for (int i = 0; i < employeeCollections.getListOfAllEmployees().size(); i++) {
                                System.out.println(employeeCollections.getListOfAllEmployees().get(i).description());
                            }
                            System.out.println("\u001B[39mWhat do you want to change?\n");
                            System.out.println("Write 1 for name");
                            System.out.println("Write 2 for surname");
                            System.out.println("Write 3 for salary");
                            System.out.println("Write 4 for workplace");
                            int decisionEmployee = inputNumber.nextInt();
                            switch (decisionEmployee) {
                                case 1 -> {
                                    System.out.println("Existing names:");
                                    for (int i = 0; i < employeeCollections.getListOfAllEmployees().size(); i++) {
                                        System.out.print(employeeCollections.getListOfAllEmployees().get(i).getName() + " " + employeeCollections.getListOfAllEmployees().get(i).getSurname() + "\n");
                                    }
                                    System.out.println();
                                    System.out.println("Write a name you want to update");
                                    String foundName = inputString.nextLine();
                                    ArrayList<Employee> employeeNames = employeeCollections.searchEmployeeByName(foundName);
                                    if (employeeNames.isEmpty()) System.out.println("Names no found.");
                                    else {
                                        for (int i = 0; i < employeeNames.size(); i++) {
                                            System.out.println((i + 1) + ". " + employeeNames.get(i).getName() + " " + employeeNames.get(i).getSurname());
                                        }
                                        if (employeeNames.size() == 1) {
                                            System.out.println("Insert the new name of employee.");
                                            String newName = inputString.nextLine();
                                            employeeNames.get(0).setName(newName);
                                        }
                                        System.out.println("Choose name to change (1-" + employeeNames.size() + ")");
                                        int numberOfNameToChange = inputNumber.nextInt();
                                        if (numberOfNameToChange < 0 || numberOfNameToChange - 1 > employeeNames.size()) {
                                            System.out.println("You took the wrong number");
                                        } else {
                                            System.out.println("Insert the new name of employee.");
                                            String newName = inputString.nextLine();
                                            employeeNames.get(numberOfNameToChange - 1).setName(newName);
                                        }
                                    }
                                }
                                case 2 -> {
                                    System.out.println("Existing surnames:");
                                    for (int i = 0; i < employeeCollections.getListOfAllEmployees().size(); i++) {
                                        System.out.print(employeeCollections.getListOfAllEmployees().get(i).getName() + " " + employeeCollections.getListOfAllEmployees().get(i).getSurname() + "\n");
                                    }
                                    System.out.println("\nWrite a surname you want to update");
                                    String foundSurname = inputString.nextLine();
                                    ArrayList<Employee> employeeSurnames = employeeCollections.searchEmployeeBySurname(foundSurname);
                                    if (employeeSurnames.isEmpty()) System.out.println("Surnames no found.");
                                    else {
                                        for (int i = 0; i < employeeSurnames.size(); i++) {
                                            System.out.println((i + 1) + ". " + employeeSurnames.get(i).getName() + " " + employeeSurnames.get(i).getSurname());
                                        }
                                        if (employeeSurnames.size() == 1) {
                                            System.out.println("Insert the new surname of employee.");
                                            String newSurname = inputString.nextLine();
                                            employeeSurnames.get(0).setSurname(newSurname);
                                        } else {
                                            System.out.println("Choose surname to change (1-" + employeeSurnames.size() + ")");
                                            int numberOfSurnameToChange = inputNumber.nextInt();
                                            if (numberOfSurnameToChange < 0 || numberOfSurnameToChange - 1 > employeeSurnames.size()) {
                                                System.out.println("You took the wrong number");
                                            } else {
                                                System.out.println("Insert the new surname of employee.");
                                                String newSurname = inputString.nextLine();
                                                employeeSurnames.get(numberOfSurnameToChange - 1).setSurname(newSurname);
                                            }
                                        }
                                    }
                                }
                                case 3 -> {
                                    System.out.println("Existing salaries:");
                                    for (int i = 0; i < employeeCollections.getListOfAllEmployees().size(); i++) {
                                        System.out.print(employeeCollections.getListOfAllEmployees().get(i).getName() + " " + employeeCollections.getListOfAllEmployees().get(i).getSurname() + " " + employeeCollections.getListOfAllEmployees().get(i).getSalary() + "\n");
                                    }
                                    System.out.println("\nWrite a salary you want to update");
                                    double foundSalary = inputDouble.nextDouble();
                                    ArrayList<Employee> employeeSalaries = employeeCollections.searchEmployeeBySalary(foundSalary);
                                    if (employeeSalaries.isEmpty()) System.out.println("Salaries no found.");
                                    else {
                                        for (int i = 0; i < employeeSalaries.size(); i++) {
                                            System.out.println((i + 1) + ". " + employeeSalaries.get(i).getName() + " " + employeeSalaries.get(i).getSurname() + " " + employeeSalaries.get(i).getSalary());
                                        }
                                        if (employeeSalaries.size() == 1) {
                                            System.out.println("Insert the new name of employee.");
                                            double newSalary = inputDouble.nextDouble();
                                            employeeSalaries.get(0).setSalary(newSalary);
                                        } else {
                                            System.out.println("Choose salary to change (1-" + employeeSalaries.size() + ")");
                                            int numberOfSalaryToChange = inputNumber.nextInt();
                                            if (numberOfSalaryToChange < 0 || numberOfSalaryToChange - 1 > employeeSalaries.size()) {
                                                System.out.println("You took the wrong number");
                                            } else {
                                                System.out.println("Insert the new name of employee.");
                                                double newSalary = inputDouble.nextDouble();
                                                employeeSalaries.get(numberOfSalaryToChange - 1).setSalary(newSalary);
                                            }
                                        }
                                    }
                                }
                                case 4 -> {
                                    System.out.println("Existing workplaces:");
                                    for (int i = 0; i < employeeCollections.getListOfAllEmployees().size(); i++) {
                                        System.out.print(employeeCollections.getListOfAllEmployees().get(i).getName() + " " + employeeCollections.getListOfAllEmployees().get(i).getSurname() + " " + employeeCollections.getListOfAllEmployees().get(i).getWorkplace().getName() + ", number of room: " + employeeCollections.getListOfAllEmployees().get(i).getWorkplace().getNumberOfRoom() + "\n");
                                    }
                                    System.out.println("\nWrite a workplace you want to update.");
                                    String foundWorkplace = inputString.nextLine();
                                    ArrayList<Employee> employeeWorkplaces = employeeCollections.searchEmployeeByWorkplaceName(foundWorkplace);
                                    if (employeeWorkplaces.isEmpty()) System.out.println("Workplaces no found.");
                                    else {
                                        for (int i = 0; i < employeeWorkplaces.size(); i++) {
                                            System.out.println((i + 1) + ". " + employeeWorkplaces.get(i).getName() + " " + employeeWorkplaces.get(i).getSurname() + " " + employeeWorkplaces.get(i).getWorkplace().getName());
                                        }
                                        if (employeeWorkplaces.size() == 1) {
                                            System.out.println("Insert the number of new workplace.");
                                            int newWorkplace = inputNumber.nextInt();
                                            employeeWorkplaces.get(0).setWorkplace(roomCollections.searchRoom(newWorkplace));
                                        } else {
                                            System.out.println("Choose workplace to change (1-" + employeeWorkplaces.size() + ")");
                                            int numberOfWorkplaceToChange = inputNumber.nextInt();
                                            if (numberOfWorkplaceToChange < 0 || numberOfWorkplaceToChange - 1 > employeeWorkplaces.size()) {
                                                System.out.println("You took the wrong number");
                                            } else {
                                                System.out.println("Insert the number of new workplace.");
                                                int newWorkplace = inputNumber.nextInt();
                                                employeeWorkplaces.get(numberOfWorkplaceToChange - 1).setWorkplace(roomCollections.searchRoom(newWorkplace));
                                            }
                                        }
                                    }
                                }
                                default -> {
                                    System.out.println("Introduced wrong value.");
                                }
                            }
                        }
                        case 3 -> {
                            System.out.println("Existing patients:");
                            for (int i = 0; i < patientCollections.getListOfAllPatients().size(); i++) {
                                System.out.println(patientCollections.getListOfAllPatients().get(i).description());
                            }
                            System.out.println("What do you want to change?");
                            System.out.println("Write 1 for name");
                            System.out.println("Write 2 for surname");
                            int decisionPatient = inputNumber.nextInt();
                            switch (decisionPatient) {
                                case 1 -> {
                                    System.out.println("Existing names:");
                                    for (int i = 0; i < patientCollections.getListOfAllPatients().size(); i++) {
                                        System.out.print(patientCollections.getListOfAllPatients().get(i).getName() + " " + patientCollections.getListOfAllPatients().get(i).getSurname() + "\n");
                                    }
                                    System.out.println("Write a name you want to change");
                                    String foundName = inputString.nextLine();
                                    ArrayList<Patient> patientNames = patientCollections.searchPatientByName(foundName);
                                    if (patientNames.isEmpty()) System.out.println("Names not found.");
                                    else {
                                        for (int i = 0; i < patientNames.size(); i++) {
                                            System.out.println((i + 1) + ". " + patientNames.get(i).getName() + " " + patientNames.get(i).getSurname());
                                        }
                                        if (patientNames.size() == 1) {
                                            System.out.println("Insert the new name of employee.");
                                            String newName = inputString.nextLine();
                                            patientNames.get(0).setName(newName);
                                        } else {
                                            System.out.println("Choose name to change (1-" + patientNames.size() + ")");
                                            int numberOfNameToChange = inputNumber.nextInt();
                                            if (numberOfNameToChange < 0 || numberOfNameToChange - 1 > patientNames.size()) {
                                                System.out.println("You took the wrong number");
                                            } else {
                                                System.out.println("Insert the new name of employee.");
                                                String newName = inputString.nextLine();
                                                patientNames.get(numberOfNameToChange - 1).setName(newName);
                                            }
                                        }
                                    }
                                }
                                case 2 -> {
                                    System.out.println("Existing surnames:");
                                    for (int i = 0; i < patientCollections.getListOfAllPatients().size(); i++) {
                                        System.out.print(patientCollections.getListOfAllPatients().get(i).getName() + " " + patientCollections.getListOfAllPatients().get(i).getSurname() + "\n");
                                    }
                                    System.out.println("Write a surname you want to change");
                                    String foundSurname = inputString.nextLine();
                                    ArrayList<Patient> patientSurnames = patientCollections.searchPatientBySurname(foundSurname);
                                    if (patientSurnames.isEmpty()) System.out.println("Surnames not found.");
                                    else {
                                        for (int i = 0; i < patientSurnames.size(); i++) {
                                            System.out.println((i + 1) + ". " + patientSurnames.get(i).getName() + " " + patientSurnames.get(i).getSurname());
                                        }
                                        if (patientSurnames.size() == 1) {
                                            System.out.println("Insert the new surname of employee.");
                                            String newSurname = inputString.nextLine();
                                            patientSurnames.get(0).setSurname(newSurname);
                                        } else {
                                            System.out.println("Choose surname to change (1-" + patientSurnames.size() + ")");
                                            int numberOfSurnameToChange = inputNumber.nextInt();
                                            if (numberOfSurnameToChange < 0 || numberOfSurnameToChange - 1 > patientSurnames.size()) {
                                                System.out.println("You took the wrong number");
                                            } else {
                                                System.out.println("Insert the new surname of employee.");
                                                String newSurname = inputString.nextLine();
                                                patientSurnames.get(numberOfSurnameToChange - 1).setSurname(newSurname);
                                            }
                                        }
                                    }
                                }
                                default -> {
                                    System.out.println("Introduced wrong value.");
                                }
                            }
                        }
                        default -> {
                            System.out.println("Introduced wrong value.");
                        }
                    }
                }
                case 3 -> {
                    // Delete
                    System.out.println("What do you want to delete?");
                    System.out.println("Write 1 for rooms.");
                    System.out.println("Write 2 for employees.");
                    System.out.println("Write 3 for patients");
                    int decisionRemove = inputNumber.nextInt();
                    switch (decisionRemove) {
                        case 1 -> {
                            System.out.println("Existing rooms:");
                            System.out.println("Existing numbers of rooms:");
                            for (int i = 0; i < roomCollections.getListOfAllRooms().size(); i++) {
                                System.out.print(roomCollections.getListOfAllRooms().get(i).getNumberOfRoom() + " ");
                            }
                            System.out.println("\nWrite a number of room which you want to remove");
                            int decisionRoom = inputNumber.nextInt();
                            Room deletedRoom = roomCollections.searchRoom(decisionRoom);
                            roomCollections.removeRoom(decisionRoom);
                            System.out.println("You removed:\n" + deletedRoom.description());
                        }
                        case 2 -> {
                            System.out.println("Existing employees:");
                            for (int i = 0; i < employeeCollections.getListOfAllEmployees().size(); i++) {
                                System.out.println(employeeCollections.getListOfAllEmployees().get(i).description());
                            }
                            System.out.println("Write a name of employee you want to remove.");
                            String employeeNameRemove = inputString.nextLine();
                            System.out.println("Write a surname of employee you want to remove.");
                            String employeeSurnameRemove = inputString.nextLine();
                            Employee deletedEmployee = employeeCollections.searchEmployeeByNameAndSurname(employeeNameRemove, employeeSurnameRemove);
                            employeeCollections.removeEmployee(employeeNameRemove, employeeSurnameRemove);
                            System.out.println("You removed:\n" + deletedEmployee.description());
                        }
                        case 3 -> {
                            System.out.println("Existing patients:");
                            for (int i = 0; i < patientCollections.getListOfAllPatients().size(); i++) {
                                System.out.println(patientCollections.getListOfAllPatients().get(i).description());
                            }
                            System.out.println("Write a name of patient you want to remove.");
                            String patientNameRemove = inputString.nextLine();
                            System.out.println("Write a surname of patient you want to remove.");
                            String patientSurnameRemove = inputString.nextLine();
                            Patient deletedPatient = patientCollections.searchPatientByNameAndSurname(patientNameRemove, patientSurnameRemove);
                            patientCollections.removePatient(patientNameRemove, patientSurnameRemove);
                            System.out.println("You removed:\n" + deletedPatient.description());
                        }
                        default -> {
                            System.out.println("Introduced wrong value.");
                        }
                    }
                }
                case 4 -> {
                    // Add
                    System.out.println("What do you want to add?");
                    System.out.println("Write 1 for room");
                    System.out.println("Write 2 for employee");
                    System.out.println("Write 3 for patient");
                    int decisionAdd = inputNumber.nextInt();
                    switch (decisionAdd) {
                        case 1 -> {
                            System.out.println("Write 1 if you want to create Emergency Department");
                            System.out.println("Write 2 if you want to create Waiting room");
                            System.out.println("Write 3 if you want to create Cardiology");
                            System.out.println("Write 4 if you want to create Gynecology");
                            System.out.println("Write 5 if you want to create Laryngology");
                            System.out.println("Write 6 if you want to create Neurosurgery");
                            int decisionAddRoom = inputNumber.nextInt();
                            switch (decisionAddRoom) {
                                case 1 -> {
                                    System.out.println("Write name of new room");
                                    String newRoomName = inputString.nextLine();
                                    System.out.println("Write number of new room");
                                    int newRoomNumber = inputNumber.nextInt();
                                    roomCollections.addCollections(new EmergencyDepartment(newRoomName, newRoomNumber));
                                    System.out.println("Created room:" + roomCollections.getListOfAllRooms().get(roomCollections.getListOfAllRooms().size() - 1).description());
                                }
                                case 2 -> {
                                    System.out.println("Write name of new room");
                                    String newRoomName = inputString.nextLine();
                                    System.out.println("Write number of new room");
                                    int newRoomNumber = inputNumber.nextInt();
                                    roomCollections.addCollections(new WaitingRoom(newRoomName, newRoomNumber));
                                    System.out.println("Created room:" + roomCollections.getListOfAllRooms().get(roomCollections.getListOfAllRooms().size() - 1).description());
                                }
                                case 3 -> {
                                    System.out.println("Write name of new room");
                                    String newRoomName = inputString.nextLine();
                                    System.out.println("Write number of new room");
                                    int newRoomNumber = inputNumber.nextInt();
                                    roomCollections.addCollections(new Cardiology(newRoomName, newRoomNumber));
                                    System.out.println("Created room:" + roomCollections.getListOfAllRooms().get(roomCollections.getListOfAllRooms().size() - 1).description());
                                }
                                case 4 -> {
                                    System.out.println("Write name of new room");
                                    String newRoomName = inputString.nextLine();
                                    System.out.println("Write number of new room");
                                    int newRoomNumber = inputNumber.nextInt();
                                    roomCollections.addCollections(new Gynecology(newRoomName, newRoomNumber));
                                    System.out.println("Created room:" + roomCollections.getListOfAllRooms().get(roomCollections.getListOfAllRooms().size() - 1).description());
                                }
                                case 5 -> {
                                    System.out.println("Write name of new room");
                                    String newRoomName = inputString.nextLine();
                                    System.out.println("Write number of new room");
                                    int newRoomNumber = inputNumber.nextInt();
                                    roomCollections.addCollections(new Laryngology(newRoomName, newRoomNumber));
                                    System.out.println("Created room:" + roomCollections.getListOfAllRooms().get(roomCollections.getListOfAllRooms().size() - 1).description());
                                }
                                case 6 -> {
                                    System.out.println("Write name of new room");
                                    String newRoomName = inputString.nextLine();
                                    System.out.println("Write number of new room");
                                    int newRoomNumber = inputNumber.nextInt();
                                    roomCollections.addCollections(new Neurosurgery(newRoomName, newRoomNumber));
                                    System.out.println("Created room:" + roomCollections.getListOfAllRooms().get(roomCollections.getListOfAllRooms().size() - 1).description());
                                }
                                default -> {
                                    System.out.println("Introduced wrong value.");
                                }
                            }
                        }
                        case 2 -> {
                            System.out.println("Write 1 if you want to create a nurse");
                            System.out.println("Write 2 if you want to create a secretary");
                            System.out.println("Write 3 if you want to create a surgeon");
                            int decisionEmployeeAdd = inputNumber.nextInt();
                            switch (decisionEmployeeAdd) {
                                case 1 -> {
                                    System.out.println("Write name of new nurse.");
                                    String nurseName = inputString.nextLine();
                                    System.out.println("Write surname of new nurse.");
                                    String nurseSurname = inputString.nextLine();
                                    System.out.println("Write age of new nurse.");
                                    int nurseAge = inputNumber.nextInt();
                                    System.out.println("Write 1 if gender of new nurse is male.");
                                    System.out.println("Write 2 if gender of new nurse is female.");
                                    int nurseGenderNumber = inputNumber.nextInt();
                                    Gender nurseGender = null;
                                    if (nurseGenderNumber == 1) nurseGender = Male;
                                    else if (nurseGenderNumber == 2) nurseGender = Female;
                                    System.out.println("Write day of Birth of new nurse.");
                                    int nurseDayOfBirth = inputNumber.nextInt();
                                    System.out.println("Choose month of Birth of new nurse, 1 - January, 2 - February...");
                                    int nurseMonthOfBirth = inputNumber.nextInt();
                                    System.out.println("Write year of Birth of new nurse.");
                                    int nurseYearOfBirth = inputNumber.nextInt();
                                    System.out.println("Write salary of new nurse.");
                                    double nurseSalary = inputDouble.nextDouble();
                                    System.out.println("Write day of employment of new nurse.");
                                    int nurseDayOfEmployment = inputString.nextInt();
                                    System.out.println("Write month of employment of new nurse, 1 - January, 2 - February...");
                                    int nurseMonthOfEmployment = inputNumber.nextInt();
                                    System.out.println("Write year of employment of new nurse.");
                                    int nurseYearOfEmployment = inputNumber.nextInt();
                                    System.out.println("Write number of workplace of new nurse.");
                                    int nurseWorkplace = inputNumber.nextInt();
                                    employeeCollections.addCollections(new Nurse(nurseName, nurseSurname, nurseAge, nurseGender, new Date(nurseDayOfBirth, (nurseMonthOfBirth - 1), nurseYearOfBirth), nurseSalary, new Date(nurseDayOfEmployment, (nurseMonthOfEmployment - 1), nurseYearOfEmployment), roomCollections.searchRoom(nurseWorkplace)));
                                    System.out.println("Created employee:" + employeeCollections.getListOfAllEmployees().get(employeeCollections.getListOfAllEmployees().size() - 1).description());
                                }
                                case 2 -> {
                                    System.out.println("Write name of new secretary.");
                                    String secretaryName = inputString.nextLine();
                                    System.out.println("Write surname of new secretary.");
                                    String secretarySurname = inputString.nextLine();
                                    System.out.println("Write age of new secretary.");
                                    int secretaryAge = inputNumber.nextInt();
                                    System.out.println("Write 1 if gender of new secretary is male.");
                                    System.out.println("Write 2 if gender of new secretary is female.");
                                    int secretaryGenderNumber = inputNumber.nextInt();
                                    Gender secretaryGender = null;
                                    if (secretaryGenderNumber == 1) secretaryGender = Male;
                                    else if (secretaryGenderNumber == 2) secretaryGender = Female;
                                    System.out.println("Write day of Birth of new secretary.");
                                    int secretaryDayOfBirth = inputNumber.nextInt();
                                    System.out.println("Choose month of Birth of new secretary, 1 - January, 2 - February...");
                                    int secretaryMonthOfBirth = inputNumber.nextInt();
                                    System.out.println("Write year of Birth of new secretary.");
                                    int secretaryYearOfBirth = inputNumber.nextInt();
                                    System.out.println("Write salary of new secretary.");
                                    double secretarySalary = inputDouble.nextDouble();
                                    System.out.println("Write day of employment of new secretary.");
                                    int secretaryDayOfEmployment = inputString.nextInt();
                                    System.out.println("Write month of employment of new secretary, 1 - January, 2 - February...");
                                    int secretaryMonthOfEmployment = inputNumber.nextInt();
                                    System.out.println("Write year of employment of new secretary.");
                                    int secretaryYearOfEmployment = inputNumber.nextInt();
                                    System.out.println("Write number of workplace of new secretary.");
                                    int secretaryWorkplace = inputNumber.nextInt();
                                    employeeCollections.addCollections(new Secretary(secretaryName, secretarySurname, secretaryAge, secretaryGender, new Date(secretaryDayOfBirth, (secretaryMonthOfBirth - 1), secretaryYearOfBirth), secretarySalary, new Date(secretaryDayOfEmployment, (secretaryMonthOfEmployment - 1), secretaryYearOfEmployment), roomCollections.searchRoom(secretaryWorkplace)));
                                    System.out.println("Created employee:" + employeeCollections.getListOfAllEmployees().get(employeeCollections.getListOfAllEmployees().size() - 1).description());
                                }
                                case 3 -> {
                                    System.out.println("Write name of new surgeon.");
                                    String surgeonName = inputString.nextLine();
                                    System.out.println("Write surname of new surgeon.");
                                    String surgeonSurname = inputString.nextLine();
                                    System.out.println("Write age of new surgeon.");
                                    int surgeonAge = inputNumber.nextInt();
                                    System.out.println("Write 1 if gender of new surgeon is male.");
                                    System.out.println("Write 2 if gender of new surgeon is female.");
                                    int surgeonGenderNumber = inputNumber.nextInt();
                                    Gender surgeonGender = null;
                                    if (surgeonGenderNumber == 1) surgeonGender = Male;
                                    else if (surgeonGenderNumber == 2) surgeonGender = Female;
                                    System.out.println("Write day of Birth of new surgeon.");
                                    int surgeonDayOfBirth = inputNumber.nextInt();
                                    System.out.println("Choose month of Birth of new surgeon, 1 - January, 2 - February...");
                                    int surgeonMonthOfBirth = inputNumber.nextInt();
                                    System.out.println("Write year of Birth of new surgeon.");
                                    int surgeonYearOfBirth = inputNumber.nextInt();
                                    System.out.println("Write salary of new surgeon.");
                                    double surgeonSalary = inputDouble.nextDouble();
                                    System.out.println("Write day of employment of new surgeon.");
                                    int surgeonDayOfEmployment = inputString.nextInt();
                                    System.out.println("Write month of employment of new surgeon, 1 - January, 2 - February...");
                                    int surgeonMonthOfEmployment = inputNumber.nextInt();
                                    System.out.println("Write year of employment of new surgeon.");
                                    int surgeonYearOfEmployment = inputNumber.nextInt();
                                    System.out.println("Write number of workplace of new surgeon.");
                                    int surgeonWorkplace = inputNumber.nextInt();
                                    System.out.println("Write speciality of new surgeon");
                                    String surgeonSpeciality = inputString.nextLine();
                                    employeeCollections.addCollections(new Surgeon(surgeonName, surgeonSurname, surgeonAge, surgeonGender, new Date(surgeonDayOfBirth, (surgeonMonthOfBirth - 1), surgeonYearOfBirth), surgeonSalary, surgeonSpeciality, new Date(surgeonDayOfEmployment, (surgeonMonthOfEmployment - 1), surgeonYearOfEmployment), roomCollections.searchRoom(surgeonWorkplace)));
                                    System.out.println("Created employee:" + employeeCollections.getListOfAllEmployees().get(employeeCollections.getListOfAllEmployees().size() - 1).description());
                                }
                                default -> {
                                    System.out.println("Introduced wrong value.");
                                }
                            }
                        }
                        case 3 -> {
                            System.out.println("Write name of new patient");
                            String patientName = inputString.nextLine();
                            System.out.println("Write surname of new patient");
                            String patientSurname = inputString.nextLine();
                            System.out.println("Write age of new patient");
                            int patientAge = inputNumber.nextInt();
                            System.out.println("Write 1 if gender of new patient is male.");
                            System.out.println("Write 2 if gender of new patient is female.");
                            int patientGenderNumber = inputNumber.nextInt();
                            Gender patientGender = null;
                            if (patientGenderNumber == 1) patientGender = Male;
                            else if (patientGenderNumber == 2) patientGender = Female;
                            System.out.println("Write day of birth of new patient.");
                            int patientDayOfBirth = inputNumber.nextInt();
                            System.out.println("Choose month of birth of new patient, 1 - January, 2 - February...");
                            int patientMonthOfBirth = inputNumber.nextInt();
                            System.out.println("Write year of birth of new patient.");
                            int patientYearOfBirth = inputNumber.nextInt();
                            System.out.println("Write day of arrive of new patient.");
                            int patientArrivalDay = inputNumber.nextInt();
                            System.out.println("Choose month of arrive of new patient, 1 - January, 2 - February...");
                            int patientArrivalMonth = inputNumber.nextInt();
                            System.out.println("Write year of arrive of new patient.");
                            int patientArrivalYear = inputNumber.nextInt();
                            System.out.println("Write a number of room the new patient is currently located.");
                            int patientNumberOfLocation = inputNumber.nextInt();
                            patientCollections.addCollections(new Patient(patientName, patientSurname, patientAge, patientGender, new Date(patientDayOfBirth, (patientMonthOfBirth - 1), patientYearOfBirth), new Date(patientArrivalDay, (patientArrivalMonth - 1), patientArrivalYear), roomCollections.searchRoom(patientNumberOfLocation)));
                        }
                        default -> {
                            System.out.println("Introduced wrong value.");
                        }
                    }
                }
                default -> {
                    System.out.println("Wrong choice, try again.");
                }
            }
            }
            while(decision!=0);
        }
        catch (InputMismatchException e){
            System.out.println("Introduced wrong value.");
        }
        catch(CouldNotFind e){
            System.out.println(e.getMessage());
        }
    }
}