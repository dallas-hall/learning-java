/**
 * 
 */
package chapter05;

import java.util.Scanner;

/**
 * @author: Dallas Hall
 * @version: 0.1
 * @date: 8 Apr 2017
 * @program:
 */
public class Exercise_17
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

        //initial number of stars to print
        int stars = 1;

        //get input to determine how many lines to print of stars
        System.out.println("Enter a number:");
        Scanner keyboard = new Scanner(System.in);
        int input = Integer.parseInt(keyboard.nextLine());
        
        //work out spaces, whatever number is entered, minus that by one and that is how many we need
        int spaces = input - 1;
        
        for (int row = 1; row <= input; row++)
        {
            //print spaces
            for (int space = 1; space <= spaces; space++)
                System.out.print(" ");

            //print numbers
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
