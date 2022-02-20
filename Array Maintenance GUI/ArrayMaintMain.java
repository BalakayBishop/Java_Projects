package csc600_arraymaint;

import static csc600_arraymaint.FXMLDocumentController.intArr;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Comparator.naturalOrder;
import java.util.Random;

/**
 *
 * @author balak
 */
public class ArrayMaintMain 
{
    
    public void display (ArrayList<Integer> passedArray1)
    {
        int x;
        for (int i = 0; i < passedArray1.size(); i++)
        {
            x = passedArray1.get(i);
            System.out.printf("Int from list: %d%n", x); 
        }
        
    } // end of load
    
    public void addTo(ArrayList<Integer> arrPass2, int toAdd)
    {
        arrPass2.add(toAdd); 
        System.out.printf("Int added to list: %d%n", toAdd);
        
    }
    
    public void removeFrom(ArrayList<Integer> arrPass3, int remove)
    {
         
        arrPass3.remove(remove); 
        System.out.printf("Int removed from list: %d%n", remove);
         
    }
    
    public void sortArray (ArrayList<Integer> arrPass4) 
    {
        int x;
        Collections.sort(arrPass4, naturalOrder());
        for (int i = 0; i < arrPass4.size(); i++)
        {
            x = arrPass4.get(i);
            System.out.printf("Sorted array: %d%n", x); 
        }
        
    }
    
    public int searchArray(ArrayList<Integer> arrPass5, int searchFor)
    {
        int freq = 0;
        
        // calling the static method 
        freq = Collections.frequency(arrPass5, searchFor); 
        
        return freq;
    }
    
    
}
