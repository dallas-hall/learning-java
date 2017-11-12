package chapter31_networking.collection_example;

import chapter19_generics.question01.GenericStack;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by blindcant on 12/11/17.
 */
public class CollectionServerConsole
{
	//@@@ INSTANCE VARIABLES @@@
	// ### Networking ###
	private ServerSocket serverSocket;
	private int port = 8000;
	private String ipAddress = "127.0.0.1";
	private int clientNumber = 0;
	
	private List<GenericStack<String>> stacks;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		CollectionServerConsole runtime = new CollectionServerConsole();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public CollectionServerConsole()
	{
		try
		{
			// Setup the server socket
			serverSocket = new ServerSocket(8000);
			stacks = new ArrayList<>();
			System.out.println("Starting some shitty multithreaded server @ " + ipAddress + ":" + port + " on " + new Date());
			
			// Infintite loop to keep listening for the client's messages
			while (true)
			{
				// Tell the server to listen for multiple connection requests and create a new thread each time one is made
				Socket socket = serverSocket.accept();
				clientNumber++;
				
				// Display client connection
				InetAddress inetAddress = socket.getInetAddress();
				System.out.println("\n@@@ New Connection @@@\nStarting new thread for client number " + clientNumber);
				System.out.println("Connected from IP address " + inetAddress.getHostAddress());
				System.out.println("That resolves to " + inetAddress.getCanonicalHostName());
				
				
				// Run connection on a new thread using an anonymous Thread class that implements Runnable
				new Thread(new Runnable()
				{
					
					@Override
					public void run()
					{
						try
						{
							// Setup the server I/O streams.
							ObjectOutputStream dataForClient = new ObjectOutputStream(socket.getOutputStream());
							ObjectInputStream dataFromClient = new ObjectInputStream(socket.getInputStream());
							
							// Send MOTD
							dataForClient.writeUTF("\n@@@ MOTD @@@\nWelcome to the shitty stack server client " + clientNumber + ".\n");
							dataForClient.flush();
							
							// Infintite loop to keep listening for the client's messages
							while (true)
							{
								// Receive Stack from client
								GenericStack<String> stringStackFromClient = (GenericStack<String>) dataFromClient.readObject();
								
								// Print the client's stack
								System.out.println("\nClient " + clientNumber + " sent a stack object.");
								stringStackFromClient.printStackSize();
								stringStackFromClient.peekAtStackPrint();
								
								// Send ACK to client 50% of the time
								dataForClient.writeUTF("\nClient " + clientNumber + ", the server received your crappy stack.");
								dataForClient.flush();
								
								// Store, and then pop an object and clear the stack object
								addStack(stringStackFromClient);
/*								for(int i = 0; i < stringStackFromClient.getStackSize(); i++)
								{
									stringStackFromClient.popFromStack();
								}*/
								stringStackFromClient = null;
							}
						} catch (EOFException eof)
						{
							System.out.println("\nClient " + clientNumber + " has disconnected.");
						} catch (ClassNotFoundException e)
						{
							System.out.println("\nThat person object didn't work. Try again.");
						}catch (IOException ioe)
						{
							ioe.printStackTrace();
						}
					}
				}).start();
			}
		} catch (IOException ioe)
		{
			ioe.printStackTrace();
		} finally
		{
			// Exit gracefully
			System.exit(0);
		}
	}
	
	private void addStack(GenericStack<String> genericStack)
	{
		stacks.add(genericStack);
	}
}
