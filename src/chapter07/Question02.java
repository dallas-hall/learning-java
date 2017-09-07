/**
 * 
 */
package chapter07;

import java.util.Scanner;

/**
 * @author:		blindcant
 * @version:	0.1
 * @date:		17 Apr 2017
 * @program:	
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
