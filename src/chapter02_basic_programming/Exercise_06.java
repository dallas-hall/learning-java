/**
 * 
 */
package chapter02_basic_programming;

import java.util.Scanner;

/**
 * @author:		blindcant
 * @version:	0.1
 * @date:		13 Mar 2017
 * @program:	
 */
public class Exercise_06
{

    public static void main(String[] args)
    {
        //create Scanner object
        Scanner keyboard = new Scanner(System.in);
        
        //get user input
        System.out.print("Enter a whole number between 0 and 1000: ");
        int userNumber = keyboard.nextInt();
        
        //get the numbers using modulo and division
        
        /* return number @ 1s
        
        number % 10 returns the number in the 1s position
        
        */
        int firstNumber = userNumber % 10;
        System.out.println(firstNumber);
        
        /* return number @ 10s
        
        * number / 10 does moves the decimal to the left 1 place
        since it is integer division the fraction is truncated
        
        * modulo that number by 10, which gets the number in the 1s position
        which was the number originally in the 10s position
        
        */
        int secondNumber = (userNumber / 10) % 10;
        System.out.println(secondNumber);

        /* return the number @ 100s
         
         * number / 100 moves the decimal to the left 2 places
           since it is integer division the fraction is truncated
           
         * modulo that number by 10, which gives the number in the 1s position
           which was the number originally in the 100s position
         
         */
        int thirdNumber = (userNumber / 100 ) % 10;
        System.out.println(thirdNumber);

        /* return the number @ 1000s
        
         * number / 1000 moves the decimal to the left 3 places
           since it is integer division the fraction is truncated
           
         * modulo that number by 10, which gives the number in the 1s position
           which was the number originally in the 1000s position
         
         */
        int fourthNumber = (userNumber / 1000) % 10;
        System.out.println(fourthNumber);
        
        //sum them together
        int answer = firstNumber + secondNumber + thirdNumber + fourthNumber;
        
        //show answer
        System.out.println("The sum of the digits is: " + answer);
    }

}
