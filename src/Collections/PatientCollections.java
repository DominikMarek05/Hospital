package Collections;

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
}
