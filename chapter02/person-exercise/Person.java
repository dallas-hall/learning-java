
/**
 * Dis class holds da most importent info about any
 * mudda fukka who uses it.  
 * 
 * @author blindcant 
 * @version 2015-06-14_v1
 */
public class Person
{
    //some cunt's name
    private String name;
    //some cunt's age
    private int age;
    //some cunt's racial pride
    private String nationality;
    //some cunt's dik
    private boolean dick;

    /**
     * Constructor for objects of class Person
     */
    public Person(String inputName, int inputAge, String inputNationality, boolean inputDick)
    {
        // initialise instance variables
        name = inputName;
        age = inputAge;
        nationality = inputNationality;
        dick = inputDick;
    }

    public void getName()
    {
        //print dat name shiz
        System.out.println("my name iz: " + name + " zoola, da mic rula, da old skoola, wanna trip? I take it 2 ya");
        newLine();
    }

    public void getAge()
    {
        //print dem numbers yo
        System.out.println("ur " + age + " years fukn old shithed");
        newLine();
    }

    public void getNationality()
    {
        //printy z skin colour
        System.out.println("ur a fukn dirty " + nationality + " madda fuka");
        newLine();
    }

    public void getDick()
    {
        if (dick != true) {
            System.out.println("give me sum of dat suga ya slut");
            newLine();
        }
        else {
            System.out.println("m8, put that fukn thing away will ya");
            newLine();
        }
    }
    
    public void newLine()
    {   
        //need some space bra
        System.out.println();
    }

    public void setName(String newName)
    {
        name = newName;
        System.out.println("you can relax bra, the popo wont find u now ur name iz " + name);
        newLine();
    }

    public void setAge(int newAge)
    {
        if (newAge >= 0) {
            age = newAge;
            System.out.println("da fuq? u won of dem boat peopl who dunno der age?  well fuk, u r are now " + age + " years old indo scum");
            newLine();
        }
        else {
            System.out.println("fuk of m8 ill fukn rek u");
            newLine();
        }

    }

    public void setNationality(String newNationality)
    {
        System.out.println("u fukin wot m8? u were a " + nationality + " but now u rkn ur a fukin " + newNationality + "? righto.");
        newLine();
        nationality = newNationality;
    }
    
}
