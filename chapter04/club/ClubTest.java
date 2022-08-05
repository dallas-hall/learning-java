

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ClubTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClubTest
{
    private Club club1;
    private Membership membersh1;
    private Membership membersh2;
    private Membership membersh3;
    private Membership membersh4;

    
    
    
    
    

    /**
     * Default constructor for test class ClubTest
     */
    public ClubTest()
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
        club1 = new Club();
        club1.numberOfMembers();
        membersh1 = new Membership("Ken", 3, 2015);
        membersh2 = new Membership("ben", 12, 2014);
        membersh3 = new Membership("roger", 3, 2015);
        membersh4 = new Membership("jonno", 3, 2014);
        club1.join(membersh1);
        club1.join(membersh2);
        club1.join(membersh3);
        club1.join(membersh4);
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
