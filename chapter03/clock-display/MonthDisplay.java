
/**
 * Write a description of class MonthDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MonthDisplay
{
    // instance variables
    private NumberDisplay day;
    private NumberDisplay month;
    private NumberDisplay year;
    private String displayString;    // simulates the actual display

    /**
     * Constructor for objects of class MonthDisplay
     */
    public MonthDisplay()
    {
        // initialise instance variables
        day = new NumberDisplay(32); //create a new NumberDisplay object with a limit of 32
        month = new NumberDisplay(13);
        year = new NumberDisplay(3000);
        day.setValue(1);
        month.setValue(1);
        year.setValue(1999);
        updateDisplay();
    }

    public void timeTick()
    {
        day.incrementHours(); //external method call, ignore name, reusing clock method.
        /*
        need if logic otherwise 13 resets to 0 because 12 + 1 % 13 = 0
        if (value + 1 == limit) {
            value = limit % value; //need to reverse here so it becomes 13 % 12 leaving 1 remainder
        }
        else {
            value = (value + 1) % limit;
        }
         */
        if(day.getValue() == 1) {  // it just rolled over!
            month.incrementHours();
            if (month.getValue() == 1) { //it just rolled over, days = 31 so limit = 32 for modulo
                day.updateLimit(32);
                year.incrementHours();
            }
            else if (month.getValue() == 2) { //days = 28 so limit = 29 for modulo
                day.updateLimit(29);            
            }            
            else if (month.getValue() == 4 || month.getValue() == 6 || month.getValue() == 9 || month.getValue() == 11) { //days = 30 so limit = 31 for modulo
                day.updateLimit(31);
            }

            else { //days = 31 so limit = 32 for modulo
                day.updateLimit(32);            
            }
        }

        updateDisplay();
    }
    
    private void updateDisplay() 
    { 
         displayString = "day: " + day.getDisplayValue() + " month: " +  month.getDisplayValue() +
                         " year: " + year.getDisplayValue();
        
    }
    
    public void setTime(int newDay, int newMonth, int newYear)
    {
        day.setValue(newDay);
        month.setValue(newMonth);
        year.setValue(newYear);
        updateDisplay();
    }    
}
