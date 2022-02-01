package Drawing;


public class Line 
{
    private Point m_ptA;
    private Point m_ptB;
    
    public Point getA()
    {
        return m_ptA; 
        
    }
    public Point getB()
    {
        return m_ptB;
    }
    
    public void setA(Point aSet)
    {
        m_ptA = aSet; 
    }
    public void setB(Point bSet)
    {
        m_ptB = bSet; 
    }
    
    Line (Point A, Point B)
    {
        this.m_ptA = A;
        this.m_ptB = B; 
    }
    
    public static double length(Point objA, Point objB)
    {
        double lineLen = 0.0; 
        
        lineLen = Math.sqrt( (Math.pow((objB.getX() - objA.getX()), 2.0))
                            + (Math.pow((objB.getY() - objA.getY()), 2.0)) ); 
        
        return lineLen; 
    }
}
