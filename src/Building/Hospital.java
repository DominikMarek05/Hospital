package Building;

import java.util.Date;

public class Hospital {
    private String name;
    private String city;
    private String address;
    private Date dateOfAssumption;
    private String headOfHospital;
    private String phoneNumber;
    private int numberOfFloors;

    public Hospital(String name, String city, String address, Date dateOfAssumption, String headOfHospital, String phoneNumber, int numberOfFloors) {
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

    public String getAddress() {
        return address;
    }

    public Date getDateOfAssumption() {
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
}
