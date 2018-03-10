/**
 * <h1>Addition Challenge</h1>
 * <p>
 * This program will produce 3 random numbers and challenge the user to add them together correctly.
 * </p>
 * <p>
 * tags:	String printing; math; Scanner; nextInt;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-03-13
 */
package chapter03_selections;

import java.util.Scanner;

public class Exercise02
{
    public static void main(String[] args)
    {
        // Generate 3 random numbers
        int number1 = (int) (System.currentTimeMillis() % 10);
        int number2 = (int) (System.currentTimeMillis() / 7 % 10);
        int number3 = (int) (System.currentTimeMillis() % 8);

        // Create a Scanner
        Scanner input = new Scanner(System.in);

        System.out.print("What is " + number1 + " + " + number2 + " + " + 
        number3 + "? ");

        int answer = input.nextInt();

        System.out.println(number1 + " + " + number2 + " + " + number3 
                + " = " + answer + " is "
                + (number1 + number2 + number3 == answer));
    }
}