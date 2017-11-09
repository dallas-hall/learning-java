/**
 * 
 */
package chapter05_loops;

import java.util.Scanner;

/**
 * @author:		Dallas Hall
 * @version:	0.1
 * @date:		8 Apr 2017
 * @program:	
 */
public class Exercise_16
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter a positive integer");
        int input = Integer.parseInt(keyboard.nextLine());
        
        System.out.println("The factors for " + input + " are:");
        for (int i = 1; i <= input; i++)
        {
            if (input % i == 0)
            {
                System.out.print(i + " ");
            }
        }
    }

}
