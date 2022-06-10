package vigenere_tableau;

import java.util.*;

public class VigenereTableau 
{
    // ascii values for caps is 65-90
    //figure out the arrays
    //multidimensional array to support the table
    static char[][] vigenereTable = new char[26][26];
    
    static char ch = 'A'; 
    static int ascii = (int) ch;
    
    public static void main(String args[])
    {
        // [row][column]
        // nested for loop to fill the array
        for (int i = 0; i < 26; i++)
        {
            int start = ascii + i; 
            for (int j = 0; j < 26; j++)
            {
                vigenereTable[i][j] = (char) start;
                start++;
                if (start == 91)
                {
                    start = ascii;
                }
            }
            
        } //
        
        for (char[] print : vigenereTable)
        {
            System.out.println(print);
        }
    }
    
}
