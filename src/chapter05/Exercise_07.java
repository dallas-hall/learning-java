/**
 * 
 */
package chapter05;

/**
 * @author:		Dallas Hall
 * @version:	0.1
 * @date:		1 Apr 2017
 * @program:	
 */
public class Exercise_07
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int tuition = 10000;
        final double INCREASE = 1.05;

        
        System.out.println("Start is: " + tuition);
        for (int year = 1; year <= 10; year++)
        {
            tuition*=INCREASE;
            System.out.println("In year " + year + " tuition is now: " + tuition);
        }
        
        System.out.println("4 years of tuition @ 10th year price is: " + tuition * 4);
    }
}