import java.awt.*;
import java.awt.geom.*;

/**
 * Write a description of class BoxBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoxBall
{
    // @@@ instance variables @@@
    // ### ball properties ###
    // effect of gravity
    private static final int GRAVITY = 3;
    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private int diameter;
    // starting position?
    private int xPosition;
    private int yPosition;
    // initial downward speed
    private int ySpeed = 1;
    private Canvas canvas;
    // walls



    /**
     * Constructor for objects of class BoxBall
     */
    public BoxBall(int xPosition, int yPosition, int ballDiameter, Color ballColor, Canvas drawingCanvas)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        canvas = drawingCanvas;
    }
}
