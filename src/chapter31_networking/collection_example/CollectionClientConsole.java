package chapter31_networking.collection_example;

import chapter19_generics.question01.GenericStack;
import chapter19_generics.question01.TestGenericStack;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by blindcant on 12/11/17.
 */
public class CollectionClientConsole
{
	//@@@ INSTANCE VARIABLES @@@
	private GenericStack<String> stack1;
	
	private Socket clientSocket;
	private ObjectOutputStream dataToServer;
	private ObjectInputStream dataFromServer;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		try
		{
			CollectionClientConsole runtime = new CollectionClientConsole();
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public CollectionClientConsole() throws Exception
	{
		System.out.println("@@@ Setting Up Data @@@");
		TestGenericStack runtime2 = new TestGenericStack();
		System.out.println("\n### Getting String Stack ###");
		this.stack1 = runtime2.getStringStack();
		System.out.println("Done.");
		System.out.println("\n### Peek @ Stack ###");
		stack1.peekAtStackPrint();

		System.out.println("\n@@@ Connecting To Server @@@");
		connectToServer();
		boolean done = false;
		done = sendStack(done);

	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	private String getServerMessage() throws Exception
	{
		
		if (dataFromServer.available() > 0)
		{
			return dataFromServer.readUTF();
		}
		else
		{
			return null;
		}
		
	}
	
	//### SETTERS ###
	private void connectToServer() throws Exception
	{
		clientSocket = new Socket("127.0.0.1", 8000);
		dataToServer = new ObjectOutputStream(clientSocket.getOutputStream());
		dataFromServer = new ObjectInputStream(clientSocket.getInputStream());
	}
	
	//### HELPERS ###
	private boolean sendStack(boolean done) throws Exception
	{
		Scanner scanner = new Scanner(System.in);
		
		while (!done)
		{
			
			String serverMessage = getServerMessage();
			if (serverMessage != null)
			{
				System.out.println(serverMessage);
				serverMessage = null;
			}
			
			
			System.out.println("Type the name of the stack that you want to send to the server.  Or type exit to exit");
			String stackForServer = scanner.nextLine();
			if (stackForServer.toLowerCase().equals("exit"))
			{
				return true;
				
			}
			else if (stackForServer.toLowerCase().equals("stack1"))
			{
				dataToServer.writeObject(stack1);
				dataToServer.flush();
				Thread.sleep(250);
			}
			else
			{
				System.out.println("Sorry that stack doesn't exist, try again.");
			}
		}
		return true;
	}
	//@@@ INNER CLASS(ES) @@@
}
