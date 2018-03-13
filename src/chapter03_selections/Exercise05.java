package chapter03_selections;

import java.util.Scanner;

/**
 * <h1>Future Day Calculator</h1>
 * <p>
 * This program ask for a number representing today and for a number representing days into the future. It will return the text representation of both.
 * </p>
 * <p>
 * tags:	String printing; math; Scanner; nextInt;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-03-13
 */
public class Exercise05
{
	private static final String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

	public static void main(String[] args)
	{
		//create Scanner object
		Scanner keyboard = new Scanner(System.in);

		//create variables
/*        final String DAY0 = "Sunday";
        final String DAY1 = "Monday";
        final String DAY2 = "Tuesday";
        final String DAY3 = "Wednesday";
        final String DAY4 = "Thursday";
        final String DAY5 = "Friday";
        final String DAY6 = "Saturday";*/

		//get user input
		System.out.print("Enter today's number (Sun = 0 & Saturday = 6): ");
		int currentDay = keyboard.nextInt();
		System.out.print("Enter the number of days elapsed since today: ");
		int daysElapsed = keyboard.nextInt();

		//calculation
		/*
		 * Add the starting day number with the days elapsed number to get the total
		 * Modulo this by 7 (7 days in a week) to return the remainder, which is
		 * the number for the day of the week in the future.
		 */
		int newDay = (currentDay + daysElapsed) % 7;

		//display results
		printMessage(currentDay, newDay);
/*        switch (currentDay)
        {
            case 0: 
                if (newDay == 0)
                {
                    System.out.println("Today is " + DAY0 + " and the future day"
                            + " is " + DAY0);
                    break;
                }
                else if (newDay == 1)
                {
                    System.out.println("Today is " + DAY0 + " and the future day"
                            + " is " + DAY1);
                    break;
                }
                else if (newDay == 2)
                {
                    System.out.println("Today is " + DAY0 + " and the future day"
                            + " is " + DAY2);
                    break;
                }     
                else if (newDay == 3)
                {
                    System.out.println("Today is " + DAY0 + " and the future day"
                            + " is " + DAY3);
                    break;
                } 
                else if (newDay == 4)
                {
                    System.out.println("Today is " + DAY0 + " and the future day"
                            + " is " + DAY4);
                    break;
                } 
                else if (newDay == 5)
                {
                    System.out.println("Today is " + DAY0 + " and the future day"
                            + " is " + DAY5);
                    break;
                } 
                else if (newDay == 6)
                {
                    System.out.println("Today is " + DAY0 + " and the future day"
                            + " is " + DAY6);
                    break;
                } 
            
            case 1: 
                if (newDay == 1)
                {
                    System.out.println("Today is " + DAY1 + " and the future day"
                            + " is " + DAY0);
                    break;
                }
                else if (newDay == 1)
                {
                    System.out.println("Today is " + DAY1 + " and the future day"
                            + " is " + DAY1);
                    break;
                }
                else if (newDay == 2)
                {
                    System.out.println("Today is " + DAY1 + " and the future day"
                            + " is " + DAY2);
                    break;
                }     
                else if (newDay == 3)
                {
                    System.out.println("Today is " + DAY1 + " and the future day"
                            + " is " + DAY3);
                    break;
                } 
                else if (newDay == 4)
                {
                    System.out.println("Today is " + DAY1 + " and the future day"
                            + " is " + DAY4);
                    break;
                } 
                else if (newDay == 5)
                {
                    System.out.println("Today is " + DAY1 + " and the future day"
                            + " is " + DAY5);
                    break;
                } 
                else if (newDay == 6)
                {
                    System.out.println("Today is " + DAY1 + " and the future day"
                            + " is " + DAY6);
                    break;
                } 
            
            case 2:
                if (newDay == 2)
                {
                    System.out.println("Today is " + DAY2 + " and the future day"
                            + " is " + DAY0);
                    break;
                }
                else if (newDay == 1)
                {
                    System.out.println("Today is " + DAY2 + " and the future day"
                            + " is " + DAY1);
                    break;
                }
                else if (newDay == 2)
                {
                    System.out.println("Today is " + DAY2 + " and the future day"
                            + " is " + DAY2);
                    break;
                }     
                else if (newDay == 3)
                {
                    System.out.println("Today is " + DAY2 + " and the future day"
                            + " is " + DAY3);
                    break;
                } 
                else if (newDay == 4)
                {
                    System.out.println("Today is " + DAY2 + " and the future day"
                            + " is " + DAY4);
                    break;
                } 
                else if (newDay == 5)
                {
                    System.out.println("Today is " + DAY2 + " and the future day"
                            + " is " + DAY5);
                    break;
                } 
                else if (newDay == 6)
                {
                    System.out.println("Today is " + DAY2 + " and the future day"
                            + " is " + DAY6);
                    break;
                } 
            
            case 3:
                if (newDay == 3)
                {
                    System.out.println("Today is " + DAY3 + " and the future day"
                            + " is " + DAY0);
                    break;
                }
                else if (newDay == 1)
                {
                    System.out.println("Today is " + DAY3 + " and the future day"
                            + " is " + DAY1);
                    break;
                }
                else if (newDay == 2)
                {
                    System.out.println("Today is " + DAY3 + " and the future day"
                            + " is " + DAY2);
                    break;
                }     
                else if (newDay == 3)
                {
                    System.out.println("Today is " + DAY3 + " and the future day"
                            + " is " + DAY3);
                    break;
                } 
                else if (newDay == 4)
                {
                    System.out.println("Today is " + DAY3 + " and the future day"
                            + " is " + DAY4);
                    break;
                } 
                else if (newDay == 5)
                {
                    System.out.println("Today is " + DAY3 + " and the future day"
                            + " is " + DAY5);
                    break;
                } 
                else if (newDay == 6)
                {
                    System.out.println("Today is " + DAY3 + " and the future day"
                            + " is " + DAY6);
                    break;
                }     
            
            case 4:
              
                if (newDay == 4)
                {
                    System.out.println("Today is " + DAY4 + " and the future day"
                            + " is " + DAY0);
                    break;
                }
                else if (newDay == 1)
                {
                    System.out.println("Today is " + DAY4 + " and the future day"
                            + " is " + DAY1);
                    break;
                }
                else if (newDay == 2)
                {
                    System.out.println("Today is " + DAY4 + " and the future day"
                            + " is " + DAY2);
                    break;
                }     
                else if (newDay == 3)
                {
                    System.out.println("Today is " + DAY4 + " and the future day"
                            + " is " + DAY3);
                    break;
                } 
                else if (newDay == 4)
                {
                    System.out.println("Today is " + DAY4 + " and the future day"
                            + " is " + DAY4);
                    break;
                } 
                else if (newDay == 5)
                {
                    System.out.println("Today is " + DAY4 + " and the future day"
                            + " is " + DAY5);
                    break;
                } 
                else if (newDay == 6)
                {
                    System.out.println("Today is " + DAY4 + " and the future day"
                            + " is " + DAY6);
                    break;
                }     
            
            case 5:
                
                if (newDay == 5)
                {
                    System.out.println("Today is " + DAY5 + " and the future day"
                            + " is " + DAY0);
                    break;
                }
                else if (newDay == 1)
                {
                    System.out.println("Today is " + DAY5 + " and the future day"
                            + " is " + DAY1);
                    break;
                }
                else if (newDay == 2)
                {
                    System.out.println("Today is " + DAY5 + " and the future day"
                            + " is " + DAY2);
                    break;
                }     
                else if (newDay == 3)
                {
                    System.out.println("Today is " + DAY5 + " and the future day"
                            + " is " + DAY3);
                    break;
                } 
                else if (newDay == 4)
                {
                    System.out.println("Today is " + DAY5 + " and the future day"
                            + " is " + DAY4);
                    break;
                } 
                else if (newDay == 5)
                {
                    System.out.println("Today is " + DAY5 + " and the future day"
                            + " is " + DAY5);
                    break;
                } 
                else if (newDay == 6)
                {
                    System.out.println("Today is " + DAY5 + " and the future day"
                            + " is " + DAY6);
                    break;
                } 
            case 6:
                if (newDay == 6)
                {
                    System.out.println("Today is " + DAY6 + " and the future day"
                            + " is " + DAY0);
                    break;
                }
                else if (newDay == 1)
                {
                    System.out.println("Today is " + DAY6 + " and the future day"
                            + " is " + DAY1);
                    break;
                }
                else if (newDay == 2)
                {
                    System.out.println("Today is " + DAY6 + " and the future day"
                            + " is " + DAY2);
                    break;
                }     
                else if (newDay == 3)
                {
                    System.out.println("Today is " + DAY6 + " and the future day"
                            + " is " + DAY3);
                    break;
                } 
                else if (newDay == 4)
                {
                    System.out.println("Today is " + DAY6 + " and the future day"
                            + " is " + DAY4);
                    break;
                } 
                else if (newDay == 5)
                {
                    System.out.println("Today is " + DAY6 + " and the future day"
                            + " is " + DAY5);
                    break;
                } 
                else if (newDay == 6)
                {
                    System.out.println("Today is " + DAY6 + " and the future day"
                            + " is " + DAY6);
                    break;
                } 
            
            default: System.out.println("Error: invalid number");
            System.exit(1);
        }*/
	}

	private static void printMessage(int currentDay, int newDay)
	{
		System.out.println("Today is " + days[currentDay] + " and the future day" + " is " + days[newDay]);

	}
}
