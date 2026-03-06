package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool
import java.lang.Math;

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        myPolygon.add(aPoint);
        
    }

    public double perimeter() {
        double perimeter = 0.0;

        if(myPolygon.size() < 2)
            return 0.0;

        for(int i = 0; i < myPolygon.size(); i++){

            Point2D.Double current = myPolygon.get(i);
            Point2D.Double next;

            if (i == myPolygon.size() -1)
                next = myPolygon.get(0);
            else
                next = myPolygon.get(i+1);
        

        double dx = next.x - current.x;
        double dy = next.y - current.y;

        perimeter += Math.sqrt(dx * dx + dy * dy);
}
    
        return perimeter;
    }
//

    public double area() {
   
        Double area = 0.0;
        if (myPolygon.size() < 3)
            return 0.0;
        for(int i = 0; i < myPolygon.size(); i++){
            Point2D.Double current = myPolygon.get(i);
            Point2D.Double next;
        if (i == myPolygon.size() - 1)
            next = myPolygon.get(0);
        else 
            next = myPolygon.get(i + 1);
        area += (current.getX() * next.getY()) - (current.getY() * next.getX());
        }
        area = Math.abs(area/2.0);

        return area;
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            if(myPolygon.size() < 2){
                System.out.println("can't draw, must have more than 1 point");
                return;
            }
        DrawingTool myDrawingTool = new DrawingTool(new SketchPad(600,600));
        
        myDrawingTool.up();
        myDrawingTool.move(myPolygon.get(0).getX(), myPolygon.get(0).getY());
        myDrawingTool.down();
        for(int i = 1; i < myPolygon.size(); i++){
            myDrawingTool.move(myPolygon.get(i).getX(), myPolygon.get(i).getY());
        }
        myDrawingTool.move(myPolygon.get(0).getX(), myPolygon.get(0).getY());
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
