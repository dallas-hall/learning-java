/**
 * 
 */
package chapter02_basic_programming;

import java.util.Scanner;

/**
 * <h1>Calculate Gratuity</h1>
 * <p>
 * This program will accept user input for the total and the gratuity rate, and calculate how much is owing.
 * </p>
 * <p>
 * tags: math; Scanner; nextDouble;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-03-13
 */
public class Exercise_05
{

    public static void main(String[] args)
    {
        //create Scanner object
        Scanner keyboard = new Scanner(System.in);
        
        //get user input
        System.out.print("Enter subtotal: ");
        double subtotal = keyboard.nextDouble();
        System.out.print("Enter gratuity rate: ");
        double gratuityRate = keyboard.nextDouble();
        
        //calculations
        double gratuity = subtotal * (gratuityRate / 100.00);
        double total = subtotal + gratuity;
        
        //display answer
        System.out.println("The gratuity is $" + gratuity + " & the total is $"
                + total);

    }

}
