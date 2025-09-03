package robot;

import kareltherobot.*;

public class Roomba implements Directions {

    // Main method to make this self-contained
    public static void main(String[] args) {
        // LEAVE THIS ALONE!!!!!!
        String worldName = "robot/basicRoom.wld";

        Roomba cleaner = new Roomba();
        int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
        System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
    }

    // declared here so it is visible in all the methods!
    private Robot roomba;
    private int totalBeepers = 0; 
    int i = 0;

    public int cleanRoom(String worldName, int startX, int startY) {
        // Load world first
        World.readWorld(worldName);
        World.setVisible(true);

        // assign to instance variable
        roomba = new Robot(startX, startY, East, 80);

        // === your movement loop (fixed condition) ===
        for (i = 0; i <= 2; i++) {   // was i >= 2 (never ran)
            roomba.move();
            roomba.move();
            roomba.move();
            roomba.move();
            roomba.move();
            roomba.move();
            roomba.move();
            roomba.turnLeft();
            roomba.move();
            roomba.turnLeft();
            roomba.move();
            roomba.move();
            roomba.move();
            roomba.move();
            roomba.move();
            roomba.move();
            roomba.move();
            roomba.turnLeft();
            roomba.turnLeft();
            roomba.turnLeft();
            roomba.move();
            roomba.turnLeft();
            roomba.turnLeft();
            roomba.turnLeft();
        }

        // === fixed beeper picking loop ===
        while (roomba.nextToABeeper()) {
            roomba.pickBeeper();
            totalBeepers++;
        }

        return totalBeepers;
    }
}