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
public class Exercise_01
{
    public static void main(String[] args)
    {
        //create Scanner object and assign it to a variable
        Scanner keyboard = new Scanner(System.in);
        
        //read in user input
        System.out.print("Enter a degree in Celsius: ");
        double userInput = keyboard.nextDouble();
        
        //calculations
        double celsius = userInput;
        double answer = (9.0 / 5) * celsius + 32;
        System.out.println(celsius + " Celsius is " + answer + " Fahrenheit");
    }
}
