package chapter05_loops;

/**
 * <h1>>Number Printing</h1>
 * <p>
 * This program will print all numbers between 0 and 1000 that are divisible by 5 or not 6.
 * </p>
 * <p>
 * tags: for loop; if else;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-01
 */
public class Exercise_11
{
    public static void main(String[] args)
    {
        // int startNumber = 100;
        final int PRINTS_PER_LINE = 10;
        int count = 0;

        // while (startNumber <= 200)
        // {
        // if (startNumber % 5 == 0 && startNumber % 6 != 0)
        // {
        // System.out.print(startNumber + " ");
        // count++;
        // }
        // else if (startNumber % 5 != 0 && startNumber % 6 == 0)
        // {
        // System.out.print(startNumber + " ");
        // count++;
        // }
        // startNumber++;
        // if (count % NUMBER_PER_LINE == 0)
        // {
        // System.out.println();
        // }
        for (int i = 100; i <= 1000; i++)
        {
            if (i % 5 == 0 && i % 6 != 0)
            {
                System.out.print(i + " ");
                count++;
            }
            else if (i % 5 != 0 && i % 6 == 0)
            {
                System.out.print(i + " ");
                count++;
            }
            else
            {
                continue; //need continue so we skip out of iterations that aren't divisible by 5 or 6
            }
            if (count % PRINTS_PER_LINE == 0)
            {
                System.out.println();
            }
        }
    }
}
