
/**
 * Test class
 * 
 * @author Dallas 
 * @version 2015-06-28_v1
 */
public class TestClockDisplay
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class Test
     */
    public TestClockDisplay()
    {
        // initialise instance variables
     
    }

    public void test1()
    {
    ClockDisplay clock1 = new ClockDisplay();
    
    clock1.setTime(11,59,"am");
    System.out.println(clock1.getTime());
    clock1.timeTick();
    System.out.println(clock1.getTime());
    newLine();
    }
    
    public void test2()
    {
    ClockDisplay clock1 = new ClockDisplay();
    
    clock1.setTime(11,59,"pm");
    System.out.println(clock1.getTime());
    clock1.timeTick();
    System.out.println(clock1.getTime());
    newLine();
    }
    
    public void newLine()
    {
        System.out.println();
    }
}
