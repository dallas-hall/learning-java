

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ClockDisplayTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClockDisplayTest
{
    private ClockDisplay clock1;
        
    /**
     * Default constructor for test class ClockDisplayTest
     */
    public ClockDisplayTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        clock1 = new ClockDisplay(11,58,"am");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
