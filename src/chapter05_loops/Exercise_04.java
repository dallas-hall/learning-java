/**
 * 
 */
package chapter05_loops;

/**
 * @author: Dallas Hall
 * @version: 0.1
 * @date: 1 Apr 2017
 * @program:
 */

public class Exercise_04
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        final double CONVERT_MILES_TO_KM = 1.609;

        System.out.printf("%-15s", "Miles");
        System.out.printf("%-15s%n", "Kilometers");
        
        for (int i = 1; i <= 10; i++)
        {
            System.out.printf("%-15d", i);
            System.out.printf("%-12.3f%n", i * CONVERT_MILES_TO_KM);
        }
    }
}
