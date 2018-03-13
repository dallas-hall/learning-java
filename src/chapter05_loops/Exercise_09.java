package chapter05_loops;

/**
 * <h1>>Student Scoring</h1>
 * <p>
 * This program will ask for student names and scores and calculate the winner and the runner up.
 * </p>
 * <p>
 * tags: do while; final;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-01
 */

import java.util.Scanner;

public class Exercise_09
{
    public static void main(String[] args)
    {
        boolean done = false;
        String winnerName = "";
        String runnerupName = "";
        int highestScore = 0;
        int secondHighestScore = 0;

        do
        {
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Enter student name: ");
            String tempName = keyboard.nextLine();
            System.out.print("\nEnter student score: ");
            int tempScore = Integer.parseInt(keyboard.nextLine());
            if (tempScore > highestScore && tempScore > secondHighestScore)
            {
                runnerupName = winnerName;
                secondHighestScore = highestScore;
                winnerName = tempName;
                highestScore = tempScore;
            }
            else if (tempScore < highestScore && tempScore > secondHighestScore)
            {
                runnerupName = tempName;
                secondHighestScore = tempScore;              
            }
            System.out.println("Are you finished?");
            char input = Character.toUpperCase(keyboard.nextLine().charAt(0));
            if (input == 'Y')
            {
                done = true;
            }
        }
        while (!done);
        System.out.println("The winner was: " + winnerName + " with a score of: " + highestScore);
        System.out.println("The runnerup was: " + runnerupName + " with a score of: " + secondHighestScore);
    }
}