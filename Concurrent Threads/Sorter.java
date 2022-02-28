
package csc600_finalp1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Sorter implements Runnable
{
    ArrayList<Integer> s_list = null;
    Simulation obj;
    int seq;
    
    public Sorter (ArrayList<Integer> s_list, int seq)
    {
        this.s_list = s_list;
        this.seq = seq;
    }
    
    @Override
    public void run() 
    {
        try {
            for ( int j = 0; j < 10; j++)
            {
                Thread.sleep(5);
            synchronized (s_list)
            {
                while (s_list.size() != 10 && seq != 2)
                {
                    try 
                    {
                        s_list.wait();
                    } 
                    catch (InterruptedException ex) {}
                }
                 
            }
        
            synchronized (s_list)
            {
                Collections.sort(s_list);
                Simulation.printArr(s_list);
                Simulation.sim_seq++;
                Drainer.drainer = true;
                s_list.notifyAll();
            }
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Sorter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
        
}
