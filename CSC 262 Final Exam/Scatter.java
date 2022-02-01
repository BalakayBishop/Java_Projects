
package Simulation;

import Drawing.Point; 
import java.util.Random;
import Drawing.Line;
import java.util.Arrays;

public class Scatter 
{
    
    
    public static void main(String[] args)
    {
        Point[] points = new Point[10]; // creating the obj array
        Random randX = new Random();
        Random randY = new Random();
        
        for ( int i = 0; i < points.length; i++)
        {
              points[i] = new Point(randX.nextInt(100), randY.nextInt(100));
        }
        
        Record[] recordStore = new Record[5];
        
        recordStore[0] = new Record(points[0], points[1]); 
        recordStore[1] = new Record(points[2], points[3]);
        recordStore[2] = new Record(points[4], points[5]);
        recordStore[3] = new Record(points[6], points[7]);
        recordStore[4] = new Record(points[8], points[9]);
        
        double min = recordStore[0].getDist();
        double max = recordStore[0].getDist();
        
        for (int j = 0; j < recordStore.length; j++)
        {
            if (recordStore[j].getDist() <= min)
            {
                min = recordStore[j].getDist(); 
            }
        }
        for (int j = 0; j < recordStore.length; j++)
        {
            if (recordStore[j].getDist() >= max)
            {
                max = recordStore[j].getDist(); 
            }
        }
        System.out.println("min is " + min);
        System.out.println("max is " + max);
        
        double[] distArray = new double[recordStore.length];
        
        for (int j = 0; j < recordStore.length; j++)
        {
             distArray[j] = recordStore[j].getDist();
        }
        
        Arrays.sort(distArray);
        
        for (int j = 0; j < recordStore.length; j++)
        {
             System.out.println(distArray[j]); 
        }
    }

}
