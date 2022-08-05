

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
        messageP1 = new MessagePost("hihowareya", "Hi everyone, sucks 2 b u!");
        photoPos1 = new PhotoPost("hihowareya", "~/mah big pen.jpg", "LOL look at dis pen");
        newsFeed1.addPost(messageP1);
        newsFeed1.addPost(photoPos1);
        newsFeed1.show();
        photoPos1.getImageFile();
        messageP1.getText();
        newsFeed1.show();
        photoPos1.getImageFile();
        photoPos1.getCaption();
        messageP1.like();
        messageP1.like();
        messageP1.addComment("hi mom");
        photoPos1.addComment("h0h0h0h0 what a big pen you have");
        photoPos1.like();
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
