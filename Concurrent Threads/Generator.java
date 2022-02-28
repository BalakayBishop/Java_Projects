
package csc600_finalp1;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 *
 * @author balak
 */
public class Generator implements Runnable
{
    ArrayList<Integer> g_list = null;
    SecureRandom random = new SecureRandom();
    Simulation obj;
    private int seq;
    
    
    public Generator (ArrayList<Integer> g_list, int seq)
    {
        this.g_list = g_list;
        this.seq = seq;
    }
    

    @Override
    public void run() 
    {
        try {
        for ( int j = 0; j < 10; j++)
        {
            
            Thread.sleep(5);
            
            synchronized(g_list)
            {
                while (seq != 1) 
                {
                    try
                    {
                        g_list.wait();
                    }
                    catch (InterruptedException ex) { System.out.println("Generator run() interrupted"); }
                    
                }
                
                for (int i = 0; i < 10; i++)
                {
                    g_list.add(i, random.nextInt(10) + 1);
                }
                
                Simulation.printArr(g_list);
                Simulation.sim_seq++;
                g_list.notifyAll();
            }
            }
        }
         catch (InterruptedException ex) {} 
        
        
        
    }
    
}
