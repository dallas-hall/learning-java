   /**
 * This class represents a simple picture. You can draw the picture using
 * the draw method. But wait, there's more: being an electronic picture, it
 * can be changed. You can set it to black-and-white display and back to
 * colors (only after it's been drawn, of course).
 *
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author  Michael Kšlling and David J. Barnes
 * @version 2011.07.31
 */
public class Picture
{
    private Square wall;
    private Square window;
    private Triangle roof;
    private Circle sun;
    private Person person;
    //changes
    private Triangle ufo1;
    private Triangle ufo2;
    
    /**
     * Constructor for objects of class Picture
     */
    public Picture()
    {
        // nothing to do... instance variables are automatically set to null
    }

    /**
     * Draw this picture.
     */
    public void draw()
    {
        wall = new Square();
        wall.moveHorizontal(-140);
        wall.moveVertical(20);
        wall.changeSize(120);
        wall.makeVisible();
        
        window = new Square();
        window.changeColor("black");
        window.moveHorizontal(-120);
        window.moveVertical(40);
        window.changeSize(40);
        window.makeVisible();

        roof = new Triangle();  
        roof.changeSize(60, 180);
        roof.moveHorizontal(20);
        roof.moveVertical(-60);
        roof.makeVisible();

        sun = new Circle();
        sun.changeColor("yellow");
        sun.moveHorizontal(100);
        sun.moveVertical(-40);
        sun.changeSize(80);
        sun.makeVisible();
        //sun.slowMoveVertical(300);
        
        newPerson();
        
        //ufo 1 - large | ufo2 - small
        ufo1 = new Triangle();
        ufo2 = new Triangle();
        
        ufo1.changeColor("magenta");
        ufo2.changeColor("blue");
        
        ufo1.moveHorizontal(-400);
        ufo2.moveHorizontal(-400);
        
        ufo1.moveVertical(-40);
        ufo2.moveVertical(-40);

        ufo1.changeSize(40,20);
        ufo2.changeSize(20,10);
        
        ufo1.makeVisible();
        ufo2.makeVisible();
        
        ufo1.slowMoveHorizontal(400);
        ufo2.slowMoveHorizontal(800);
        ufo1.slowMoveVertical(-400);
        
        //sunset without person moving
        sun.changeColor("black");
        sun.slowMoveVertical(300);
    }

    /**
     * Change this picture to black/white display
     */
    public void setBlackAndWhite()
    {
        if (wall != null)   // only if it's painted already...
        {
            wall.changeColor("black");
            window.changeColor("white");
            roof.changeColor("black");
            sun.changeColor("black");
        }
    }

    /**
     * Change this picture to use color display
     */
    public void setColor()
    {
        if (wall != null)   // only if it's painted already...
        {
            wall.changeColor("red");
            window.changeColor("black");
            roof.changeColor("green");
            sun.changeColor("yellow");
        }
    }

    /* New methods for challenges */
    
    public void sunSet()
    //sun changes colour and sets, person comes home
    {
        sun.slowMoveVertical(300);
        sun.changeColor("black");
        comeHome();
    }

    public void sunRise()
    //sun changes colour and rises, person leaves the home
    {
        sun.changeColor("yellow");
        sun.slowMoveVertical(-300);
        leaveHome();
    }
        
    public void newPerson() 
    //person is created and made to come home
    {
        
       person = new Person();
       person.moveHorizontal(-500);
       person.moveVertical(20);
       person.makeVisible();
       comeHome();
    }
       
    public void comeHome()
    //person comes home
    {
        person.slowMoveHorizontal(450);   
    }
    
    public void leaveHome()
    //person leaves the home
    {
        person.slowMoveHorizontal(-450);   
    }
}