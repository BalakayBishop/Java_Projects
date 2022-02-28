
package csc600_finalp1;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Drainer implements Runnable
{
    ArrayList<Integer> d_list = null;
    Simulation obj;
    int seq;
    static boolean drainer = false;
    
    public Drainer (ArrayList<Integer> s_list, int seq)
    {
        this.d_list = s_list;
        this.seq = seq;
    }
    
    @Override
    public void run() 
    {
        try {
            for ( int i = 0; i < 10; i++)
            {
                Thread.sleep(5);
            synchronized (d_list)
            {
                while (drainer == false) 
                {
                    try
                    {
                        d_list.wait();
                    } catch (InterruptedException ex) {}
                }
                
            }
            
            synchronized (d_list)
            {
                d_list.clear();
                Simulation.printArr(d_list);
                d_list.notifyAll();
                
                drainer = false;
            }
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Drainer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
