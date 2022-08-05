import java.util.HashMap;
import java.util.Set;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private HashMap<String, Item> items;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        items = new HashMap<String, Item>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west, Room up, Room down) 
    {
        if(north != null)
            exits.put("north", north);
        if(east != null)
            exits.put("east", east);
        if(south != null)
            exits.put("south", south);
        if(west != null)
            exits.put("west", west);
        if(up != null)
            exits.put("up", up);
        if(down != null)
            exits.put("down", down);
    }

    public void setExit(String direction, Room neighbour)
    {
        exits.put(direction, neighbour);
    }

    public Room getExits(String direction)
    {
        return exits.get(direction);
    }

    public String getExitString()
    {
        StringBuilder aStringBuilder = new StringBuilder();
        aStringBuilder.append("Exits:");
        //keySet returns a Set view of the map
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            aStringBuilder.append(" ").append(exit);
        }
        return aStringBuilder.toString();
    }

    /**
     * @return The description of the room.
     */
    public String getRoomDescription()
    {
        return description;
    }

    public String getLongRoomDescription()
    {
        return "You are bunny hopping through " + description + ".\nYou can continue hopping to " + getExitString();
    }

    public String getAllItemNames()
    {
        StringBuilder aStringBuilder = new StringBuilder();
        //keySet returns a Set view of the map
        Set<String> items = this.items.keySet();
        for(String item : items) {
            aStringBuilder.append(item.toString()).append(" ");
            
        }
        return aStringBuilder.toString();
    }

    public String getAllItemsString()
    {
        StringBuilder aStringBuilder = new StringBuilder();
        aStringBuilder.append("Items:");
        //keySet returns a Set view of the map
        Set<String> items = this.items.keySet();
        for(String item : items)
        {
               aStringBuilder.append(" ").append(item);
        }
        return aStringBuilder.toString();
    }

    public void addItem(String name, Item item)
    {
        items.put(name, item);
    }

    public Item getItem(String itemName)
    {
        return items.get(itemName);
    }
}
