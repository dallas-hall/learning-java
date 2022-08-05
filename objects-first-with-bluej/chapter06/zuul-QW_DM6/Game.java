import java.util.List;
import java.util.ArrayList;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room previousRoom;
    //private List<Player> players = new ArrayList<>(8);
    private Player p1;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createMap();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createMap()
    {
        Room raRoom, lgRoom, rlRoom, gaRoom, glRoom, middleRoom;

        // create the rooms
        raRoom = new Room("red armour room");
        middleRoom = new Room("middle room");
        lgRoom  = new Room("lightning gun room");
        rlRoom  = new Room("rocket launcher room");
        gaRoom  = new Room("green armour room");
        glRoom  = new Room("grenade launcher room");

        // initialise room exits North/East/South/West/Up/Down
        raRoom.setExits(null, glRoom , lgRoom , lgRoom , null, null);
        lgRoom.setExits(null , null , null , null , middleRoom , null);
        middleRoom.setExits(raRoom , gaRoom , gaRoom , raRoom , rlRoom , null);
        rlRoom.setExits(null, null, null, gaRoom , null, lgRoom );
        gaRoom.setExits(lgRoom, null, rlRoom , null, glRoom , null);
        glRoom.setExits(raRoom, null, gaRoom , null, null, lgRoom );

        // create spawns
        Room[] spawns = {raRoom, rlRoom, glRoom, gaRoom};
      
        //create items
        Item[] items = createItems();

        //add items to rooms
        gaRoom.addItem("ga", items[1]);
        gaRoom.addItem("rl", items[2]);

        lgRoom.addItem("lg", items[4]);
        lgRoom.addItem("ring", items[5]);

        raRoom.addItem("ra", items[0]);
        raRoom.addItem("rl", items[2]);

        rlRoom.addItem("rl", items[2]);
        rlRoom.addItem("mega", items[5]);

        glRoom.addItem("gl", items[3]);
        
        //create players
        int prn = (int) Math.random() * 4;
        currentRoom = spawns[prn];
        p1 = new Player("dhall", currentRoom);
        //players.add(p1);
    }

    private Item[] createItems()
    {
        //create items
        Item ra, ga, rl, lg, gl, mega, ring, quad, pent;

        // initialise room items
        ra = new Item("ra", "Red Armour - 200", 200);
        ga = new Item("ga", "Green Armour - 100", 100);
        rl = new Item("rl", "Rocket Launcher", 1);
        gl = new Item("gl", "Grenade Launcher", 1);
        lg = new Item("lg", "Lightning Gun", 1);
        mega = new Item("mega", "Mega Health", 100);
        quad = new Item("quad", "Quad Damage", 1);
        ring = new Item("ring", "Ring Of Invisibility", 1);
        pent = new Item("pent", "Pentagram Of Invulnerability", 1);

        Item[] items = {ra, ga, rl, gl, lg, mega, ring};
        return items;
    }

    private void addItemToRoom(Room room, Item item)
    {
        room.addItem(item.toString(), item);
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for riding my rocket.  Get gibbed!");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to text QuakeWorld");
        System.out.println("This game is pretty shit.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("da fuck you talkin bout?");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go") || commandWord.equals("back")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("look")) {
            lookAroundRoom();
        }   
        else if (commandWord.equals("take")) {
            takeRoomItem(command);
        }
         else if (commandWord.equals("items")) {
            takeRoomItem(command);
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You have respawned.  You are lost. You are alone. You need a fucking RL");
        System.out.println("Time to fucking fly around DM6.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(parser.getCommands());
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord() && !command.getCommandWord().equals("back"))
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Speed jump where?");
            return;
        }

        // Try to leave current room.
        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExits(direction);

        if (nextRoom == null && !command.getCommandWord().equals("back")) {
            System.out.println("In that direction there is only a gl_picmaped wall.  Look around son.");
        }
        else {
            if (command.getCommandWord().equals("back") && previousRoom == null)
            {
                System.out.println("Can't go back haven't hopped anywhere yet...");
                return;
            }
            else if (command.getCommandWord().equals("back") && previousRoom != null)
            {
                Room tmp = currentRoom;
                currentRoom = previousRoom;
                previousRoom = tmp;
                printLocation();              
            }
            else
            {
                previousRoom = currentRoom;
                currentRoom = nextRoom;
                printLocation();    
            }
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    private void lookAroundRoom()
    {
        printLocation();
    }

    private void takeRoomItem(Command command)
    {
        if(!command.hasSecondWord())
        {
            // if there is no second word, we don't know what to take...
            System.out.println("Take what, bro?");
            return;
        }

        String[] itemNames = currentRoom.getAllItemNames().split(" |$");
        System.out.println(command.getSecondWord());
        System.out.println(currentRoom.getAllItemNames());
        //System.out.println(Arrays.toString(itemNames));
        for (String anItemName : itemNames)
        {
            System.out.println(anItemName);
            if (command.getSecondWord().matches(anItemName))
            {
                Item anItem = currentRoom.getItem(anItemName);
                p1.takeItem(anItem);
                System.out.println("You took some shit before the other guy.  Fuck that guy.");
                return;
            }
        }

        // if we don't match the second word, we don't know what to take...
        System.out.println("No items of that name found.  Have a look around.");
        return;
    }

    private void printLocation()
    {
        System.out.println("You are speed jumping through the " + currentRoom.getRoomDescription());
        System.out.println("You can take some shit like... " + currentRoom.getAllItemsString());
        System.out.println("You can bunny hop in the direction of... " + currentRoom.getExitString());
        System.out.println();
    }
}
