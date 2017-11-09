/**
 * 
 */
package chapter02_basic_programming;

import java.util.Scanner;

/**
 * @author:		blindcant
 * @version:	0.1
 * @date:		13 Mar 2017
 * @program:	
 */
public class Exercise_04
{
    public static void main(String[] args)
    {
        //create final variable
        final double ONE_POUND_IN_KILOGRAM = 0.454;
        
        //create Scanner object
        Scanner keyboard = new Scanner(System.in);
        
        //get user input
        System.out.print("Enter a number in pounds: ");
        double inputPounds = keyboard.nextDouble();
        
        //calculations
        double kilograms = inputPounds * ONE_POUND_IN_KILOGRAM;
        
        //display answer
        System.out.println(inputPounds + " pounds is " + kilograms + " kilograms");
    }
}
