package Building.Rooms;

public abstract class Room {
    private String name;
    private int numberOfRoom;

    public Room(String name, int numberOfRoom) {
        this.name = name;
        this.numberOfRoom = numberOfRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public abstract String description();
}
