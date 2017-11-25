
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String name;
    private String description;
    private int value;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description, int value)
    {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public String getItemName()
    {
        return name;
    }

    public int getItemDescription()
    {
        return value;
    }
    
    public int getItemValue()
    {
        return value;
    }
    
    public String getAllItemDetails()
    {
        StringBuilder aStringBuilder = new StringBuilder();
        aStringBuilder.append(name).append(" ").append(description).append(" ").append(value);
        return aStringBuilder.toString();
    }
}
