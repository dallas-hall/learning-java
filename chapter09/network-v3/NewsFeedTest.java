

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NewsFeedTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NewsFeedTest
{
    private NewsFeed newsFeed1;
    private MessagePost messageP1;
    private PhotoPost photoPos1;

    /**
     * Default constructor for test class NewsFeedTest
     */
    public NewsFeedTest()
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
        newsFeed1 = new NewsFeed();
        messageP1 = new MessagePost("sexychic12", "hi everyone, tit photos coming soon...");
        photoPos1 = new PhotoPost("sexychic12", "titty drop.mpeg", "mah big titties");
        photoPos1.like();
        photoPos1.like();
        photoPos1.addComment("WOW I want to motorboat them all day");
        newsFeed1.addPost(messageP1);
        newsFeed1.addPost(photoPos1);
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
