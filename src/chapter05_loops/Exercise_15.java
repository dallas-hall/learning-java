package chapter05_loops;

/**
 * <h1>>ASCII Printing</h1>
 * <p>
 * This program will print printable ASCII and extended ASCII characters.
 * </p>
 * <p>
 * tags: for loop; if else;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-08
 */
public class Exercise_15
{
    public static void main(String[] args)
    {
        int count = 0;
        
        for (int i = 32; i < 256; i++)
        {
            if (count < 10)
            {
                System.out.print((char) i + " ");
                count++;
            }
            else
            {
                System.out.println();
                count = 0;
            }
        }
    }
}
