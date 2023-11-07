package Building;

import java.util.Date;

public class Hospital {
    private String name;
    private String city;
    private String address;
    private int dateOfAssumption;
    private String headOfHospital;
    private String phoneNumber;
    private int numberOfFloors;

    public Hospital(String name, String city, String address, int dateOfAssumption, String headOfHospital, String phoneNumber, int numberOfFloors) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.dateOfAssumption = dateOfAssumption;
        this.headOfHospital = headOfHospital;
        this.phoneNumber = phoneNumber;
        this.numberOfFloors = numberOfFloors;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public int getDateOfAssumption() {
    return dateOfAssumption;
    }

    public String getHeadOfHospital() {
        return headOfHospital;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public String description(){
        return "HOSPITAL" + '\n' +
                "Name: " + getName() + '\n' +
                "City: " + getCity() + '\n' +
                "Address: " + getAddress() + '\n' +
                "Date of Assumption: " + getDateOfAssumption() + '\n' +
                "Head of Hospital: " + getHeadOfHospital() + '\n' +
                "Phone number: " + getPhoneNumber() + '\n' +
                "Number of floors: " + getNumberOfFloors();
    }
}
