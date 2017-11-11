package chapter31_networking.object_example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blindcant on 10/11/17.
 */
public class TestPerson
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		List<Person> people = new ArrayList<>();
		Person aPerson01 = new Person("John McLovin", (byte) 21, 'M', "1999-11-10");
		people.add(aPerson01);
		Person aPerson02 = new Person("Jane Doe", (byte) 24, 'F', "1997-11-10");
		people.add(aPerson02);
		
		for (Person aPerson : people)
		{
			System.out.println(aPerson.toString());
		}
	}
}
