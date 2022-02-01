
package Drawing;


public class Point 
{
    private double m_x;
    private double m_y;
    private static int m_numPts; 
    
    public double getX()
    {
        return m_x;
    }
    public double getY()
    {
        return m_y;
    }
    
    public void setX( double xSet )
    {
        m_x = xSet; 
    }
    public void setY( double ySet )
    {
        m_y = ySet; 
    }
    
    public static int getNumPts()
    {
        return m_numPts; 
    }
    
    public Point (double x, double y)
    {
        this.m_x = x;
        this.m_y = y;
        m_numPts++; 
    }
    
    @Override
    public void finalize() throws Throwable
    {
        try
        {
            System.out.println("Inside finalize method"); 
        }
        catch (Throwable t)
        {
            throw t; 
        }
        finally
        {
            m_numPts--;
            super.finalize();
        }
    }
}
