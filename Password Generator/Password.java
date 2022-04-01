package password.generator;

import java.security.SecureRandom;
import java.util.ArrayList;


public class Password 
{
    SecureRandom rand = new SecureRandom();
    
    //private ArrayList<Character> arrList = new ArrayList<>();
    
    private final String UpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String LowerCase = "abcdefghijlmknopqrstuvwxyz";
    private final String Numbers = "0123456789";
    private final String Specials = "!@#$%&*?";
    
    private final String UpperLower = UpperCase + LowerCase;
    private final String UpperNum = UpperCase + Numbers;
    private final String UpperSpec = UpperCase + Specials;
    private final String LowerNum = LowerCase + Numbers;
    private final String LowerSpec = LowerCase + Specials; 
    private final String NumSpec = Numbers + Specials;
    private final String UpperLowerNum = UpperCase + LowerCase + Numbers;
    private final String UpperLowerSpec = UpperCase + LowerCase + Specials;
    private final String UpperNumSpec = UpperCase + Numbers + Specials;
    private final String LowerNumSpec = LowerCase + Numbers + Specials;
    private final String All = UpperCase + LowerCase + Numbers + Specials;
    
    private boolean m_upperCase;
    private boolean m_lowerCase;
    private boolean m_numbers;
    private boolean m_specials;
    
    public Password (boolean upper, boolean lower, boolean num, boolean spec)
    {
        m_upperCase = upper;
        m_lowerCase = lower;
        m_numbers = num;
        m_specials = spec;
    }
    
    public void generator(int size, ArrayList arrList)
    {
         
        if (m_upperCase == false && m_lowerCase == false && m_numbers == false && m_specials == false)
        {
            
        }
        else if (m_upperCase == true && m_lowerCase == true && m_numbers == true && m_specials == true)
         {
             
             for (int i = 0; i < size; i++)
             {
                arrList.add(All.charAt(rand.nextInt( All.length() )));
             }
         }
        else if (m_upperCase == true && m_lowerCase == false && m_numbers == false && m_specials == false)
         {
             for (int i = 0; i < size; i++)
             {
                arrList.add(UpperCase.charAt(rand.nextInt( UpperCase.length() ))); // A-Z
             }
         }
         else if (m_upperCase == false && m_lowerCase == true && m_numbers == false && m_specials == false)
         {
             for (int i = 0; i < size; i++)
             {
                arrList.add(LowerCase.charAt(rand.nextInt( LowerCase.length() )));
             }
         }
        else if (m_upperCase == false && m_lowerCase == false && m_numbers == true && m_specials == false)
         {
             for (int i = 0; i < size; i++)
             {
                arrList.add(Numbers.charAt(rand.nextInt( Numbers.length() )));
             }
         }
        else if (m_upperCase == false && m_lowerCase == false && m_numbers == false && m_specials == true)
         {
             for (int i = 0; i < size; i++)
             {
                arrList.add(Specials.charAt(rand.nextInt( Specials.length() )));
             }
         }
        else if (m_upperCase == true && m_lowerCase == true && m_numbers == false && m_specials == false)
         {
             
             for (int i = 0; i < size; i++)
             {
                arrList.add(UpperLower.charAt(rand.nextInt( UpperLower.length() )));
             }
         }
        else if (m_upperCase == true && m_lowerCase == false && m_numbers == true && m_specials == false)
         {
             
             for (int i = 0; i < size; i++)
             {
                arrList.add(UpperNum.charAt(rand.nextInt( UpperNum.length() )));
             }
         }
        else if (m_upperCase == true && m_lowerCase == false && m_numbers == false && m_specials == true)
         {
             
             for (int i = 0; i < size; i++)
             {
                arrList.add(UpperSpec.charAt(rand.nextInt( UpperSpec.length() )));
             }
         }
        else if (m_upperCase == false && m_lowerCase == true && m_numbers == true && m_specials == false)
         {
             
             for (int i = 0; i < size; i++)
             {
                arrList.add(LowerNum.charAt(rand.nextInt( LowerNum.length() )));
             }
         }
        else if (m_upperCase == false && m_lowerCase == true && m_numbers == false && m_specials == true)
         {
             
             for (int i = 0; i < size; i++)
             {
                arrList.add(LowerSpec.charAt(rand.nextInt( LowerSpec.length() )));
             }
         }
        else if (m_upperCase == false && m_lowerCase == false && m_numbers == true && m_specials == true)
         {
             
             for (int i = 0; i < size; i++)
             {
                arrList.add(NumSpec.charAt(rand.nextInt( NumSpec.length() )));
             }
         }
        else if (m_upperCase == true && m_lowerCase == true && m_numbers == true && m_specials == false)
         {
             
             for (int i = 0; i < size; i++)
             {
                arrList.add(UpperLowerNum.charAt(rand.nextInt( UpperLowerNum.length() )));
             }
         }
        else if (m_upperCase == true && m_lowerCase == true && m_numbers == false && m_specials == true)
         {
             
             for (int i = 0; i < size; i++)
             {
                arrList.add(UpperLowerSpec.charAt(rand.nextInt( UpperLowerSpec.length() )));
             }
         }
        else if (m_upperCase == true && m_lowerCase == true && m_numbers == false && m_specials == true)
         {
             
             for (int i = 0; i < size; i++)
             {
                arrList.add(UpperNumSpec.charAt(rand.nextInt( UpperNumSpec.length() )));
             }
         }
        else if (m_upperCase == false && m_lowerCase == true && m_numbers == true && m_specials == true)
         {
             
             for (int i = 0; i < size; i++)
             {
                arrList.add(LowerNumSpec.charAt(rand.nextInt( LowerNumSpec.length() )));
             }
         }
        
    }
   
    
    public void password8(ArrayList<Character> list)
    {
        generator(8, list);
    }
    
    public void password10(ArrayList<Character> list)
    {
        generator(10, list);
    }
    
    public void password12(ArrayList<Character> list)
    {
        generator(12, list); 
    }
    
    public void password16(ArrayList<Character> list)
    {
        generator(16, list); 
    }

   
    
}
/*

*/