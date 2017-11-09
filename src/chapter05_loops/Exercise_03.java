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


public class Exercise_03
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        
        final double CONVERT_KG_TO_POUND = 2.2;
        
        // TODO Auto-generated method stub

        System.out.printf("%-15s", "Kilograms");
        System.out.printf("%-15s%n", "Pounds");
        for (int i = 1; i < 200; i++)
        {
            System.out.printf("%-15d", i);
            System.out.printf("%-13.1f%n", i * CONVERT_KG_TO_POUND);           
        }
        
        
    }

}
