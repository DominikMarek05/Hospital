package Building.Rooms.Others;

import Building.Rooms.Room;

public class EmergencyDepartment extends Room {
    public EmergencyDepartment(String name, int numberOfRoom) {
        super(name, numberOfRoom);
    }

    @Override
    public String description() {
        return "EMERGENCY DEPARTMENT: A place of providing health care services to people in a state of sudden health threat";
    }
}
