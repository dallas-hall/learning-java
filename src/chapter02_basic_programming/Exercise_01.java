/**
 * 
 */
package chapter02_basic_programming;

import java.util.Scanner;

/**
 * <h1>Convert Celsius to Fahrenheit</h1>
 * <p>
 * This program will accept user input, a temperature in Celsius, and convert it to Fahrenheit.
 * </p>
 * <p>
 * tags: math; Scanner; nextDouble;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-03-13
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
