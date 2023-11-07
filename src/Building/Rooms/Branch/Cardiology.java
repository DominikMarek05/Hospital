package Building.Rooms.Branch;

import Building.Rooms.Room;

public class Cardiology extends Room {
    public Cardiology(String name, int numberOfRoom) {
        super(name, numberOfRoom);
    }

    @Override
    public String description() {
        return "CARDIOLOGY: A place dealing with diseases and defects of the cardiovascular system, their diagnosis and treatment.";
    }
}
