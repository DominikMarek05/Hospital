package Building.Rooms;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return numberOfRoom == room.numberOfRoom && Objects.equals(name, room.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfRoom);
    }
}
