package chapter07_1d_arrays;

import java.util.Scanner;

/**
 * <h1>Student Grading</h1>
 * <p>
 * This program will calculate grades based on the student scores.
 * </p>
 * <p>
 * tags:	Scanner; nextInt; for loop;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-04-17
 */
public class Question01
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int bestScore = Integer.MIN_VALUE;

        System.out.print("How many students?:");
        int[] studentScore = new int[keyboard.nextInt()];

        for (int i = 0; i < studentScore.length; i++)
        {
            System.out.println("Enter score");
            studentScore[i] = keyboard.nextInt();
            if (studentScore[i] > bestScore)
            {
                bestScore = studentScore[i];
            }
        }
        
        for (int i = 0; i < studentScore.length; i++)
        {
            if (studentScore[i] >= bestScore - 10)
            {
            System.out
                    .println("Student " + i + " score was " + studentScore[i] + " grade is A");
            }
            else if (studentScore[i] >= bestScore - 20)
            {
                System.out
                .println("Student " + i + " score was " + studentScore[i] + " grade is B");
            }
            else if (studentScore[i] >= bestScore - 30)
            {
                System.out
                .println("Student " + i + " score was " + studentScore[i] + " grade is C");
            }
            else if (studentScore[i] >= bestScore - 40)
            {
                System.out
                .println("Student " + i + " score was " + studentScore[i] + " grade is D");
            }
            else
            {
                System.out
                .println("Student " + i + " score was " + studentScore[i] + " grade is F");              
            }
        }
    }
}
