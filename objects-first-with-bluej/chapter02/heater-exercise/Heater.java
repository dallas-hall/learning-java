/**
 * Simulates a Heater.
 * 
 * @author (Dallas) 
 * @version (12/04/12)
 */
public class Heater
{
    private double temperature;   
    private double min;
    private double max;
    private double increment;

    public Heater(double heaterMin, double heaterMax)
    {
      temperature = 15.0;
      increment = 5.0;
      min = heaterMin;
      max = heaterMax;
      
    }

    public void setIncrement(double newIncrement)
    {
        if (newIncrement <= 0) {
            System.out.println("Please enter a number larger then 0");
        }
        else {
            increment = newIncrement;
        }
    }
    
    public double heaterWarmer()
    {
        if (temperature + increment < max) {
            temperature = temperature + increment;
        }
        else {
            System.out.println("The maximum of" + max + " has been reached.");
        }
        return increment;
    }
    
    public void heaterColder()
    {
        if (temperature - increment > min) {
            temperature = temperature - increment;
        }
        else {
            System.out.println("The minimum of " + min + " has been reached.");
        }
    }
    
    public double currentTemp()
    {
        return temperature;
    }
}
