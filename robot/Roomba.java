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

        World.readWorld(worldName);
        World.setVisible(true);
		World.setDelay(10);

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
}