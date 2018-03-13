package chapter05_loops;

import java.util.Scanner;

/**
 * <h1>>Factor Printing</h1>
 * <p>
 * This program will accept an integer and work out its factors.
 * </p>
 * <p>
 * tags: for loop; if else;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-08
 */
public class Exercise_16
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter a positive integer");
        int input = Integer.parseInt(keyboard.nextLine());
        
        System.out.println("The factors for " + input + " are:");
        for (int i = 1; i <= input; i++)
        {
            // If the number is evenly divisible by another number, that other number is a factor.
            if (input % i == 0)
            {
                System.out.print(i + " ");
            }
        }
    }
}
