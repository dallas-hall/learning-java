import java.util.ArrayList;

/**
 * Write a description of class NameGenerator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NameGenerator
{
    //an arraylist of string arrays for our normal names & our starwars names
    private ArrayList<String> normalNames;
    private ArrayList<String> starWarsNames;

    public NameGenerator()
    {
        normalNames = new ArrayList<>();
        starWarsNames = new ArrayList<>();
    }

    public void printNormalNames()
    {
        for (String currentName : normalNames)
        {
            System.out.println(currentName);
        }
    }

    public void printStarWarsNames()
    {
        for (String currentName : starWarsNames)
        {
            System.out.println(currentName);
        }
    }
    
    public void setNormalNames(String firstName, String lastName)
    {
        normalNames.add(firstName + " " + lastName);
    }
 
    public void setStarWarsNames(String firstName, String lastName, String mothersMaidenName, String townOfBirth)
    {
        String starWarsFirstName = lastName.substring(0, 3).concat(firstName.substring(0, 2));
        String starWarsLastName = mothersMaidenName.substring(0, 2).concat(townOfBirth.substring(0, 3));
        starWarsNames.add(starWarsFirstName + " " + starWarsLastName);
    }
}
