/**
 * 
 */
package chapter05_loops;

/**
 * @author: Dallas Hall
 * @version: 0.1
 * @date: 8 Apr 2017
 * @program:
 */
public class Exercise_18
{

    /**
     * @param args
     */

    public static void main(String[] args)
    {
        System.out.println("Pattern A");

        // get into the habit of setting row (or i) to 0, good for collections
        // and using in nested loops
        for (int row = 0; row <= 5; row++)
        {
            for (int col = 1; col <= row; col++)
            {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Pattern B");
        System.out.println();



        int printAmount = 6;
        // go from 0 to 5, so 6 times
        // need to set row to 0 so we can use it later
        for (int row = 0; row < printAmount; row++)
        {
            // if we minus our printAmount by row, each time row is incremented
            // our printing goes down by one
            for (int col = 1; col <= 6 - row; col++)
            {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        
        System.out.println();
        System.out.println("Pattern C");
        System.out.println();
        // setup our spaces, this is amount of character printed - 1 ( 6 -1)
        int printSpaces = 11;
        int printNumber = 2;
        
        for (int row = 1; row <= 6; row++)
        {
            //print our spaces
            for (int currentSpace = 1; currentSpace <= printSpaces; currentSpace++)
            {
                System.out.print(" ");             
            }
            
            //print our numbers
            for (int column = 1; column <= row; column++)
            {
                System.out.print((printNumber - column) + " ");
            }
            
            // print our column
            System.out.println();
            
            // decrement printed spaces by 2, as we are printing 2 less spaces
            // each line and one more number
            printSpaces-=2;
            //incrment print number
            printNumber++;
        }
        
        System.out.println();
        System.out.println("Pattern D");
        System.out.println();
        
        //we don't need any on the first line
        printSpaces = 0;
        // printing control variables
        int rowPrintAmount = 6;
        int columnPrintAmount = 6;
        
        for (int row2 = 0; row2 < rowPrintAmount; row2++)
        {
            //print out our spaces
            for (int currentSpace = 1; currentSpace <= printSpaces; currentSpace++)
            {
                System.out.print(" ");             
            }               
            
            //print out the column
            for (int column2 = 1; column2 <= columnPrintAmount; column2++)
            {
                System.out.print(column2 + " ");                   
            }
            
            //print out the row
            System.out.println();
            
            //increment spaces by 2, because we want to print 2 more spaces each line
            printSpaces+=2;
            //decrement printAmount so we print 1 less number each line
            columnPrintAmount--;
        }
    }

}
