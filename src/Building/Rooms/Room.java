package Building.Rooms;

public abstract class Room {
    private String name;
    private int numberOfRoom;

    public Room(String name, int numberOfRoom) {
        this.name = name;
        this.numberOfRoom = numberOfRoom;
    }

    public abstract String description();
}
