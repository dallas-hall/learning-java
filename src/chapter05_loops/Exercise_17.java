package chapter05_loops;

import java.util.Scanner;

/**
 * <h1>>Triangle Printing</h1>
 * <p>
 * This program will accept an integer and use that to print a series of stars, starting at 1, and adding 2 to each line. It will stop printing at the number entered.
 * </p>
 * <p>
 * tags: for loop; if else;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-08
 */
public class Exercise_17
{
    public static void main(String[] args)
    {
        //get input to determine how many lines to print of stars
        System.out.println("Enter a number:");
        Scanner keyboard = new Scanner(System.in);
        int input = Integer.parseInt(keyboard.nextLine());
    
        //initial number of stars to print
        int stars = 1;
        
        //work out spaces, whatever number is entered, minus that by one and that is how many we need
        int spaces = input - 1;
        
        for (int row = 1; row <= input; row++)
        {
            //print spaces
            for (int space = 1; space <= spaces; space++)
                System.out.print(" ");

            //print characters
            for (int star = 1; star <= stars; star++)
                System.out.print("*");
            
            //goto next row
            System.out.println();
            
            //for each new line we need one less space
            spaces--;
            
            //for each new line we need two more stars
            stars += 2; 
         }
    }
}
