
package Robot;


public class RobotJAVA 
{
    private int m_x;
    private int m_y;
    private char payload;
    
    private static final int a = 25;
    private static final int b = 25;
    
    public int getX()
    {
        return m_x;
    }
    public int getY()
    {
        return m_y;
    }
    public char getLoad()
    {
        return payload;
    }
    
    public void setX (int xSet)
    {
        m_x = xSet; 
    }
    public void setY(int ySet)
    {
        m_y = ySet;
    }
    public void setLoad(char loadSet)
    {
        payload = loadSet; 
    }
    
    RobotJAVA()
    {
        m_x = 0; 
        m_y = 0; 
        payload = '*'; 
    }
    
    RobotJAVA(int xPass, int yPass, char Pass)
    {
        this.m_x = xPass;
        this.m_y = yPass;
        this.payload = Pass;
    }
    
    public static void print(char[][] printArr, char set, RobotJAVA obj)
    {
        obj.setLoad(set); 
        
        for (int i = 0; i < printArr.length; i++)
        {
            for (int j = 0; j < printArr.length; j++)
            {
                System.out.print(printArr[i][j]);
            }
            System.out.println(); 
        }
        
    }
    
    public static void print2D(char[][] passedArray)
    {
        for (int i = 0; i < passedArray.length; i++)
        {
            for (int j = 0; j < passedArray.length; j++)
            {
                System.out.print(passedArray[i][j]);
            }
            System.out.println(); 
        }
    }
    
    public static boolean pickUp(int lx, int ly, RobotJAVA obj, char[][] pass)
    {
        boolean check = true; 
        if ( obj.getY() != lx && obj.getX() != ly)
        {
            System.out.println("Robot not at (lx,ly)");
            check = false; 
        }
        else if ( pass[lx][ly] == '*')
        {
            System.out.println("No load at this location");
            check = false;
        }
        else
        {
            if ( obj.getLoad() == '*')
                {
                    obj.setLoad(pass[lx][ly]);
                    pass[lx][ly] = '*';
                    check = true;
                }
        }
        return check; 
    }
    
    public static boolean dropOff(int lx, int ly, RobotJAVA obj, char[][] pass)
    {
        boolean check = true; 
        char temp; 
        if ( obj.getY() != lx && obj.getX() != ly)
        {
           System.out.println("Robot not at (lx,ly)");
            check = false;  
        }
        else
        {
            if ( obj.getLoad() != '*')
                {
                    pass[lx][ly] = obj.getLoad();
                    obj.setLoad('*');
                    check = true;
                }
        }
        return check; 
    }
    
    public static void moveUp(char[][] pass2, RobotJAVA obj2)
    {
       int y = obj2.getX(); 
        
        if (y == 0)
        {
            System.out.println("The top boundry has been reached");
            
        }
        else
        {
            y--;
            obj2.setX(y);
        } 
    }
    
    public static void moveDown(char[][] pass3, RobotJAVA obj3)
    {
        int y = obj3.getX(); 
        
        if (y == 25)
        {
            System.out.println("The bottom boundry has been reached");
            
        }
        else
        {
            y++;
            obj3.setX(y);
        }
    }
    
    public static void moveRight(char[][] pass4, RobotJAVA obj4) 
    {
       int x = obj4.getY(); 
        
        if (x == 25)
        {
            System.out.println("The right boundry has been reached");
            
        }
        else
        {
            x++;
            obj4.setY(x);
        } 
    }
    
    public static void moveLeft(char[][] pass5, RobotJAVA obj5)
    {
        int x = obj5.getY(); 
        
        if (x == 0)
        {
            System.out.println("The left boundry has been reached");
            
        }
        else
        {
            x--;
            obj5.setY(x);
        }
    }
    
    public static boolean moveTo (char[][] pass6, RobotJAVA obj6, int moveToX, int moveToY)
    {
        boolean checkMove = true;
        int y = obj6.getX(); // this moves on the x-axis
        int x = obj6.getY(); // this moves on the y-axis
        int amountToMoveX = Math.abs(x - moveToX); // these two are to examine the value needed to move 
        int amountToMoveY = Math.abs(y - moveToY); // Math.abs to prevent negatives 
        
        if ( x < 0 && x > 25 )
        {
            checkMove = false;
        }
        else if ( y < 0 && y > 25 )
        {
            checkMove = false;
        }
        else if (checkMove == true)
        {
            // used to move left or right
            if ( x > moveToX) 
            {
                for (int i = 0; i < amountToMoveX; i++)
                {
                    RobotJAVA.moveLeft(pass6, obj6);
                }
            }
            else if (x < moveToX)
            {
               for (int i = 0; i < amountToMoveX; i++)
                {
                    RobotJAVA.moveRight(pass6, obj6);
                } 
            }
            // used to move up or down
            if ( y > moveToY) 
            {
                for (int i = 0; i < amountToMoveY; i++)
                {
                    RobotJAVA.moveUp(pass6, obj6);
                }
            }
            else if (y < moveToY)
            {
               for (int i = 0; i < amountToMoveY; i++)
                {
                    RobotJAVA.moveDown(pass6, obj6);
                } 
            }
        }
        
        return checkMove; 
    }
    
    public static void main(String[] args)
    {
        // Part A
        char[][] robotArray = new char[a][b]; 
        
        for (int i = 0; i < robotArray.length; i++)
        {
            for (int j = 0; j < robotArray.length; j++)
            {
                robotArray[i][j] = '*'; 
            }
        }
        
        robotArray[8][10] = 'B';  
        robotArray[4][22] = 'C';
        RobotJAVA.print2D(robotArray);
        System.out.println();
        
        
        // Part B
        RobotJAVA r1 = new RobotJAVA();
        RobotJAVA r2 = new RobotJAVA(5, 5, '*');
        System.out.println("The location of Robot 1 is (" + r1.getX() + ", " + r1.getY() + ")\n"
                            + "The location of Robot 2 is (" + r2.getX() + ", " + r2.getY() + ")");
        
        // Part C
        RobotJAVA.moveTo(robotArray, r1, 24, 23);
        RobotJAVA.moveTo(robotArray, r2, 3, 15); 
        System.out.println("The location of Robot 1 is (" + r1.getX() + ", " + r1.getY() + ")\n"
                            + "The location of Robot 2 is (" + r2.getX() + ", " + r2.getY() + ")");
        
        // Part D
        RobotJAVA.moveTo(robotArray, r1, 8, 10);
        RobotJAVA.pickUp(8, 10, r1, robotArray);
        RobotJAVA.moveTo(robotArray, r1, 20, 20);
        RobotJAVA.dropOff(20, 20, r1, robotArray); 
        RobotJAVA.print2D(robotArray);
        System.out.println();
        
        // Part E
        RobotJAVA.moveTo(robotArray, r2, 4, 22);
        RobotJAVA.pickUp(4, 22, r2, robotArray);
        RobotJAVA.moveTo(robotArray, r2, 0, 0);
        RobotJAVA.dropOff(0, 0, r2, robotArray); 
        RobotJAVA.print2D(robotArray);
        System.out.println();
        
        
    }
 
}
