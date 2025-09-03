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


    private Robot roomba;
    private int totalBeepers = 0; 
    int i = 0;

    public int cleanRoom(String worldName, int startX, int startY) {

        World.readWorld(worldName);
        World.setVisible(true);
		World.setDelay(10);

        roomba = new Robot(startX, startY, East, 80);

        for (i = 0; i <= 2; i++) {
            moveAndPick();
            moveAndPick();
            moveAndPick();
            moveAndPick();
            moveAndPick();
            moveAndPick();
            moveAndPick();
            roomba.turnLeft();
            moveAndPick();
            roomba.turnLeft();
            moveAndPick();
            moveAndPick();
            moveAndPick();
            moveAndPick();
            moveAndPick();
            moveAndPick();
            moveAndPick();
            roomba.turnLeft();
            roomba.turnLeft();
            roomba.turnLeft();
            moveAndPick();
            roomba.turnLeft();
            roomba.turnLeft();
            roomba.turnLeft();
        }


        while (roomba.nextToABeeper()) {
            roomba.pickBeeper();
            totalBeepers++;
        }

        return totalBeepers;
    }
    private void moveAndPick() {
        roomba.move();
        while (roomba.nextToABeeper()) {
            roomba.pickBeeper();
            totalBeepers++;
        }
    }
}