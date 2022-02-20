package csc600_midterm;

import java.util.ArrayList;


public class Midterm_Java 
{
    public void loadArray (ArrayList<String> passedArray1)
    {
        String name;
        for (int i = 0; i < passedArray1.size(); i++)
        {
            name = passedArray1.get(i); 
            System.out.printf("Name from list: %s%n", name); 
        }
        
    } // end of load
    
    public void addName (ArrayList<String> passedArray2, String newName)
    {
        passedArray2.add(newName);
        System.out.printf("Name added to list: %s%n", newName);
        
     } // end of add name 
    
    public void removeName (ArrayList<String> passedArray3, String removeName)
    {
        System.out.printf("Name removed from list: %s%n", removeName);
        passedArray3.remove(removeName);
        
    } // end of remove
    
    public void selectedName(ArrayList<String> passedArray4)
    {
        String name;
        for (int i = 0; i < passedArray4.size(); i++)
        {
            name = passedArray4.get(i); 
            System.out.printf("Name(s) selected from list: %s%n", name); 
        }
    }
    
    public static void main(String[] args)
    {
        
    }
    
    
    
} //end of class
