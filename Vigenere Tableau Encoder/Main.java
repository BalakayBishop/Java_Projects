package vigenere_tableau;

import java.util.*;

// main is going to be my business class
public class Main 
{
    // ascii values for caps is 65-90
    static char ch = 'A'; 
    static int ascii = (int) ch;
    static String message = "Hello World";
    static String key = "Hannah";
    static String alpha ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Scanner input = new Scanner(System.in);
    
    //multidimensional array to support the table
    static char[][] vigenereTable = new char[26][26];
    static ArrayList<Character> encryptedArray = new ArrayList<>();
    static String encryptedMessage;
    /*
    public static char getCharMess(String m)
    {
        int messIndex = 0;
        char nextMess = message.charAt(messIndex);
        int intMess = (int) nextMess;
        messIndex++;
        System.out.println(intMess);
        
        return nextMess;
    } // end of getCharMess
    
    public static char getCharKey(String k)
    {
        int keyIndex = 0;
        char nextKey = key.charAt(keyIndex);
        int intKey = (int) nextKey;
        keyIndex++;
        if (keyIndex > message.length())
        {
            keyIndex = 0;
        }
        System.out.println(intKey);
        
        return nextKey;
    } // end of getCharKey
    */
    
    public static void encrypt(String m, String k)
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
            
            //System.out.println(nextMess + " = " + getCharM + ", " + nextKey + " = " + getCharK);
            
            if (nextK == k.length())
            {
                nextK = 0;
            }
        }
    }
    
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
        } // end of loops
        
        for (char[] print : vigenereTable)
        {
            System.out.println(print);
        } // end of loop to print 
        /*
        System.out.print("Please enter your plaintext message: ");
        message = input.nextLine();
        
        System.out.print("Please enter your key: ");
        key = input.nextLine();
        */
        // making them all caps to match the table and removing spaces
        String newMessage = message.toUpperCase().replaceAll(" ", "");
        String newKey = key.toUpperCase().replaceAll(" ", "");
        
        System.out.println(newMessage + "\n" + newKey);
        
        encrypt(newMessage, newKey);
        
        encryptedMessage = encryptedArray.toString().replaceAll("[^a-zA-Z0-9\\s]", "").replaceAll(" ", "");
        
        System.out.println(encryptedMessage);
    }
    
}
