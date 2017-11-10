package chapter31_networking;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by blindcant on 9/11/17.
 */
public class StringClientExampleConsole
{
	//@@@ INSTANCE VARIABLES @@@
	//### I/O stream ###
	private ObjectOutputStream toServer;
	private ObjectInputStream fromServer;
	
	//### Networking ###
	private Socket clientSocket;
	
	//### User Input ###
	Scanner scanner;
	
	//### Misc ###
	boolean setupDone = false;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		StringClientExampleConsole runtime = new StringClientExampleConsole();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public StringClientExampleConsole()
	{
		try
		{
			// Setup client networking details
			clientSocket = new Socket("127.0.0.1", 8000);
			toServer = new ObjectOutputStream(clientSocket.getOutputStream());
			fromServer = new ObjectInputStream(clientSocket.getInputStream());
			System.out.println("Starting some shitty client @ " + new Date());
			
			// Setup Scanner for user input
			scanner = new Scanner(System.in);
			
			// Communicate with the server via Scanner
			boolean done = false;
			while (!done)
			{
				// Display a message from the server
				String serverMessage = fromServer.readUTF();
				System.out.println(serverMessage);
				
				// Display message to user to respond
				System.out.println("\nEnter message to send to the server or type exit to exit the program.");
				String input = scanner.nextLine();
				if (input.toLowerCase().equals("exit"))
				{
					System.out.println("\nL8r g8r");
					done = true;
				}
				else
				{
					// Send the message to the server
					toServer.writeUTF(input);
					toServer.flush();
				}
				
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		finally
		{
			// Exit gracefully
			System.exit(0);
		}
	}
}
