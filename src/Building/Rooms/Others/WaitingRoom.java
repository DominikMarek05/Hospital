package Building.Rooms.Others;

import Building.Rooms.Room;

public class WaitingRoom extends Room {
    public WaitingRoom(String name, int numberOfRoom) {
        super(name, numberOfRoom);
    }
    @Override
    public String description() {
        return "WAITING ROOM: This is the queue to the reception.";
    }
}
