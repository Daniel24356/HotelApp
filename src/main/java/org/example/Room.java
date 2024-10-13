package org.example;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Room  {
    private int roomNumber;
    private boolean isBooked;
    private Lock lock;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
        this.lock = new ReentrantLock();
    }

    public boolean bookRoom(String userName) {
        if (lock.tryLock()) {
            try {
                if (!isBooked) {
                    isBooked = true;
                    System.out.println("Room " + roomNumber + " successfully booked by " + userName);
                    return true;
                } else {
                    System.out.println("Room " + roomNumber + " is already booked.");
                }
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(userName + " is trying to book Room " + roomNumber + ", but it's being processed by another user.");
        }
        return false;
    }
}
