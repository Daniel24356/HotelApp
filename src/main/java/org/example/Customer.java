package org.example;

public class Customer extends Thread {
    private Hotel hotel;
    private String userName;

    public Customer(Hotel hotel, String userName) {
        this.hotel = hotel;
        this.userName = userName;
    }

    @Override
    public void run() {
        System.out.println(userName + " is attempting to book a room.");
        hotel.attemptBooking(userName);
    }
}
