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
        // TODO: Calculate the area.
        Double area = 0.0;
        return area;
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            //DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            //myDrawingTool.move(50, 50);
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
