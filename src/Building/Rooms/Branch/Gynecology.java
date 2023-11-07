package Building.Rooms.Branch;

import Building.Rooms.Room;

public class Gynecology extends Room {
    public Gynecology(String name, int numberOfRoom) {
        super(name, numberOfRoom);
    }

    @Override
    public String description() {
        return "GYNECOLOGY: A place dealing with the prevention and treatment of diseases of the female reproductive system";
    }
}
