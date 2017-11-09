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

public class Exercise_08
{

    public static void main(String[] args)
    {
        boolean done = false;
        String name = "";
        int score = 0;

        do
        {
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Enter student name: ");
            String tempName = keyboard.nextLine();
            System.out.print("\nEnter student score: ");
            int tempScore = Integer.parseInt(keyboard.nextLine());
            if (tempScore > score)
            {
                name = tempName;
                score = tempScore;
            }
            System.out.println("Are you finished?");
            char input = Character.toUpperCase(keyboard.nextLine().charAt(0));
            if (input == 'Y')
            {
                done = true;
            }
        }
        while (!done);
        System.out.println("The winner was: " + name + " with a score of: " + score);
    }
}
