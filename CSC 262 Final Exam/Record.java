
package Simulation;

import Drawing.Point;
import Drawing.Line;
import java.util.Random;

public class Record 
{
    private Point p1;
    private Point p2;
    private double dist; 
    
    public Point getP1()
    {
        return p1; 
    }
    public Point getP2()
    {
        return p2;
    }
    public double getDist()
    {
        return dist; 
    }
    
    Record (Point p1Pass, Point p2Pass)
    {
        this.p1 = p1Pass;
        this.p2 = p2Pass;
        dist = Line.length(p1, p2); 
    }
         
}
