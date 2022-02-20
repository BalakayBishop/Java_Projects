package csc600_loanapp;

import java.util.Scanner;

/**
 *
 * @author balak
 */
public class LoanAppMain 
{
    static Scanner input = new Scanner(System.in); 
    // creating the data members
    private final double m_amount; 
    private final double m_intRate;
    private final int m_duration; 
    
    //creating a constructor
    LoanAppMain(double amount, double intRate, int months)
    {
        m_amount = amount;
        m_intRate= intRate;
        m_duration = months; 
    } // end of Ctor
    
    // creating getters for the data, no setters
    public double getAmount()
    {
        return m_amount;
    }
    public double getInterestRate()
    {
        return m_intRate;
    }
    public int getDuration()
    {
        return m_duration;
    }
    
    public double monthlyPayment(double amount, double intRate, int months)
    {
        double payment = 0.0;
        double p = amount;
        double r = (intRate / 12.0); 
        int n = months; 
        
        payment = p * r * (Math.pow( (1 + r), n) ) / ( Math.pow( (1 + r), n) - 1); 
        
        payment = Math.round(payment * 100.0) / 100.0; 
        
        return payment; 
    } // end of monthly payment
    
    public double totalInterest(double amount, double monthlyPayment, int months)
    {
        double interest = 0.0;
        
        interest = months * monthlyPayment - amount; 
        
        interest = Math.round(interest * 100.0) / 100.0;
        
        return interest; 
    } // end of total interest
    
    public boolean isValid(double v_value)
    {
        boolean valid;
        
        if (v_value >= 0.0 )
        {
            valid = true;
        }
        else 
        {
            valid = false;
        }
        
        return valid;  
    } // end of verification
    
}
