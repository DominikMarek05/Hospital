package Collections;

import Building.Rooms.Branch.*;
import Building.Rooms.Others.*;
import Building.Rooms.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomCollections {
    private ArrayList<Room> listOfAllRooms;

    public RoomCollections(ArrayList<Room> listOfAllRooms) {
        this.listOfAllRooms = listOfAllRooms;
    }

    public void addCollections(Room ...room){
        listOfAllRooms.addAll(List.of(room));
    }

    public ArrayList<Room> getListOfAllRooms() {
        return listOfAllRooms;
    }
}
