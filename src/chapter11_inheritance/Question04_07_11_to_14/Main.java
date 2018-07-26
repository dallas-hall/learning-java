package chapter11_inheritance.Question04_07_11_to_14;

import java.util.List;

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
		System.out.println("[INFORMATION] LaunchSequence 1.");
		ArrayListManipulation runtime = new ArrayListManipulation();
		runtime.populateList(20);
		runtime.printList("The original list is: ");
		System.out.println("The sum total of the list is: " + runtime.sumList());
		System.out.println("The minimum value is: " + runtime.getMin());
		System.out.println("The average value is: " + runtime.getAverage());
		System.out.println("The maximum value is: " + runtime.getMax());
		runtime.sortList();
		runtime.printList("The sorted list is: ");
		runtime.shuffleList();
		runtime.printList("The shuffled list is: ");
		runtime.reverseList();
		runtime.printList("The reversed list is: ");
		runtime.removeDuplicates();
		runtime.printList("The distinct list is: ");
		
		System.out.println("\n[INFORMATION] LaunchSequence 2.");
		ArrayListManipulation runtime2 = new ArrayListManipulation();
		runtime2.populateList();
		runtime2.printList("The original list is: ");
		runtime2.setList(runtime2.unionLists(runtime2.getList(), runtime.getList()));
		runtime2.printList("The list after UNION is : ");
		
	}
}
