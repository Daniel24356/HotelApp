package org.example;

public class Hotel {
    private Room[] rooms;

    public Hotel(int numberOfRooms) {
        rooms = new Room[numberOfRooms];
        for (int i = 0; i < numberOfRooms; i++) {
            rooms[i] = new Room(i + 1);
        }
    }

    public boolean attemptBooking(String userName) {
        for (Room room : rooms) {
            if (room.bookRoom(userName)) {
                return true;
            }
        }
        System.out.println(userName + " could not book any rooms.");
        return false;
    }
}
