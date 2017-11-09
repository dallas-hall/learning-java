/**
 * 
 */
package chapter07_1d_arrays;

import java.util.Scanner;

/**
 * @author: blindcant
 * @version: 0.1
 * @date: 17 Apr 2017
 * @program:
 */
public class Question01
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
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
