/**
 * 
 */
package chapter05_loops;

/**
 * @author:		Dallas Hall
 * @version:	0.1
 * @date:		1 Apr 2017
 * @program:	
 */

import java.util.Scanner;

public class Exercise_01
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int input = 0;
        int positiveCount = 0;
        int negativeCount = 0;
        int total = 0;
        double average = 0.0;

        // TODO Auto-generated method stub
        do
        {
            System.out.print(
                    "Enter an integer, input will stop when 0 is entered. ");
            input = keyboard.nextInt();
            total += input;
            if (input < 0)
            {
                negativeCount++;
            }
            else if (input > 0)
            {
                positiveCount++;
            }
        }
        while (input != 0);
        if (total != 0)
        {
            System.out.println("Positives total : " + positiveCount);
            System.out.println("Negatives total : " + negativeCount);
            System.out.println("The total was: " + total);
            average = (double) total / (negativeCount + positiveCount);
            System.out.println("The average was: " + average);
        }
        else
        {
            System.out.println("Nothing was entered");
        }
    }
}
