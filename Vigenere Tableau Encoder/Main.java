package vigenere_tableau;

import java.util.*;

// main is going to be my business class
public class Main 
{
    // ascii values for caps is 65-90
    static char ch = 'A'; 
    static int ascii = (int) ch;
    static String message = "I WILL SUCCEED IN COMPUTER SECURITY";
    static String key = "Four score and seven years ago our forefathers brought forth on this continent a new nation";
    static String alpha ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Scanner input = new Scanner(System.in);
    
    //multidimensional array to support the table
    static char[][] vigenereTable = new char[26][26];
    static ArrayList<Character> encryptedArray = new ArrayList<>();
    
    
    static void init()
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
        } // end of loops
        
        for (char[] print : vigenereTable)
        {
            System.out.println(print);
        } // end of loop to print
    }
    
    static void encrypt(String m, String k)
    {
        //indexing the strings
            int nextM = 0; 
            int nextK = 0;
            
        // iterating through to get the characters
        for (int i = 0; i < m.length(); i++)
        {
            
            //System.out.println(nextK);
            char nextMess = m.charAt(nextM);
            char nextKey = k.charAt(nextK);
            int getCharM = alpha.indexOf(nextMess);
            int getCharK = alpha.indexOf(nextKey);
            
            encryptedArray.add(vigenereTable[getCharM][getCharK]);
            
            nextM++;
            nextK++;
            
            if (nextK == k.length())
            {
                nextK = 0;
            }
        }
        
    }
    
    static void clearArr()
    {
        encryptedArray.clear();
    }
    
    
    
}
