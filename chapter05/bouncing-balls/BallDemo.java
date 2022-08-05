import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
// PRNG for >= Java 1.7
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BouncingBall> allBallsArrayList;
    private HashMap<String, BouncingBall> allBallsHashMap;
    private HashSet<BouncingBall> allBallsHashSet;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 640, 480);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    
    public void bounceExercise562ArrayList(int nummberOfBalls)
    {
        //create our ArrayList
        allBallsArrayList = new ArrayList<>();
        
        //setup ground position
        int ground = 400;
        
        //display canvas
        myCanvas.setVisible(true);
        
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        for (int i = 0; i < nummberOfBalls; i++)
        {
            int xAxisPosition = ThreadLocalRandom.current().nextInt(50, 100 + 1);
            int yAxisPosition = ThreadLocalRandom.current().nextInt(0, 250 + 1);
            int size = ThreadLocalRandom.current().nextInt(10, 20 + 1);
            int color = ThreadLocalRandom.current().nextInt(1, 5 + 1);
            if (color == 1)
            {
                allBallsArrayList.add(new BouncingBall(xAxisPosition, yAxisPosition, size, Color.BLUE, ground, myCanvas));
            }
            else if (color == 2)
            {
                allBallsArrayList.add(new BouncingBall(xAxisPosition, yAxisPosition, size, Color.YELLOW, ground, myCanvas));
            }
            else if (color == 3)
            {
                allBallsArrayList.add(new BouncingBall(xAxisPosition, yAxisPosition, size, Color.RED, ground, myCanvas));
            }
            else if (color == 4)
            {
                allBallsArrayList.add(new BouncingBall(xAxisPosition, yAxisPosition, size, Color.GREEN, ground, myCanvas));
            }
            else
            {
                allBallsArrayList.add(new BouncingBall(xAxisPosition, yAxisPosition, size, Color.PINK, ground, myCanvas));
            }
        }
        
        boolean finished =  false;
        while(!finished) {
            // small delay of the moving ball
            myCanvas.wait(25);  
            
            //draw all the balls
            for (BouncingBall currentBall : allBallsArrayList)
            {
                currentBall.draw();
                currentBall.move();
                // stop once ball has travelled a certain distance on x axis
                if (currentBall.getXPosition() >= 550)
                    finished = true;
                //random delay between 10 and 40 milliseconds
            }
        }
    }
    
    public void bounceExercise562HashMap(int nummberOfBalls)
    {
        //create our HashMap
        allBallsHashMap = new HashMap<>();
                
        //setup ground position
        int ground = 400;
        
        //display canvas
        myCanvas.setVisible(true);
        
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        //create a HashSet to search with, this holds our ball names which we can use to search the HashMap keys with
        HashSet<String> ballNames = new HashSet<String>();
         
        for (int i = 0; i < nummberOfBalls; i++)
        {
            int xAxisPosition = ThreadLocalRandom.current().nextInt(50, 100 + 1);
            int yAxisPosition = ThreadLocalRandom.current().nextInt(0, 250 + 1);
            int size = ThreadLocalRandom.current().nextInt(10, 20 + 1);
            int color = ThreadLocalRandom.current().nextInt(1, 5 + 1);
            
            String ballName = "ball";
            //add the ball to the HashSet containing Strings, increment its name each time we loop
            ballNames.add(ballName + i);
            
            //add a new ball to the HashMap, based on the random numbers generated above
            if (color == 1)
            {
                allBallsHashMap.put(ballName+i, new BouncingBall(xAxisPosition, yAxisPosition, size, Color.BLUE, ground, myCanvas));
            }
            else if (color == 2)
            {
                allBallsHashMap.put(ballName+i, new BouncingBall(xAxisPosition, yAxisPosition, size, Color.YELLOW, ground, myCanvas));
            }
            else if (color == 3)
            {
                allBallsHashMap.put(ballName+i, new BouncingBall(xAxisPosition, yAxisPosition, size, Color.RED, ground, myCanvas));
            }
            else if (color == 4)
            {
                allBallsHashMap.put(ballName+i, new BouncingBall(xAxisPosition, yAxisPosition, size, Color.GREEN, ground, myCanvas));
            }
            else
            {
                allBallsHashMap.put(ballName+i, new BouncingBall(xAxisPosition, yAxisPosition, size, Color.PINK, ground, myCanvas));
            }
        }
        
        boolean finished =  false;
        while(!finished) {
            // small delay of the moving ball
            myCanvas.wait(50);  
            
            //search the HashSet for each ball
            for (String currentBallName : ballNames)
            {
                //get the ball from teh HashMap that is the currentball based on its name
                BouncingBall currentBall = allBallsHashMap.get(currentBallName);
                
                //display the ball
                currentBall.draw();
                currentBall.move();
                // stop once ball has travelled a certain distance on x axis
                if (currentBall.getXPosition() >= 550)
                    finished = true;
                //random delay between 10 and 40 milliseconds
            }
        }
    }
    
    public void bounceExercise562HashSet(int nummberOfBalls)
    {
        //create the HashSet
        allBallsHashSet = new HashSet<>();
                
        //setup ground position
        int ground = 400;
        
        //display canvas
        myCanvas.setVisible(true);
        
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        for (int i = 0; i < nummberOfBalls; i++)
        {
            int xAxisPosition = ThreadLocalRandom.current().nextInt(50, 100 + 1);
            int yAxisPosition = ThreadLocalRandom.current().nextInt(0, 250 + 1);
            int size = ThreadLocalRandom.current().nextInt(10, 20 + 1);
            int color = ThreadLocalRandom.current().nextInt(1, 5 + 1);

            //add a new ball to the HashMap, based on the random numbers generated above
            if (color == 1)
            {
                allBallsHashSet.add(new BouncingBall(xAxisPosition, yAxisPosition, size, Color.BLUE, ground, myCanvas));
            }
            else if (color == 2)
            {
                allBallsHashSet.add(new BouncingBall(xAxisPosition, yAxisPosition, size, Color.YELLOW, ground, myCanvas));
            }
            else if (color == 3)
            {
                allBallsHashSet.add(new BouncingBall(xAxisPosition, yAxisPosition, size, Color.RED, ground, myCanvas));
            }
            else if (color == 4)
            {
                allBallsHashSet.add(new BouncingBall(xAxisPosition, yAxisPosition, size, Color.GREEN, ground, myCanvas));
            }
            else
            {
                allBallsHashSet.add(new BouncingBall(xAxisPosition, yAxisPosition, size, Color.PINK, ground, myCanvas));
            }
        }
        
        boolean finished =  false;
        while(!finished) {
            // small delay of the moving ball
            myCanvas.wait(50);  
            
            //search the HashSet for each ball
              for (BouncingBall currentBall : allBallsHashSet)
            {
                currentBall.draw();
                currentBall.move();
                // stop once ball has travelled a certain distance on x axis
                if (currentBall.getXPosition() >= 550)
                    finished = true;
                //random delay between 10 and 40 milliseconds
            }
        }
    }

    public void boxBounceExercise565()
    {
        myCanvas.setVisible(true);
        
        /*
         * parm1 = startX parm2 = startY parm3 = endX and parm4 = endY
         * 0 x = all the way to the left
         * 0 y = all the way to the top
         */
        
        //TOP - start @ 50 x & 100 y, draw a line to 350 x along 100 y
        int top = 100;
        myCanvas.drawLine(50, top, 350, top);
        //BOTTOM - start @ 50 x & 400 y, draw a line to 350 x along 400 y
        int bottom = 400;
        myCanvas.drawLine(50, bottom, 350, bottom);
        //LEFT - start @ 50 x & 100y, draw a line to 350 x along 100 y
        int left = 50;
        myCanvas.drawLine(left, 100, left, 400);
        //RIGHT - start @ 350x & 100y, draw a line to 350x along 400 y
        int right = 350;
        myCanvas.drawLine(right, 100, right, 400);
        //MIDDLE - 200 x and 250 y
        int middlePointX = 200;
        int middlePointY = 250;
        
        //create and show the ball - X, Y, diameter, colour, ground position, drawing
        int ballSize = 16;
        BouncingBall ball = new BouncingBall(middlePointX, middlePointY, ballSize, Color.BLUE, bottom, myCanvas);
        ball.draw();
        
        // make it bounce
        boolean finished =  false;
        while(!finished)
        {
            //small delay for motion. higher is slower
            myCanvas.wait(50);
            ball.move();

            // stop once ball has travelled a certain distance on x axis, need to minus the ball size so it doesn't leave the box
            if(ball.getXPosition() >= (350 - ballSize)) {
                ball.moveY();
            }
        }
    }
}
