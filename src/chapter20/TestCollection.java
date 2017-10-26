package chapter20;

import java.util.*;

public class TestCollection
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		// All of the below will work as they implement List
		//ArrayList<String> collection1 = new ArrayList<>();
		//LinkedList<String> collection1 = new LinkedList<>();
		//Vector<String> collection1 = new Vector<>();
		Stack<String> collection1 = new Stack<>();
		
		collection1.add("New York");
		collection1.add("Atlanta");
		collection1.add("Dallas");
		collection1.add("Madison");
		
		System.out.println("A list of cities in collection1:");
		System.out.println(collection1);
		printAll(collection1);
		System.out.println(collection1.size() + " cities are in collection1 now");
		
		System.out.println("\nIs Dallas in collection1? " + collection1.contains("Dallas"));
		System.out.println("Removing Dallas...");
		collection1.remove("Dallas");
		System.out.println("Is Dallas in collection1? " + collection1.contains("Dallas"));
		System.out.println(collection1.size() + " cities are in collection1 now");
		System.out.println("A list of cities in collection1:");
		System.out.println(collection1);
		printAll(collection1);
		
		ArrayList<String> collection2 = new ArrayList<>();
		collection2.add("Seattle");
		collection2.add("Portland");
		collection2.add("Los Angeles");
		collection2.add("Atlanta");
		
		System.out.println("\nA list of cities in collection2:");
		System.out.println(collection2);
		printAll(collection2);
		System.out.println(collection2.size() + " cities are in collection2 now");
		
		//https://blog.codinghorror.com/a-visual-explanation-of-sql-joins/
		//set union (SQL UNION ALL)
		//ArrayList<String> c1 = (ArrayList<String>) (collection1.clone());
		List<String> c1 = (List<String>) collection1.clone();
		c1.addAll(collection2);
		System.out.println("\n(SQL UNION ALL) Cities in collection1 or collection2: ");
		System.out.println(c1);
		
		//set intersection (SQL INNER JOIN)
		//c1 = (ArrayList<String>) (collection1.clone());
		c1 = (List<String>) (collection1.clone());
		c1.retainAll(collection2);
		System.out.println("\n(SQL INNER JOIN) Cities in collection1 and collection2: ");
		System.out.println(c1);
		
		//set difference (SQL LEFT OUTTER JOIN WHERE RIGHT TABLE KEY IS NULL)
		//c1 = (ArrayList<String>) (collection1.clone());
		c1 = (List<String>) (collection1.clone());
		c1.removeAll(collection2);
		System.out.println("\n(SQL LEFT OUTTER JOIN & RIGHT TABLE KEY IS NULL) Cities in collection1, but not in 2: ");
		System.out.println(c1);
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	public static <E> void printAll(List<E> list)
	{
		System.out.print("Iterator printing: ");
		Iterator<E> it = list.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next().toString().toUpperCase() + " ");
		}
		System.out.println();
	}
}