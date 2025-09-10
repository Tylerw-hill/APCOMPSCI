
package robot;

import kareltherobot.*;

public class Roomba implements Directions {

    public static void main(String[] args) {
        String worldName = "robot/TestWorld-2.wld";

        Roomba cleaner = new Roomba();
        int totalBeepers = cleaner.cleanRoom(worldName, 15, 15);
        System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
        cleaner.biggestPile();
    }

    private Robot roomba;
    private int totalBeepers = 0; 
    int i = 0;

    private int maxPileCount = 0;
    private int maxPileStreet = -1;
    private int maxPileAvenue = -1;

    public int cleanRoom(String worldName, int startX, int startY) {
        World.readWorld(worldName);
        World.setVisible(true);
        World.setDelay(1);
        World.setSize(50,50);

        roomba = new Robot(startX, startY, South, 0);
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

        boolean hasMoreRows = true;
        while (hasMoreRows) {
            twoRows();
            // Check if there are more rows to cover
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

    private void collectPile() {
        int pileCount = 0;
        while (roomba.nextToABeeper()) {
            roomba.pickBeeper();
            totalBeepers++;
            pileCount++;
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
            collectPile();
        }
    }

    private void moveOne() {
        roomba.move();
        collectPile();
    }

    private void twoRows() {
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