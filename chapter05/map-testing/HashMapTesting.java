import java.util.HashMap;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Exercise 5.26
 */
public class HashMapTesting
{
    private HashMap<String, String[]> phoneBook;

    public static void main(String[] args)
    {
        HashMapTesting run1 = new HashMapTesting();
    }

    /**
     * Constructor for objects of class HashMapTesting
     */
    public HashMapTesting()
    {
        phoneBook = new HashMap<>();
        populatePhoneBook();
    }

    private void populatePhoneBook()
    {
        // https://stackoverflow.com/questions/1017486/why-passing-a-b-c-to-a-method-doesnt-work
        phoneBook.put("Some Dude", new String[] {createPhoneNumber(false), createPhoneNumber(true)});
        phoneBook.put("Some Guy", new String[] {createPhoneNumber(false), createPhoneNumber(true)});
        phoneBook.put("Some Chick", new String[] {createPhoneNumber(false), createPhoneNumber(true)});
        phoneBook.put("Some-Other Dude", new String[] {createPhoneNumber(false), createPhoneNumber(true)});
        phoneBook.put("Some Gal", new String[] {createPhoneNumber(false), createPhoneNumber(true)});
    }

    public String[] lookupNumber(String name)
    {
        return phoneBook.get(name);
    }
    
    public void enterPhoneNumber(String name, String[] numbers)
    {
        phoneBook.put(name, numbers);
    }

    public void printAllEntries()
    {
        //https://stackoverflow.com/a/35558955
        for (String s : phoneBook.keySet())
        {
            String tmpKey = s.toString();
            System.out.println("The phone numbers for " + tmpKey + " are...");
            String[] tmpValuePair = phoneBook.get(tmpKey);

            for (int i = 0; i < tmpValuePair.length; i++) 
            {
                System.out.println("Phone number " + (i + 1) + " is : " + tmpValuePair[i]);
            }//*/
            System.out.println();
        }
    }

    private String createPhoneNumber(boolean isMobile)
    {
        String phoneNumber;
        int prn = ThreadLocalRandom.current().nextInt(0,101);
        //75% chance to get a phone number.
        if (prn <= 75)
        {
            if (isMobile)
            {
                phoneNumber = ThreadLocalRandom.current().nextLong(61400000000L, 61500000000L) + "";
            }
            else
            {
                int areaCode;
                int geoCode;
                prn = ThreadLocalRandom.current().nextInt(0,11);
                if (prn <= 5)
                {
                    areaCode = ThreadLocalRandom.current().nextInt(2, 4);
                }
                else
                {
                    areaCode = ThreadLocalRandom.current().nextInt(5, 9);
                }
                geoCode = ThreadLocalRandom.current().nextInt(11, 100);
                phoneNumber = "0" + areaCode + "" +  geoCode + "" + ThreadLocalRandom.current().nextInt(100000, 1000000);
            }
        }
        else
        {
            phoneNumber = "";
        }
        return phoneNumber;
    }
}
