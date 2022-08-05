

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest
{
    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
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

    @Test
    public void positiveTest_addComment()
    {
        SalesItem salesIte1 = new SalesItem("pink dildo", 2500);
        assertEquals(true, salesIte1.addComment("Jane Doe", "This thing ROCKS my world.  Ah-Fucking-Mazing.", 5));
    }

    @Test
    public void positiveTest_add2Comments()
    {
        SalesItem salesIte1 = new SalesItem("pink dildo", 2500);
        assertEquals(true, salesIte1.addComment("Jane Doe", "This thing ROCKS my world.  Ah-Fucking-Mazing.", 5));
        assertEquals(true, salesIte1.addComment("Bobby Brown", "Love love love it.", 4));
        assertEquals(2, salesIte1.getNumberOfComments());
    }

    @Test
    public void negativeTest_authorAlreadyExists()
    {
        SalesItem salesIte1 = new SalesItem("pink dildo", 2500);
        assertEquals(true, salesIte1.addComment("Jane Doe", "This thing ROCKS my world.  Ah-Fucking-Mazing.", 5));
        assertEquals(false, salesIte1.addComment("Jane Doe", "Love love love it.", 5));
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    @Test
    public void negativeTest_commentBoundaries()
    {
        SalesItem salesIte1 = new SalesItem("pink dildo", 2500);
        assertEquals(false, salesIte1.addComment("Jane Doe", "This thing ROCKS my world.  Ah-Fucking-Mazing.", 6));
        assertEquals(false, salesIte1.addComment("Jane Doe", "This thing ROCKS my world.  Ah-Fucking-Mazing.", -1));
        assertEquals(false, salesIte1.addComment("Jane Doe", "This thing ROCKS my world.  Ah-Fucking-Mazing.", 0));
    }

    @Test
    public void testUpAndDownVote()
    {
        Comment comment1 = new Comment("Jane Doe", "This thing ROCKS my world.  Ah-Fucking-Mazing.", 5);
        comment1.upvote();
        comment1.upvote();
        assertEquals(2, comment1.getVoteCount());
        comment1.downvote();
        comment1.downvote();
        assertEquals(0, comment1.getVoteCount());
        assertEquals(5, comment1.getRating());
        comment1.upvote();
        assertEquals(1, comment1.getVoteCount());
    }
}





