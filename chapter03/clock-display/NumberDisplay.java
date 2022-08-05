
/**
 * The NumberDisplay class represents a digital number display that can hold
 * values from zero to a given limit. The limit can be specified when creating
 * the display. The values range from zero (inclusive) to limit-1. If used,
 * for example, for the seconds on a digital clock, the limit would be 60, 
 * resulting in display values from 0 to 59. When incremented, the display 
 * automatically rolls over to zero when reaching the limit.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class NumberDisplay
{
    private int limit;
    private int value;

    /**
     * Constructor for objects of class NumberDisplay.
     * Set the limit at which the display rolls over.
     */
    
    //original code
    public NumberDisplay(int rollOverLimit)
    {
        limit = rollOverLimit;
        value = 0;
    }

    /**
     * Return the current value.
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Return the display value (that is, the current value as a two-digit
     * String. If the value is less than ten, it will be padded with a leading
     * zero).
     */
    public String getDisplayValue()
    {
        if(value < 10) {
            return "0" + value;
        }
        else {
            //converts int to string by concatenating an empty string to the int
            //return "" + value;
            return value + ""; 
        }
    }

    /**
     * Set the value of the display to the new specified value. If the new
     * value is less than zero or over the limit, do nothing.
     */
    public void setValue(int replacementValue)
    {
        if((replacementValue >= 0) && (replacementValue < limit)) {
            value = replacementValue;
        }
    }

    /**
     * Increment the display value by one, rolling over to zero if the
     * limit is reached.
     */
    public void increment()
    {
        //original increment code
        /** the current time (value, which could be for hours or minutes ) has one added to it.
         * 
         * The new values is modulo'd with limit, if value and limit are the same it will equal 0 and that is assigned,
         * If they are not the same, value + 1 will be assigned.
         *
         *** 2016 explanation ***
         *
         * Modulo is dividing an integer with another integer and giving an integer remainder.
         * 
         * Examples:
         * 
         * 1) 4 % 5 = 4 because 5 doesn't go into 4, so 4 is left over
         * 2) 5 % 5 = 0 because 5 goes into 5 once with 0 left over
         * 3) 6 % 5 = 1 because 5 goes into 6 once with 1 left over
         * 4) 6 % 5 = 2 because 5 goes into 7 once with 2 left over           
         * 
         */
        //original code
        value = (value + 1) % limit;
        
        //my code with if statement exercise 3.21 - 2015
        /**if (value == (limit - 1)) {
            value = 0;
        }
        else {
            value = (value + 1);
        }*/
    }
    
    /** the current time (value, which is for minutes ) has one added to it.
         * The new values is modulod with limit, if value and limit are the same it will equal 0 and that is assigned,
         * If they are not the same, value + 1 will be assigned.
         * 
         *** 2016 explanation ***
         * 
         * value = 0 to 59
         * limit = 60
         * 
         * So lets say value is 30
         * 
         * 30 + 1 = 31, 31 % 60 = 31 because 60 doesn't go into 31, so 31 is the remainder
         * 
         * So lets say value is 59
         * 
         * 59 + 1 = 60, 60 % 60 = 0 becayse 60 goes into 60 once and 0 is the remainder
         * 
         */
    //ex 3.32 - 2015
    public void incrementMinutes()
    {
        //my code without modulo
        /** o
         * 
         * if (value == (limit -1)) {
         *   value = 0;
        * }
        * else {
        *     value = (value + 1);
        * }
        */
        value = (value + 1) % limit;
    }
    
    /** the current time (value, which is for hours ) has one added to it.
         * The new values is modulod with limit, if value and limit are the same it will equal 0 and that is assigned,
         * If they are not the same, value + 1 will be assigned.
         * 
         *** 2016 explanation ***
         * 
         * value = 0 to 12
         * limit = 13
         * 
         * So lets say value is 7
         * 
         * 7 + 1 = 8, 8 % 12 = 8 because 12 doesn't go into 8, so 8 is the remainder
         * 
         * So lets say value is 11
         * 
         * 11 + 1 = 12, 12 % 12 = 0 becayse 12 goes into 12 once and 0 is the remainder
         * 
         */
    //ex 3.32 - 2015
    public void incrementHours()
    {
        //my code without modulo
        /** o
         * 
         * if (value == (limit -1)) {
         *   value = 0;
        * }
        * else {
        *     value = (value + 1);
        * }
        */
       // need if logic otherwise 12:59 resets to 0:00 because 12 + 1 % 13 = 0
       if (value + 1 == limit) {
           value = limit % value; //need to reverse here so it becomes 13 % 12 leaving 1 remainder
       }
       else {
           value = (value + 1) % limit;
       }
    }
    
    public void updateLimit(int inputValue) {
    
        if (inputValue != limit) {
            limit = inputValue;
        }
    }
}
