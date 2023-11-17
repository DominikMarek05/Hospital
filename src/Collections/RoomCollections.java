package Collections;

import Building.Rooms.Branch.*;
import Building.Rooms.Others.*;
import Building.Rooms.Room;
import Exceptions.CouldNotFind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RoomCollections {
    private ArrayList<Room> listOfAllRooms;

    public RoomCollections(ArrayList<Room> listOfAllRooms) {
        this.listOfAllRooms = listOfAllRooms;
    }
    public void addCollections(Room ...room){
        listOfAllRooms.addAll(List.of(room));
    }
    public void removeCollection(Room room) { listOfAllRooms.remove(room);}

    public ArrayList<Room> getListOfAllRooms() {
        return listOfAllRooms;
    }
    public Room searchRoom(int numberOfRoom) throws CouldNotFind {
        for (Room room: listOfAllRooms) {
            if(room.getNumberOfRoom() == numberOfRoom) return room;
        }
        throw new CouldNotFind("Room with this number does not exist.");
    }
}
