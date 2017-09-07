/**
 * 
 */
package chapter05;

/**
 * @author:		Dallas Hall
 * @version:	0.1
 * @date:		8 Apr 2017
 * @program:    Print Chars Table
 */
public class Exercise_15
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        final int PRINTS_PER_LINE = 10;
        int count = 0;
        
        for (int i = 32; i < 256; i++)
        {
            if (count < 10)
                {
                System.out.print((char)i + " ");
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
