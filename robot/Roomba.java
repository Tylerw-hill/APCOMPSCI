package robot;

import kareltherobot.*;

public class Roomba implements Directions {

    // Main method to make this self-contained
    public static void main(String[] args) {
        // LEAVE THIS ALONE!!!!!!
        String worldName = "robot/TestWorld-2.wld";

        Roomba cleaner = new Roomba();
        int totalBeepers = cleaner.cleanRoom(worldName, 15, 15);
        System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
    }


    private Robot roomba;
    private int totalBeepers = 0; 
    int i = 0;

    public int cleanRoom(String worldName, int startX, int startY) {

        //world settings
        World.readWorld(worldName);
        World.setVisible(true);
		World.setDelay(1);
        World.setSize(50,50);

        roomba = new Robot(startX, startY, South, 0);
        while(roomba.frontIsClear()){
            roomba.move();
        }
        
        //calibration into the bottom left corner
        roomba.turnLeft();
        roomba.turnLeft();
        roomba.turnLeft();
        while(roomba.frontIsClear()){
            roomba.move();
        }
        roomba.turnLeft();
        roomba.turnLeft();
        
        //this is the part that holds all the movements stuff dont mess w this part that much 
        for (int i = 0; i < 23; i++) {
            twoRows();
        }
        while (roomba.nextToABeeper()) {
            roomba.pickBeeper();
            totalBeepers++;
        }
        
        return totalBeepers;
    
    }
    private void moveAndPick() {
        
        while(roomba.frontIsClear()){
        roomba.move();
        while (roomba.nextToABeeper()) {
            roomba.pickBeeper();
            totalBeepers++;
            }  
        }
    }
    private void moveOne() {
         roomba.move();
            if(roomba.nextToABeeper()){
                while(roomba.nextToABeeper()){
                    roomba.pickBeeper();
                    totalBeepers++;
                }
            }
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
}