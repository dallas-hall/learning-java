package chapter07_1d_arrays;

import java.util.Scanner;

/**
 * <h1>Input Counting</h1>
 * <p>
 * This program will accept number inputs and return how many times they were inputted.
 * </p>
 * <p>
 * tags:	Scanner; nextInt; for loop;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-04-17
 */
public class Question03
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int inputCount = 0;
        boolean done = false;
        int[] numbers = new int[99];
               
        do {
            System.out.print("Enter score: ");
            int inputNumber = Integer.parseInt(keyboard.nextLine());
            if (inputNumber > 0 && inputNumber < 100)
            {
                numbers[inputCount] = inputNumber;
                inputCount++;
            }
            else if (inputNumber < 0 || inputNumber >= 100)
            {
                System.out.println("Enter a number between >= 1 or <= 99");
            }
        } while (inputCount < 10);
                
        for (int i = 0; i < inputCount; i++)
        {
            int count = 0;
            for (int j = 0; j < inputCount; j++)
            {
                if (numbers[i] == numbers[j])
                {
                    count++;
                }
            }
            if (count == 1)
            {
                System.out.println(numbers[i] + " occurs " + count + " time.");
            }
            else 
            {
                System.out.println(numbers[i] + " occurs " + count + " times.");
            }
        }
    }
}
