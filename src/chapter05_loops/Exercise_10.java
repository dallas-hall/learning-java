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
public class Exercise_10
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        // int startNumber = 100;
        final int PRINTS_PER_LINE = 10;
        int count = 0;

        for (int i = 100; i <= 1000; i++)
        {
            if (i % 5 == 0 || i % 6 == 0)
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
