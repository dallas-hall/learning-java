import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * The responses can be completely random or contextual.
 * 
 * @author     Michael Kölling and David J. Barnes AND BLINDCUNTUS MAXIMUS
 * @version    0.2 (2017.06.15)
 */
public class Responder
{
    //pseudo random number generator
    private Random prng;
    private ArrayList<String> responses;
    private HashMap<String, String> responsesHashMap;
    private HashMap<String[], String> responsesHashMap2;
    private HashSet<String> words;
    private int arrayListIndex = 0;

    /**
     * The constructor creates & populates a new ArrayList to the random responses.
     * A HashMap is created & populated that holds context specific responses.
     * 
     */
    //exercise 5.21
    public Responder()
    {
        //prng = new Random();

        // Setup the ArrayList
        responses = new ArrayList<>();
        populateResponsesArrayList();

        // Setup the HashMap
        responsesHashMap = new HashMap<String, String>();
        populateResponsesHashMap();
        
        // Setup the HashMap with a String[] inside of it
        responsesHashMap2 = new HashMap<String[], String>();
        populateResponsesHashMap2();
    }

    /**
     * Generate a random response from an ArrayList.
     * @return A string that contains a random response from the ArrayList.
     */
    //exercise 5.21
    public String generateRandomResponseArrayList()
    {
        /* hard coded */
        //getResponseHardCoded();

        /* ArrayList */
        //int i = prng.nextInt(responses.size());
        int i = ThreadLocalRandom.current().nextInt(0, responses.size());
        return responses.get(i);
    }

    /**
     * Generate a hardcoded response, only 4 exist.  
     * @return A string that contains a response generated from a random number.
     */
    //exercise 5.17
    public String getResponseHardCoded()
    {
        //generate a random number between 0-3 inclusive, exclude 4
        int number = prng.nextInt(4);
        if (number == 0)
        {
            return "ye bra";
        }
        else if(number == 1)
        {
            return "na bra";
        }
        else
        {
            return "mmmmm dunno bra";  
        }

    }

    /**
     * Generate a random response from a small (6) Array.
     * @return A string from a predefined array.
     */
    //exercise 5.18
    public String getResponseArray()
    {
        String[] responses = {"yer bra", "na bra", "mmmm dunno bra", "fuck you bra", "woteva treva", "eat a dick"}; 
        //generate a random number between 0 and responses.length, which is 6.
        int number = prng.nextInt(responses.length);
        return responses[number];
    }

    /**
     * Populate the ArrayList with a variety of random non-contextual responses.
     */
    //exercise 5.21
    private void populateResponsesArrayList()
    {
        responses.add("Mate that sounds like bullshit, the fuck you on about?");
        responses.add("Might be time to upgrade to Windows XP, cunt.");
        responses.add("I think it is the old problem of \"Intel inside, idiot outside\".");
        responses.add("Just give me your PC, you sound like you have no fucking idea\n son.");
        responses.add("You need to press control and r, type in cmd and press enter.\nNow type format C: and press enter.");
        responses.add("Sounds like you need to download DBAN and run that over your\nhard drive.");
        responses.add("Is it plugged in?  Have you turned it on?");
        responses.add("Sounds like your firewall isn't working properly.  Make sure\nyou block all incoming and outgoing connections.");
        responses.add("Google \"wannacry\" and isntall that, that will fix everything.");
        responses.add("That is a classic PICNIC scenario.");
        responses.add("Hahahahahahahahahahahaha.  I am sorry, excuse me.\nHAHAHAHAHAHAHAHAHAH.");
    }

    /**
     * Generate a contextual response from the HashMap.  To do this, a temporary HashMap is 
     * created holding the user's input.  This HashMap is traversed and if any words from the
     * user's input is found in the resposnes HashMap, a 'contextual' response is returned.
     * If the response HashMap doesn't contain anything that the user said, then a random 
     * response is returned from the response ArrayList instead.
     * 
     * @return A string from the response HashMap that relates to something that the user said.
     */
    //Exercise 5.33
    public String getResponseHashMap(String searchValue)
    {
        //split the user input and store it into an array
        String[] userInput = searchValue.split("\\s+");

                //search the array for a matching word in our HashMap
        /*
        for (int i = 0; i < userInput.length; i++)
        {
        //remove all non alpha chars so we can match words only
        String response = responsesHashMap.get(userInput[i].replaceAll("[^A-Za-z]+", ""));
        if (response != null)
        {
        return response;
        }
        }
         */
        
        //create the HashSet object holding Strings and store the split up String in there
        words = new HashSet<String>();
        for (String word : userInput)
        {
            words.add(word);
        }

        //search the HashSet for a matching word in our HashMap
        for (String word : words)
        {
            String response = responsesHashMap.get(word.replaceAll("[^A-Za-z]+", ""));
            if (response != null)
            {
                return response;
            }
        }
        int prn = ThreadLocalRandom.current().nextInt(0, responses.size());
        while (prn == arrayListIndex)
        {
            prn = ThreadLocalRandom.current().nextInt(0, responses.size());
        }
        arrayListIndex = prn;
        return responses.get(arrayListIndex);
    }
    
    public String getResponseHashMap2(String searchValue)
    {
        //split the user input and store it into an array
        String[] userInput = searchValue.split("\\s+");

        //create the HashSet object holding Strings and store the split up String in there
        words = new HashSet<String>();
        for (String word : userInput)
        {
            words.add(word);
        }

        //search the HashSet for a matching word in our HashMap String array
        for (String word : words)
        {
            //remove all non-alphas from the current word
            String wordAlphasOnly = word.replaceAll("[^A-Za-z]+", "");
            
            //go through the HashMap one element at a time and grab the String array of keys
            for (String[] currentKeys : responsesHashMap2.keySet())
            {
                //go through the String array of keys
                for (int i = 0; i < currentKeys.length; i++)
                {
                    //store the current key
                    String currentKey = currentKeys[i].toString();
  
                    //check if the current key matches are cleansed word, if it does, return the value pair of the current key
                    if (currentKey.equals(wordAlphasOnly))
                    {
                        return responsesHashMap2.get(currentKeys);
                    }
                }
            }
        }
        
        //if no matches are found, generate a random number between 0 and the ArrayList size
        int prn = ThreadLocalRandom.current().nextInt(0, responses.size());
        
        //check that we haven't already return the same random response
        while (prn == arrayListIndex)
        {
            prn = ThreadLocalRandom.current().nextInt(0, responses.size());
        }
        
        //store the response to be returned and return it
        arrayListIndex = prn;
        return responses.get(arrayListIndex);
    }
    
    /**
     * Populating the responses HashMap.
     */
    private void populateResponsesHashMap()
    {
        responsesHashMap.put("slow",
            "Sounds like you need to upgrade your computer.  What are you specs?");
        responsesHashMap.put("windows",
            "Better talk to Microsoft about that, sounds like a Windows problem.");
        responsesHashMap.put("expensive",
            "Get a better job you bum.");
        responsesHashMap.put("crash",
            "How much memory do you have?  Might not be enough.");
        responsesHashMap.put("crashes",
            "How much memory do you have?  Might not be enough.");
        responsesHashMap.put("crashed",
            "How much memory do you have?  Might not be enough.");   
        responsesHashMap.put("cpu",
            "M8 dat is too fucking old n slow.  Get moar corez.");
        responsesHashMap.put("processor",
            "M8 dat is too fucking old n slow.  Get moar corez.");
        responsesHashMap.put("ram",
            "That is no where near enough memory for our application.  Get moar.");
        responsesHashMap.put("memory",
            "That is no where near enough memory for our application.  Get moar.");
        responsesHashMap.put("space",
            "I don't think you have enough space for our application, we can sell you some more to be sure.");       
        responsesHashMap.put("internet",
            "Can't help you there, complain to Telstra about that one.");
        responsesHashMap.put("unhelpful",
            "I am just following my script.");
        responsesHashMap.put("rude",
            "Frankly I just don't give a fuck about your problem.");  
        responsesHashMap.put("laughing",
            "You have to admit, it is pretty fucking funny!");
        responsesHashMap.put("complain",
            "Honestly, no one else gives a shit either..."); 
        responsesHashMap.put("thanks",
            "No fucking worries tiger.  Now fuck off by typing bye.");
        responsesHashMap.put("gigabyte",
            "Gigabytes are tiny, get a Terabyte."); 
        responsesHashMap.put("terabyte",
            "Terabytes are tiny, get a Petabyte.");
        responsesHashMap.put("gigabytes",
            "Gigabytes are tiny, get a Terabyte."); 
        responsesHashMap.put("terabytes",
            "Terabytes are tiny, get a Petabyte.");
        responsesHashMap.put("gb",
            "Gigabytes are tiny, get a Terabyte."); 
        responsesHashMap.put("tb",
            "Terabytes are tiny, get a Petabyte."); 
        responsesHashMap.put("picnic",
            "It is a chocolate bar you fucking goose...");             
        responsesHashMap.put("microsoft",
            "Becasue their OS is a piece of shit so go talk to them, that is the porblem.");    
    }
    
    /**
     * Populating the responses HashMap.
     */
    private void populateResponsesHashMap2()
    {
        responsesHashMap2.put(new String[] {"slow", "long time"}, 
            "Sounds like you need to upgrade your computer.  What are you specs?");
        responsesHashMap2.put(new String[] {"windows", "win"},
            "Better talk to Microsoft about that, sounds like a Windows problem.");
        responsesHashMap2.put(new String[] {"crash", "crashed", "crashing", "crashes", "unresponsive"},
            "How much memory do you have?  Might not have enough champ.");
        responsesHashMap2.put(new String[] {"ram", "memory"},
            "Dat is no where near enough memory for our application.  Get moar from us.");           
        responsesHashMap2.put(new String[] {"gb", "gig", "gigabyte", "gigs", "gigabytes"},
            "Gigabytes are tiny, get a Terabyte.");  
        responsesHashMap2.put(new String[] {"tb", "terabyte", "terabytes"},
            "Terabytes are tiny, get a Petabyte."); 
        responsesHashMap2.put(new String[] {"rude", "nasty", "swearing"},
            "Because I don't give a fuck cunt."); 
        responsesHashMap2.put(new String[] {"laugh", "laughing", "laughed"},
            "LOL wanna tissue? Seriously though, it is fucking funny you bell end."); 
        responsesHashMap2.put(new String[] {"web", "internet", "net"},
            "Sounds like an ISP issues, go talk to da fucking NBN.");            
        responsesHashMap2.put(new String[] {"cpu", "processor", "cores"},
            "Lol do they still exist? Better buy some moar corez off of us bra");              
        responsesHashMap2.put(new String[] {"space", "hdd", "hard drive", "ssd"},
            "Lol do they still exist? Better buy some moar storage solutions off of us bra");            
    }
}
