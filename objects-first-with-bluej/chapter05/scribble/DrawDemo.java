import java.awt.Color;
import java.util.Random;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the 
 * Pen class to create various drawings.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class DrawDemo
{
    private Canvas myCanvas;
    private Random random;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo()
    {
        //create a new canvas object, add a title and set the window size
        myCanvas = new Canvas("Drawing Demo Bitches", 1024, 768);
        //create a new random object
        random = new Random();
    }

    /**
     * Draw a square on the screen.
     */
    public void drawSquare()
    {
        //create a new pen object, with x and y positions
        Pen pen = new Pen(300, 100, myCanvas);
        //set the colour
        pen.setColor(Color.BLUE);
        
        //draw the sqaure
        square(pen);
    }

    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel()
    {
        //create a new pen object, with x and y positions
        Pen pen = new Pen(250, 200, myCanvas);
        //set the colour
        pen.setColor(Color.RED);

        //do 36 iterations of drawing a sqaure and turning the pen 10 degrees
        for (int i=0; i<36; i++) {
            square(pen);
            pen.turn(10);
        }
    }

    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen)
    {
        for (int i=0; i<4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }

    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble()
    {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i=0; i<10; i++) {
            // pick a random color in the RGB spectrum but using random numbers between 0 and 255
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            pen.setColor(new Color(red, green, blue));
            
            pen.randomSquiggle();
        }
    }
    
    /**
     * exercise 5.57 - draw a freaking triangle mang
     */
    public void drawEquilateralTriangle()
    {
        //create a pen object @ 250 by 250 on the myCanvas object, make the colour green
        Pen pen = new Pen(500, 500, myCanvas);
        pen.setColor(Color.GREEN);
        
        //draw that green triangle bro
        triangle(pen);
    }
    
    private void triangle(Pen pennyMcPenFace)
    {
        for (int i = 0; i < 3; i++)
        {
            pennyMcPenFace.move(100);
            pennyMcPenFace.turn(120);
        }
    }
    
    /**
     * exercise 5.58 - draw a freaking triangle mang
     */
    public void drawPentagon()
    {
        //create a pen object @ 250 by 250 on the myCanvas object, make the colour green
        Pen pen = new Pen(100, 100, myCanvas);
        pen.setColor(Color.MAGENTA);
        
        //draw that green triangle bro
        pentagon(pen);
    }
    
    private void pentagon(Pen pennyMcPenFace)
    {
        for (int i = 0; i < 5; i++)
        {
            pennyMcPenFace.move(50);
            //https://www.mathsisfun.com/geometry/interior-angles-polygons.html
            pennyMcPenFace.turn(72);
        }
    }
    
    /**
     * draw a freaking hexagon mang
     */
    public void drawHexagon()
    {
        //create a pen object @ 250 by 250 on the myCanvas object, make the colour green
        Pen pen = new Pen(200, 200, myCanvas);
        pen.setColor(Color.BLUE);
        
        //draw that green triangle bro
        hexagon(pen);
    }
    
    private void hexagon(Pen pennyMcPenFace)
    {
        for (int i = 0; i < 6; i++)
        {
            pennyMcPenFace.move(100);
            pennyMcPenFace.turn(60);
        }
    }
    
    /**
     * Exercise 5.59-1 draw any freaking polygon mang
     */
    public void drawPolygonHardCoded3To6Only(int sides)
    {
        Pen pen = new Pen(200, 200, myCanvas);
        pen.setColor(Color.ORANGE);
        polygonHardCodedFrom3To6(pen, sides);
    }
    
    private void polygonHardCodedFrom3To6(Pen pennyMcPenFace, int sides)
    {
        int angle = 0;
        if (sides == 3)
        {
            angle = 120;
        }
        else if (sides == 4)
        {
            angle = 90;
        }
        else if (sides == 5)
        {
            angle = 72;
        }
        else if (sides == 6)
        {
            angle = 60;
        }
        else
        {
            return;
        }
            
        for (int i = 0; i < sides; i++)
        {
            pennyMcPenFace.move(100);
            pennyMcPenFace.turn(angle);
        }
    }
    
    /**
     * Exercise 5.59-2 draw any freaking polygon mang
     */
    public void drawPolygon(int sides)
    {
        Pen pen = new Pen(200, 100, myCanvas);
        pen.setColor(Color.GRAY);
        polygon(pen, sides);
    }
    
    private void polygon(Pen pennyMcPenFace, int sides)
    {
        /*
         * https://www.mathsisfun.com/geometry/interior-angles-polygons.html
         * 
         * Sum of interior angles = (sides - 2) x 180 degrees
         * Each angle (of a regular polygon) = (sides - 2) x 180 / sides
         * 
         * Doesn't work because Java uses radians and not degrees
         * 
         * int angleSum = (sides - 2) * 180;
         * int angle = angleSum / sides;
         */
  
        //divide a circle by the number of sides we wish to draw, this gives us the drawing angle
        int angle = 360 / sides;
            
        for (int i = 0; i < sides; i++)
        {
            pennyMcPenFace.move(100);
            pennyMcPenFace.turn(angle);
        }
    }
    
    /**
     * exercise 5.60 draw a freaking spiral mang
     */
    public void drawSpiral()
    {
        //create a pen object @ 200 by 200 on the myCanvas object, make the colour green
        Pen pen = new Pen(200, 200, myCanvas);
        pen.setColor(Color.GREEN);
        
        //draw that green triangle bro
        spiral(pen);
    }
    
    private void spiral(Pen pennyMcPenFace)
    {
        int length = 25;
        final int ANGLE = 90;
        for (int i = 0; i < 25; i++)
        {
            if (i == 0)
            {
                pennyMcPenFace.move(length);
                pennyMcPenFace.turn(ANGLE);
            }
            else if (i % 2 != 0)
            {
                pennyMcPenFace.move(length);
                pennyMcPenFace.turn(ANGLE);
            }
            else
            {
                length+=25;
                pennyMcPenFace.move(length);
                pennyMcPenFace.turn(ANGLE);
            }
        }
    }
    
    public void drawSomeFuckingPicture()
    {
        myCanvas.drawString("drawing a fucking spiral mang", 1, 32);
        Pen pen = new Pen(10, 10, myCanvas);
        drawSpiral();
        myCanvas.drawString("drawing a fucking equilaterial triangle mang", 1, 64);
        drawEquilateralTriangle();
        myCanvas.setBackgroundColor(Color.GRAY);
        myCanvas.drawString("drawing a fucking square mang", 1, 96);
        drawPolygon(4);
        
        
    }
    
    /**
     * Clear the screen.
     */
    public void clear()
    {
        myCanvas.erase();
    }
}
