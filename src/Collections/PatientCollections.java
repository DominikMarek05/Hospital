package Collections;

import Exceptions.CouldNotFind;
import Person.Employees.Employee;
import Person.Patients.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientCollections {
    private ArrayList<Patient> listOfAllPatients;

    public PatientCollections(ArrayList<Patient> listOfAllPatients) {
        this.listOfAllPatients = listOfAllPatients;
    }
    public void addCollections(Patient ...patient){listOfAllPatients.addAll(List.of(patient));}

    public ArrayList<Patient> getListOfAllPatients() {
        return listOfAllPatients;
    }
    public ArrayList<Patient> searchPatientByName(String searchedName){
        ArrayList<Patient> patientList = new ArrayList<>();
        for (Patient patient: listOfAllPatients) {
            if(patient.getName().equals(searchedName)) patientList.add(patient);
        }
        return patientList;
    }
    public ArrayList<Patient> searchPatientBySurname(String searchedSurname){
        ArrayList<Patient> patientList = new ArrayList<>();
        for (Patient patient: listOfAllPatients) {
            if(patient.getSurname().equals(searchedSurname)) patientList.add(patient);
        }
        return patientList;
    }
    public Patient searchPatientByNameAndSurname(String name, String surname) throws CouldNotFind {
        for (Patient emp: listOfAllPatients) {
            if(emp.getName().equals(name) && emp.getSurname().equals(surname)) return emp;
        }
        throw new CouldNotFind("This employee does not exist");
    }
    public boolean removePatient(String patientName, String patientSurname) throws CouldNotFind{
        return listOfAllPatients.remove(searchPatientByNameAndSurname(patientName, patientSurname));
    }
}
