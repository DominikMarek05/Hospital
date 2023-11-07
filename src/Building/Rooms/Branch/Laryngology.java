package Building.Rooms.Branch;

import Building.Rooms.Room;

public class Laryngology extends Room {
    public Laryngology(String name, int numberOfRoom) {
        super(name, numberOfRoom);
    }

    @Override
    public String description() {
        return "LARYNGOLOGY: A place dealing with diseases of the ear, throat and larynx.";
    }
}
