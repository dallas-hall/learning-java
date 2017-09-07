/**
 * 
 */
package chapter02;

import java.util.Scanner;

/**
 * @author:		blindcant
 * @version:	0.1
 * @date:		13 Mar 2017
 * @program:	
 */
public class Exercise_03
{
    public static void main(String[] args)
    {
        //create variables
        final double ONE_FOOT_IN_METER = 0.305;
        
        //create Scanner object
        Scanner keyboard = new Scanner(System.in);
        
        //get user inputs
        System.out.print("Enter a value in feet: ");
        double inputFeet = keyboard.nextDouble();
        
        //calculations
        double meters = inputFeet * ONE_FOOT_IN_METER;
        
        //display answer
        System.out.println(inputFeet + " feet is " + meters + " in meters");
    }
}
