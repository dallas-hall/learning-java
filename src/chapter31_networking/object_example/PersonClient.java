package chapter31_networking.object_example;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by blindcant on 10/11/17.
 */
public class PersonClient
{
	//@@@ INSTANCE VARIABLES @@@
	//### I/O stream ###
	private ObjectOutputStream toServer;
	private ObjectInputStream fromServer;
	
	//### Networking ###
	private Socket clientSocket;
	
	//### Collection ###
	List<Person> people;
	Scanner scanner;
	
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		// Setup client
		PersonClient runtime = new PersonClient();
		Person aPerson = null;
		String name = null;
		byte age = 0;
		char sex = '\u0000';
		String dob = null;
		String serverMessage = null;
		
		// Create some people
		System.out.println("Welcome the shitty person client where you can create garbage people to send to a garbage server.");
		boolean done = false;
		do
		{
			System.out.println("Enter the student's name.");
			name = runtime.scanner.nextLine();
			System.out.println("Enter the student's age.");
			age = Byte.parseByte(runtime.scanner.nextLine());
			System.out.println("Enter the student's sex.");
			sex = runtime.scanner.nextLine().charAt(0);
			System.out.println("Enter the student's DOB (yyyy-mm-dd).");
			dob = runtime.scanner.nextLine();
			
			// Create the Person object and store it in the ArrayList
			aPerson = new Person(name, age, sex, dob);
			runtime.people.add(aPerson);
			
			// Clear the Person object and ask if the user wants to continue
			aPerson = null;
			System.out.println("Do you want to add another Student? Enter Y or N");
			if (runtime.scanner.nextLine().toLowerCase().equals("n"))
			{
				done = true;
			}
		} while (!done);
		
		// Print the people added
		runtime.printPeople();
		
		// Communicate with the server continuously
		while (true)
		{
			//Print a server message if there is one.
			serverMessage = runtime.getServerMessage();
			if (serverMessage != null)
			{
				System.out.println(serverMessage);
				serverMessage = null;
			}

			System.out.println("Type in the person's name that you want to send to the server. Or type exit.");
			name = runtime.scanner.nextLine();
			if (name.equals("exit"))
			{
				break;
			}
			
			aPerson = runtime.getPerson(name);
			if (aPerson != null)
			{
				// Send the Person object
				runtime.sendPersonToServer(aPerson);
			}
			else
			{
				// Ask again
				System.out.println("Sorry that person wasn't found, try again.");
			}
		}
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public PersonClient()
	{
		people = new ArrayList<>();
		scanner = new Scanner(System.in);
		setupClient();
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	private Person getPerson(String name)
	{
		for (Person aPerson : people)
		{
			if (name.equals(aPerson.getName()))
			{
				return aPerson;
			}
		}
		return null;
	}
	
	private String getServerMessage()
	{
		try
		{
			if(fromServer.available() > 0)
			{
				return fromServer.readUTF();
			}
			else
			{
				return null;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	//### SETTERS ###
	private void setupClient()
	{
		try
		{
			clientSocket = new Socket("localhost", 8000);
			toServer = new ObjectOutputStream(clientSocket.getOutputStream());
			fromServer = new ObjectInputStream(clientSocket.getInputStream());
			// The buffered stream breaks the sending of Strings it seems
/*			toServer = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
			fromServer = new ObjectInputStream(new BufferedInputStream(clientSocket.getInputStream()));*/
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//### HELPERS ###
	private void printPeople()
	{
		System.out.println("@@@ Printing All Students @@@");
		for (Person aPerson : people)
		{
			System.out.println(aPerson.toString());
		}
	}
	
	private void sendPersonToServer(Person aPerson)
	{
		try
		{
			// Make sure to reset the Object so you can send the latest version
			toServer.reset();
			toServer.writeObject(aPerson);
			// Make sure to flush the buffer so you actually send all the data
			toServer.flush();
			Thread.sleep(250);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//@@@ INNER CLASS(ES) @@@
}
