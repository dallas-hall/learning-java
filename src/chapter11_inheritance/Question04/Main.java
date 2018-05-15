package chapter11_inheritance.Question04;

/**
 * <h1>ArrayList Values Main</h1>
 * <p>
 * This is the driver program for the ArrayList Values class.
 * </p>
 * <p>
 * tags:
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-05-15
 */
public class Main
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		System.out.println("[INFORMATION] Test 1.");
		ArrayListValues runtime = new ArrayListValues();
		runtime.populateList(21);
		runtime.printList();
		System.out.println("The minimum value is: " + runtime.getMin());
		System.out.println("The average value is: " + runtime.getAverage());
		System.out.println("The maximum value is: " + runtime.getMax());
		System.out.println("\n[INFORMATION] Test 2.");
		ArrayListValues runtime2 = new ArrayListValues();
		runtime2.populateList();
		runtime2.printList();
		System.out.println("The minimum value is: " + runtime2.getMin());
		System.out.println("The average value is: " + runtime2.getAverage());
		System.out.println("The maximum value is: " + runtime2.getMax());
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	
	
	//@@@ METHODS @@@
	//### GETTERS ###
	
	//### SETTERS ###
	
	//### HELPERS ###
	
	//@@@ INNER CLASS(ES) @@@
}
