package chapter31_networking.object_example;

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
 * Created by blindcant on 10/11/17.
 */
public class PersonServer
{
	//@@@ INSTANCE VARIABLES @@@
	//### Networking ###
	private ServerSocket serverSocket;
	private int port = 8000;
	private String ipAddress = "127.0.0.1";
	private int clientNumber = 0;
	
	private List<Person> people;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		PersonServer runtime = new PersonServer();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public PersonServer()
	{
		try
		{
			// Setup the server socket
			serverSocket = new ServerSocket(8000);
			people = new ArrayList<>();
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
							dataForClient.writeUTF("\n@@@ MOTD @@@\nWelcome to the shitty people server client " + clientNumber + ".\n");
							dataForClient.flush();
							
							// Infintite loop to keep listening for the client's messages
							while (true)
							{
								// Receive Person from client
								Person personFromClient = (Person) dataFromClient.readObject();
								
								// Print the client's person
								System.out.println("\nClient " + clientNumber + " sent the person object:\n" + personFromClient.toString());
								
								// Send ACK to client 50% of the time
								//returns a number between min (inclusive) and max (exclusive).  So add one to max to include it.
								int prnThreadLocalRandom = ThreadLocalRandom.current().nextInt(1,  100 + 1);
								if(prnThreadLocalRandom >= 1)
								{
									dataForClient.writeUTF("\nClient " + clientNumber + ", the server received:\n" + personFromClient.toString());
									dataForClient.flush();
								}
								
								// Store and clear the person object
								addPerson(personFromClient);
								personFromClient = null;
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
	
	private void addPerson(Person aPerson)
	{
		people.add(aPerson);
	}
}
