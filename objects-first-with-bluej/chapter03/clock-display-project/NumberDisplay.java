
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
         * The new values is modulod with limit, if value and limit are the same it will equal 0 and that is assigned,
         * If they are not the same, value + 1 will be assigned.
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
       value = (value + 1) % limit;
    }
}
