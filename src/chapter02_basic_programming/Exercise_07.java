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
public class Exercise_07
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        //create final variable
        final int DAYS_IN_YEAR = 365;
        final int MINUTES_IN_DAY = 60 * 24;
        
        //create Scanner object
        Scanner keyboard = new Scanner(System.in);
        
        //get user input
        System.out.print("Enter the number of minutes: ");
        long minutes = keyboard.nextLong();
                
        //calculations
        /*
         * @Total Years
         * 
         * convert minutes to days by dividing minutes total by minutes in a day
         * convert days to years by dividing days total by days in a year
         * 
         * @Days Left Outside Of Total Years
         * 
         * calculate remaining days (that are less than 365) by using modulo
         * days % DAYS_IN_YEAR
         * 
         */
        long days = minutes / MINUTES_IN_DAY;
        long years = days / DAYS_IN_YEAR;
        long days_less_than_year = days % DAYS_IN_YEAR;
        
        
        //display answer
        System.out.println(minutes + " minutes is approximately " + years + 
                " years & " + days_less_than_year + " days.");
    }

}
