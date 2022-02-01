
package Drawing;

import java.util.Random;

public class FinalExamExe 
{

    public static String toString(Point obj)
    {
        return  "(" + obj.getX() + " , " + obj.getY() + ")" ; 
    }
   
    public static void main(String[] args) throws Throwable 
    {
        /*
        System.out.println("The number of points is: " + getNumPts());
        
        Point p1 = new Point (7.86, 8.786); 
        
        System.out.println("The number of points is: " + getNumPts());
        
        p1.finalize();
        
        System.out.println("The number of points is: " + getNumPts());
        
        Point[] ptStorage = new Point[7]; // creating the obj array
        Random randX = new Random();
        Random randY = new Random();
        
        
        
        for ( int i = 0; i < ptStorage.length; i++)
        {
              ptStorage[i] = new Point(randX.nextInt(100 + 100) - 100, randY.nextInt(50 + 50) - 50); // random values, 1 + to exclude 0 
        }
        
        for ( int j = 0; j < ptStorage.length; j++)
        {
            System.out.println( toString(ptStorage[j]) );
        }
        
        System.out.println("The number of points is: " + getNumPts()); */
        
        Point[] ptStorage = new Point[4]; // creating the obj array
        Random randX = new Random();
        Random randY = new Random();
        
        
        
        for ( int i = 0; i < ptStorage.length; i++)
        {
              ptStorage[i] = new Point(randX.nextInt(100 + 100) - 100, randY.nextInt(50 + 50) - 50); // random values, 1 + to exclude 0 
        }
        
        Line line1 = new Line(ptStorage[0], ptStorage[1]);
        Line line2 = new Line(ptStorage[2], ptStorage[3]);
        
        System.out.printf("The length of line 1 is: %.2f %n"
                        + "The length of line 2 is: %.2f %n", 
                        line1.length(ptStorage[0], ptStorage[1]), 
                        line2.length(ptStorage[2], ptStorage[3]) );
        
        System.out.println( "The end points of line 2 are (" + line2.getA().getX() + " , " + line2.getA().getY() + ")"
                            + " and (" + line2.getB().getX() + " , " + line2.getB().getY() + ")" ); 
    } 
  
}
