package chapter11.Question02;


/**
 * Created by blindcant on 3/05/17.
 */
public class Main
{
	//INSTANCE VARIABLES
	private static Person[] people = new Person[8];
	private static int arrayCount = 0;
	
	//MAIN METHOD
	public static void main(String[] args)
	{
	people[arrayCount++] = new Student("Mr Johnny Some-Dude", "3/10-12 My-House Road, Some-Place, Some-State, 90210.", "johnny@email.com", "(01)23456789", "Senior Maths Debator");
	people[arrayCount++] = new Faculty("Mrs Roberta Lippy", "97A The Esplande, Some-Place, Some-State, 90210.", "rl65@email.com", "(01)23567899", "Block C", 35000, "9am-5pm", "Supreme Overlord.");
	people[arrayCount++] = new Staff("Mr Bobby DROP TABLE *;", "100 New England Highway, Some-Place, Some-State, 90210.", "bobbbbbbbby@email.com", "+61400-178-123", "Block A", 10000, "Underling");
	printArray();
	
	}
	
	//CONSTRUCTOR(S)
	
	
	//METHODS
	public static void printArray()
	{
/*		for (Person someone : people)
		{
			// Needed so polymorphism works correctly.
			// This is because of defining element type Person in the for each loop.
			if (someone instanceof Student)
			{
				System.out.println(someone.toString());
			}
			else if (someone instanceof Faculty)
			{
				System.out.println(someone.toString());
			}
			else if (someone instanceof Staff)
			{
				System.out.println(someone.toString());
			}
		}*/
		
		//doesn't need instance of, polymorphism at its finest
		for (int i = 0; i < arrayCount; i++)
		{
			System.out.println(people[i].toString() + "Object type:\t\t" + people[i].getClass().getSimpleName() + "\n");
		}

	}
}
