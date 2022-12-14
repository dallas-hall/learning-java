
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String suffix; //exercise 3.31, 2015 - holds am or pm
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        //original code for 24 hour time
        //hours = new NumberDisplay(24);
        
        //my code for 12 hour time 2015 - ex 3.31 - 3.32
        hours = new NumberDisplay(13); //needs to be 13 because we want to display 12
        minutes = new NumberDisplay(60);
        suffix = "am"; //exercise 3.32
        hours.setValue(12);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute, String suffixInput)
    {
        //original code for 24 hour time
        //hours = new NumberDisplay(24);
        
        //my code for 12 hour time 2015 - ex 3.31 - 3.32
        hours = new NumberDisplay(13);
        minutes = new NumberDisplay(60);
        suffix = suffixInput; //exercise 3.32
        setTime(hour, minute, suffix);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    //orginal code
    public void timeTick()
    {
        //minutes.increment();
        //if(minutes.getValue() == 0) {  // it just rolled over!
        //    hours.increment();
        //}
        //updateDisplay();
    //}
    //ex 3,32 - 2015
        minutes.incrementMinutes();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.incrementHours();
            suffixTick(); //update the suffix to am or pm
        }
        updateDisplay();
    } 
   
    //ex 3.32 - 2015
    public void suffixTick()
    {
        if ((hours.getValue() == 12 && minutes.getValue() == 0) && suffix == "pm") {
        suffix = "am";
        }
        else if ((hours.getValue() == 12 && minutes.getValue() == 0) && suffix == "am") {
        suffix = "pm";
        } 
    }
    
    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, String inputSuffix)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        suffix = inputSuffix; //ex 3,32
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    
    private void updateDisplay() 
    { 
        //Original code
        //displayString = hours.getDisplayValue() + ":" +  minutes.getDisplayValue();
                        
        /**my first code to add pm and am (uses 24 hour time) (from 2012) - works
         * int hour = hours.getValue(); 
         * String suffix = "am"; 
         * if(hour >= 12) { 
         *   hour = hour - 12;         suffix = "pm"; 
         * } 
         * if(hour == 0) { 
         *    hour = 12; 
         * } 
         * displayString = hour + ":" + minutes.getDisplayValue(); //+ suffix; 
         */
        
        //second attempt 2015 - actual 12 hour time
         displayString = hours.getDisplayValue() + ":" +  minutes.getDisplayValue() +
                         " " + suffix;
        
    }
}
