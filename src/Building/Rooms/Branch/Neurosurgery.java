package Building.Rooms.Branch;

import Building.Rooms.Room;

public class Neurosurgery extends Room {
    public Neurosurgery(String name, int numberOfRoom) {
        super(name, numberOfRoom);
    }

    @Override
    public String description() {
        return "NEUROSURGERY: A place dealing with the diagnosis and surgical treatment of diseases of the nervous system";
    }
}
