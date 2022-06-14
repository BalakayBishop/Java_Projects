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
    static String alpha ="ACBDEFGHIJKLMOPQRSTUVWXYZ";
    static Scanner input = new Scanner(System.in);
    
    //multidimensional array to support the table
    static char[][] vigenereTable = new char[26][26];
    static ArrayList<Character> encryptedArray = new ArrayList<>();
    
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
        
        for(int l = 0; l < newMessage.length(); l++)
        {
            char m = getCharMess(message);
            char k = getCharMess(key);
            int asciiM = alpha.indexOf(m);
            int asciiK = alpha.indexOf(k);
            encryptedArray.add(vigenereTable[asciiM][asciiK]);
        }
        String encryptedMessage = encryptedArray.toString();
        System.out.println(encryptedMessage);
    }
    
}
