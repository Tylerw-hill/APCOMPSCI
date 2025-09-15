package robot;

import kareltherobot.*;

public class Roomba implements Directions {

    public static void main(String[] args) {
        String worldName = "robot/finalTestWorld2024.wld";

        Roomba cleaner = new Roomba();
        int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
        System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
        System.out.println("Area of the room is " + (totalArea) + " units");
        System.out.println("The room is " + ((double)numberofPiles/totalArea)*100 + "% dirty");
        cleaner.biggestPile();

    }
    //variables
    private Robot roomba;
    private int totalBeepers = 0; 
    static int totalArea = 0;
    private static int numberofPiles = 0;

    private int maxPileCount = 0;
    private int maxPileStreet = -1;
    private int maxPileAvenue = -1;

    //world settings
    public int cleanRoom(String worldName, int startX, int startY) {
        World.readWorld(worldName);
        World.setVisible(true);
        World.setDelay(0);
        World.setSize(200, 600);
        

        roomba = new Robot(26, 149, South, 0);
        //calibrates to the bottom left corner
        while(roomba.frontIsClear()){
            roomba.move();
        }

        roomba.turnLeft();
        roomba.turnLeft();
        roomba.turnLeft();
        while(roomba.frontIsClear()){
            roomba.move();
        }
        roomba.turnLeft();
        roomba.turnLeft();

        //moves and picks up all beepers until reaches end
        boolean hasMoreRows = true;
        while (hasMoreRows) {
            twoRows();
            roomba.turnLeft();
            roomba.turnLeft();
            roomba.turnLeft();
            if (!roomba.frontIsClear()) {
                hasMoreRows = false;
            }
            roomba.turnLeft();
        }

        collectPile();

        return totalBeepers;    
    }
    //functions that automates tasks
    private void collectPile() {
    int pileCount = 0;
    while (roomba.nextToABeeper()) {
        roomba.pickBeeper();
        totalBeepers++;
        pileCount++;
    }
    if (pileCount > 0) {
        numberofPiles++; 
    }
    if (pileCount > maxPileCount) {
        maxPileCount = pileCount;
        maxPileStreet = roomba.street();
        maxPileAvenue = roomba.avenue();
    }
}

    private void moveAndPick() {
        while(roomba.frontIsClear()){
            roomba.move();
            totalArea++;
            collectPile();
        }
    }

    private void moveOne() {
        roomba.move();
        totalArea++;
        collectPile();
    }

    private void twoRows() {
        collectPile();
        moveAndPick();
        roomba.turnLeft();
        moveOne();
        roomba.turnLeft();
        moveAndPick();
        roomba.turnLeft();
        roomba.turnLeft();
        roomba.turnLeft();
        moveOne();
        roomba.turnLeft();
        roomba.turnLeft();
        roomba.turnLeft();
    }
    //determines biggest pile
    public void biggestPile() {
        if (maxPileCount == 0) {
            System.out.println("No beepers were found.");
        } 
        else{
            System.out.println("The biggest pile was at (" + maxPileStreet + ", " +
                               maxPileAvenue + ") with " + maxPileCount + " beepers.");
        }
    }
}