package Building.Rooms.Others;

import Building.Rooms.Room;

public class WaitingRoom extends Room {
    private static int peopleInQueue = 0;
    public WaitingRoom(String name, int numberOfRoom) {
        super(name, numberOfRoom);
        this.peopleInQueue = peopleInQueue;
    }

    public static int getPeopleInQueue() {
        return peopleInQueue;
    }

    public static void setPeopleInQueue(int peopleInQueue) {
        WaitingRoom.peopleInQueue = peopleInQueue;
    }

    public static void decreasePeopleInQueue(){
        setPeopleInQueue(peopleInQueue--);
    }

    @Override
    public String description() {
        return "WAITING ROOM: This is the queue to the reception.";
    }

    public void estimatedQueueTime(){
        System.out.println("Your estimated time in this queue is: " + getPeopleInQueue()*15 + " minutes.");
    }
}
