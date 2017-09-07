/**
 * 
 */
package chapter07;

/**
 * @author:		blindcant
 * @version:	0.1
 * @date:		10 Apr 2017
 * @program:	
 */
public class BinarySearch
{
    public static void main(String[] args)
    {
        // Math.random generates a random number between 0.0 and 1.0, but not 1.0
        // Cast that number to an int and times by 100, this makes the number
        //between 0 and 100, but never 101
        int MAX_NUMBER = 101;
        final int NUMBER_TO_FIND = (int) (Math.random()*MAX_NUMBER);
        
        //set out min and max
        int min = 0;
        int max = 100;
        
        //create our start number
        int searchNumber = (min + max) / 2;
        
        // search condition
        boolean done  = false;
        
        
        System.out.println("Starting binary search for a number between 0 and 100");
        System.out.println(NUMBER_TO_FIND);
        
        while (!done)
        {
            if (searchNumber == NUMBER_TO_FIND)
            {
                System.out.println("Found: " + NUMBER_TO_FIND);
                done = true;
            }
            else if (searchNumber > NUMBER_TO_FIND)
            {
                max = searchNumber; 
                searchNumber = (min + max) / 2;
            }
            else if (searchNumber < NUMBER_TO_FIND)
            {
                min = searchNumber; 
                searchNumber = (min + max) / 2;              
            }
        }
    }
}
