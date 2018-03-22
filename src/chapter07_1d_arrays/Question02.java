package chapter07_1d_arrays;

import java.util.Scanner;

/**
 * <h1>Array Reversal</h1>
 * <p>
 * This program will accept number inputs and then return them in reverse order.
 * </p>
 * <p>
 * tags:	Scanner; nextInt; for loop;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-04-17
 */
public class Question02
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int[] numbers = new int[10];
        Scanner keyboard = new Scanner(System.in);

        for (int i = 0; i < numbers.length; i++)
        {
            System.out.print("Enter number " + (i + 1) + ":");
            numbers[i] = keyboard.nextInt();
        }
        
        for (int i = numbers.length - 1; i >= 0; i--)
        {
            System.out.print(numbers[i] + " ");
        }
    }
}
