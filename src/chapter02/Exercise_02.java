/**
 * 
 */
package chapter02;

import java.util.Scanner;

/**
 * @author:		blindcant
 * @version:	0.1
 * @date:		13 Mar 2017
 * @program:	
 */
public class Exercise_02
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        //create variables
        double PI = Math.PI;
        
        //create Scanner object
        Scanner keyboard = new Scanner(System.in);
        
        //ask user for inputs
        System.out.print("Enter the radius: ");
        double radius = keyboard.nextDouble();
        System.out.print("Enter the length: ");
        double length = keyboard.nextDouble();
        
        //do calculations
        double area = radius * radius * PI;
        double volume = area * length;
        
        //Display answers
        System.out.printf("The area is:\t%.4f", area);
        System.out.printf("%nThe volume is:\t%.1f", volume);
    }
}
