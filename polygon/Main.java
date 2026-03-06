package polygon;
import java.awt.geom.*;
public class Main {
    public static void main(String [] args)
    {
        IrregularPolygon myPolygon = new IrregularPolygon();
        double[][] parallelogramPoints = {{20,10}, {70,20}, {50, 50}, {0,40}};
        for(double[] p: parallelogramPoints)
        {
            Point2D.Double point = new Point2D.Double(p[0], p[1]);
            myPolygon.add(point);
        }
        myPolygon.draw();

        TestSuite.run();
    }
    
}
