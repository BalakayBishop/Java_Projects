
package csc600_finalp1;

import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Simulation 
{
    private ArrayList<Integer> sim_list = new ArrayList<>();
    ExecutorService exe = Executors.newFixedThreadPool(3);
    static int sim_seq = 1;
    
    public synchronized static void printArr(ArrayList<Integer> sim_list)
    {
        System.out.print("Array: ");
        
        sim_list.forEach( (Integer i) -> {
            
            System.out.print(i + " ");
        });
            
        System.out.println();
    }
    
    public void runSim()
    {
        exe.execute( new Generator(sim_list, sim_seq) );
        exe.execute( new Sorter(sim_list, sim_seq) );
        exe.execute( new Drainer(sim_list, sim_seq) );
            
        exe.shutdown();
         
    }
}
