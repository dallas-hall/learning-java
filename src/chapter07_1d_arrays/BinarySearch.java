/**
 * 
 */
package chapter07_1d_arrays;

/**
 * <h1>Binary Searching</h1>
 * <p>
 * This program will attempt to perform binary searching.
 * </p>
 * <p>
 * tags:	binary searching; if-else; Math.random;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-04-10
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
        int attempts = 0;
        
        System.out.println("Starting binary search for a number between 0 and 100");
        System.out.println(NUMBER_TO_FIND);
        
        while (!done)
        {
            if (searchNumber == NUMBER_TO_FIND)
            {
                attempts++;
                System.out.println("Found: " + NUMBER_TO_FIND + " in " + attempts + " attempts.");
                done = true;
            }
            else if (searchNumber > NUMBER_TO_FIND)
            {
                max = searchNumber; 
                searchNumber = (min + max) / 2;
                attempts++;
            }
            else if (searchNumber < NUMBER_TO_FIND)
            {
                min = searchNumber; 
                searchNumber = (min + max) / 2;
                attempts++;
            }
        }
    }
}
