import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private String name = null;
    private int kills = 0;
    private int deaths = 0;
    //0 = current, 1 = previous
    private Room[] rooms = new Room[2];
    private List<Item> currentItems = new ArrayList<>(); 

    /**
     * Constructor for objects of class Player
     */
    public Player(String name, Room currentRoom)
    {
        this.name = name;
        rooms[0] = currentRoom;
    }
    
    public void takeItem(Item item)
    {
        currentItems.add(item);
    }
    
    public String getName()
    {
        return name;
    }
    
    public Room getCurrentRoom()
    {
        return rooms[0];
    }
    
    public Room getPreviousRoom()
    {
        return rooms[1];
    }
    
    public int getKills()
    {
        return kills;
    }
    
    public int getDeaths()
    {
        return deaths;
    }
    
    public String getCurrentItemNames()
    {
        StringBuilder aStringBuilder = new StringBuilder();
        for (Item anItem : currentItems)
        {
            aStringBuilder.append(anItem.getItemName()).append(" ");
        }
        return aStringBuilder.toString();
    }
    
    public void addOneKill()
    {
        kills++;
    }
    
    public void addOneDeath()
    {
        deaths++;
    }
    
    public String toString()
    {
        StringBuilder aStringBuilder = new StringBuilder();
        aStringBuilder.append("Name: ").append(getName());
        aStringBuilder.append(".\nCurrent kills: ").append(getKills());
        aStringBuilder.append(".\nCurrent deaths: ").append(getDeaths());
        aStringBuilder.append(".\nCurrent room: ").append(getCurrentRoom());
        aStringBuilder.append(".\nCurrent items: ").append(getCurrentRoom());
        return aStringBuilder.toString();
    }
}
