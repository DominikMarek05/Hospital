package Collections;

import Building.Rooms.Room;
import Exceptions.CouldNotFind;
import Person.Employees.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCollections {
    private ArrayList<Employee> listOfAllEmployees;
    private final double inaccuracy = .0001;

    public EmployeeCollections(ArrayList<Employee> listOfAllEmployees) {
        this.listOfAllEmployees = listOfAllEmployees;
    }
    public void addCollections(Employee ...employee){
        listOfAllEmployees.addAll(List.of(employee));
    }

    public ArrayList<Employee> getListOfAllEmployees() {
        return listOfAllEmployees;
    }
    public ArrayList<Employee> searchEmployeeByName(String searchedName){
        ArrayList<Employee> employeeList = new ArrayList<>();
        for (Employee employee: listOfAllEmployees) {
            if(employee.getName().equals(searchedName)) employeeList.add(employee);
        }
        return employeeList;
    }
    public ArrayList<Employee> searchEmployeeBySurname(String searchedSurname){
        ArrayList<Employee> employeeList = new ArrayList<>();
        for (Employee employee: listOfAllEmployees) {
            if(employee.getSurname().equals(searchedSurname)) employeeList.add(employee);
        }
        return employeeList;
    }

    public Employee searchEmployeeByNameAndSurname(String name, String surname) throws CouldNotFind{
        for (Employee emp: listOfAllEmployees) {
            if(emp.getName().equals(name) && emp.getSurname().equals(surname)) return emp;
        }
        throw new CouldNotFind("This employee does not exist");
    }
    public ArrayList<Employee> searchEmployeeBySalary(double searchedSalary){
        ArrayList<Employee> employeeList = new ArrayList<>();
        for (Employee employee: listOfAllEmployees) {
            if(Math.abs(employee.getSalary() - searchedSalary) < inaccuracy) employeeList.add(employee);
        }
        return employeeList;
    }
    public ArrayList<Employee> searchEmployeeByWorkplaceName(String searchedWorkplaceName){
        ArrayList<Employee> employeeList = new ArrayList<>();
        for (Employee employee: listOfAllEmployees) {
            if(employee.getWorkplace().getName().equals(searchedWorkplaceName)) employeeList.add(employee);
        }
        return employeeList;
    }
    public boolean removeEmployee(String employeeName, String employeeSurname) throws CouldNotFind{
        return listOfAllEmployees.remove(searchEmployeeByNameAndSurname(employeeName, employeeSurname));
    }

}
