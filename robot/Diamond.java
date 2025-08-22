package robot;
import kareltherobot.*;


public class Diamond implements Directions{

    public static void main(String[] args) {

        World.setVisible(true);// allows us to see the run output
        // the bigger the street, the farther north
        World.setSize(20,20);
        World.setDelay(3);


        // The line below creates a Robot that we will refer to as rob
        // Find out what the numbers and direction do!
        // Put rob in a better location for your initials.
        Robot rob = new Robot(10,19,North,80);

        // Want a second robot?  No prob.  They are cheap :)
        //Robot dude = new Robot(7,5,West,9);

        //top right side of the diamond
        rob.putBeeper();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
       
        //top left side of the diamond

        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();

        //bottom left side of Diamond
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        
        //Bottom Right side of diamond
         rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
         rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
         rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
         rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
         rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
         rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
         rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
         rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
       
        // done with the line, now on the curve
        // rob.turnLeft();

    }
}
