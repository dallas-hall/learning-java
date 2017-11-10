package chapter31_networking;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


/**
 * Created by blindcant on 9/11/17.
 *
 * I tried sharing Socket, ObjectOutputStream, and ObjectInputStream between all connections and this doesn't work.
 * There needs to be a new instance per connection, when you think about it, that makes sense.
 * GG beer and beef jerky, you win this round.
 */
public class MulithreadedStringServerExampleConsole
{
	//@@@ INSTANCE VARIABLES @@@
	//### I/O stream ###
	//private ObjectOutputStream dataForClient;
	//private ObjectInputStream dataFromClient;
	
	//### Networking ###
	private ServerSocket serverSocket;
	//private Socket socket;
	private int port = 8000;
	private String ipAddress = "127.0.0.1";
	
	private int clientNumber = 0;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		MulithreadedStringServerExampleConsole runtime = new MulithreadedStringServerExampleConsole();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public MulithreadedStringServerExampleConsole()
	{
		try
		{
			// Setup the server socket
			serverSocket = new ServerSocket(8000);
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
							dataForClient.writeUTF("\nMOTD: The survey says.. I mean the server says: Hello client " + clientNumber + ".");
							dataForClient.flush();
							
							// Infintite loop to keep listening for the client's messages
							while (true)
							{
								// Receive String from client
								String clientInput = dataFromClient.readUTF();
								
								// Print the client's message
								System.out.println("\nClient " + clientNumber + " said: " + clientInput);
								
								// Send ACK to client
								dataForClient.writeUTF("\n*Red Alert Russian Accent* Client " + clientNumber + ", Acknowledged!");
								dataForClient.flush();
							}
						} catch (EOFException eof)
						{
							System.out.println("\nClient " + clientNumber + " has disconnected.");
						} catch (IOException ioe)
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
}
