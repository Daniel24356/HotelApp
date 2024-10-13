package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(6);

        Thread[] users = new Thread[7];
        for (int i = 0; i < users.length; i++) {
            users[i] = new Customer(hotel, "User" + (i + 1));
            users[i].start();
        }

        for (Thread user : users) {
            try {
                user.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All booking attempts are completed.");

    }
}