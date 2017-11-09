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
