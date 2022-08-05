
/**
 * Write a description of class Table here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Table
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Table
     */
    public Table()
    {
        // initialise instance variables

    }

    /**
     * Ask for input, print a table based on input.
     * 
     * @param  x   how many Rows
     * @param  y   how many Columns 
     */
    public void printTable(int x, int y)
    {
        for (int i = 1; i <= x; i++)
        {
            for (int j = 1; j <= y; j++)
            {
                // must print on same line to create the row effect
                System.out.print("Row " + i + " & Column " + j + " | ");
            }
            //adding a newline once the inner loop is finished moves us to the next row
            System.out.println();
        }
    }
    
        public void printTimesTable()
    {
        final int ROW = 10;
        final int COL = 10;
        for (int i = 1; i <= ROW; i++)
        {
            for (int j = 1; j <= COL; j++)
            {
                // must print on same line to create the row effect
                System.out.print((i * j) + " ");
            }
            //adding a newline once the inner loop is finished moves us to the next row
            System.out.println();
        }
     }
}
