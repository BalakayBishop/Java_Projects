
package csc600_healthassessment;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author balak
 */
public class HealthApp 
{
    private Formatter m_writer = null;
    private Scanner m_reader = null;
    private final String m_fileName;
    
    public HealthApp ( String name )
    {
        m_fileName = name;
    } // end of constructor
    
    public boolean openFileToRead()
    {
            
        try
        {
            m_reader = new Scanner(Paths.get(m_fileName));
            return true; 
        }
        catch ( IOException e )
        {     
            e.printStackTrace();
            return false;
        }
    } // end of open to read method

    public boolean openFileToWrite()
    {
        
        try {
        
            m_writer = new Formatter(m_fileName);
            return true;   
        } 
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    } // end of open to write method
    
    public boolean writeAssessmentToFile( ArrayList<String> dataToFile )
    {
        if( dataToFile==null || m_writer==null)
            return false;
        
        try {
            
            for( String s : dataToFile ){
                m_writer.format( "%s%n", s);
            }
            m_writer.close();
            return true;    
        }
        catch( Exception e)
        {
            e.printStackTrace();
            return false;
        }
    } // end of writes scores method
    
    public boolean readAssessmentFromFile( ArrayList<String> fillme )
    {
        
        if(fillme==null || m_reader==null)
            return false;
        
        try {
            
            String str;
            while (m_reader.hasNextLine())
            {
                str = m_reader.nextLine();
                fillme.add(str);
            }
            m_reader.close();
            return true; 
        } 
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    } // end of read grades method
    
    public static String assessBP (int bpValue)
    {
       String sys; 
       if (bpValue != 0)
       {
            if ( bpValue >= 50 && bpValue <= 90)
            {
                sys = "Low";
                return sys;
            }
            else if (bpValue >= 91 && bpValue <= 140)
            {
                sys = "Normal";
                return sys;
            }
            else if (bpValue >= 141 && bpValue <= 160)
            {
                sys = "Mild";
                return sys;
            }
            else if (bpValue >= 161 && bpValue <= 180)
            {
                sys = "Moderate";
                return sys;
            }
            else if (bpValue >= 181 && bpValue <= 210)
            {
                sys = "Severe";
                return sys;
            }
            else if (bpValue > 210)
            {
                 sys = "Very severe";
                 return sys;
            } 
       }
       else 
       {
           sys = "Error, 0";
           return sys;
       } 
       
       return null;
    } // end of assess BP
    
    public static String assessBMI (double bmiValue)
    {
        String BMI;
        if ( bmiValue != 0 )
        {
           if ( bmiValue <= 15.9 )
            {
                BMI = "Seriously underweight"; 
                return BMI;
            }
            else if ( bmiValue >= 16.0 && bmiValue <= 17.9)
            {
                BMI = "Underweight";
                return BMI;
            }
            else if ( bmiValue >= 18.0 && bmiValue <= 23.9)
            {
                BMI = "Normal weight";
                return BMI;
            }
            else if ( bmiValue >= 24.0 && bmiValue <= 28.9)
            {
                BMI = "Overweight";
                return BMI;
            }
            else if ( bmiValue >= 29.0 && bmiValue <= 34.9)
            {
                BMI = "Seriously overweight";
                return BMI;
            }
            else if ( bmiValue >= 35.0 )
            {
                BMI = "Obese";
                return BMI;
            } 
        }
        else 
        {
            BMI = "Error";
            return BMI;
        }
        
        return null; 
    } // end of assess BMI
    
    public static String assessChol(int chol)
    {
        String Chol;
        if ( chol != 0 )
        {
            if (chol < 200)
            {
                Chol = "Excellent";
                return Chol; 
            }
            else if (chol >= 201 && chol <= 239)
            {
                Chol = "High";
                return Chol;
            }
            else if (chol > 240)
            {
                Chol = "Very high";
                return Chol;
            }
        }
        else
        {
            Chol = "Error";
            return Chol;
        }
        
        return null;
    } // end of assess Cholesterol
    
    public static String assessLDL (int ldl)
    {
        String LDL; 
        if (ldl != 0)
        {
            if (ldl <= 100)
            {
                LDL = "Optimal";
                return LDL;
            }
            else if (ldl >= 101 && ldl <= 159)
            {
                LDL = "Middle Range";
                return LDL;
            }
            else if (ldl >= 160 && ldl <= 189)
            {
                LDL = "High";
                return LDL;
            }
            else if (ldl > 190)
            {
                LDL = "Very high";
                return LDL;
            }  
        }
        else 
        {
            LDL = "Error";
            return LDL;
        }
        return null;
    } // end of assess LDL
    
    public static String assessHDL (int hdl)
    {
        String HDL;
        if (hdl != 0)
        {
            if (hdl < 40)
            {
                HDL = "Low"; 
                return HDL;
            }
            else if (hdl >= 41 && hdl <= 60)
            {
                HDL = "Optimal";
                return HDL;
            }
            else if (hdl > 61)
            {
                HDL = "High";
                return HDL;
            }
        }
        else 
        {
            HDL = "Error";
            return HDL;
        }
        
        return null;
    } // end of assess HDL
    
    public static String assessBS (int bsValue)
    {
        String BS;
        if (bsValue >= 80 && bsValue <= 120)
        {
            BS = "Excellent";
            return BS;
        }
        else if (bsValue >= 150 && bsValue <= 180)
        {
            BS = "Good";
            return BS;
        }
        else if (bsValue >= 210 && bsValue <= 240)
        {
            BS = "Marginal";
            return BS;
        }
        else if (bsValue >= 270 && bsValue <= 310)
        {
            BS = "Poor";
            return BS;
        }
        else if (bsValue >= 340 && bsValue <= 370)
        {
            BS = "Out of control";
            return BS;
        }
        
        return null;
    } // end of assess BS
    
    public static String assessTrig (int trig)
    {
        String Trig;
        if (trig != 0)
        {
            if (trig < 150)
            {
                Trig = "Ideal";
                return Trig;
            }
            else if (trig >= 150 && trig <= 199)
            {
                Trig = "Borderline";
                return Trig;
            }
            else if (trig >= 200 && trig <= 499)
            {
                Trig = "High";
                return Trig;
            }
            else if (trig > 500)
            {
                Trig = "Very high";
                return Trig;
            }
        }
        else
        {
            Trig = "Error";
            return Trig;
        }
        
        return null;
    } // end of assess Triglycerides
    
}
