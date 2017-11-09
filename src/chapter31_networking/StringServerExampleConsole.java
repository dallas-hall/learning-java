package chapter31_networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Created by blindcant on 9/11/17.
 */
public class StringServerExampleConsole
{
	//@@@ INSTANCE VARIABLES @@@
	//### I/O stream ###
	private ObjectOutputStream dataForClient;
	private ObjectInputStream dataFromClient;
	
	//### Networking ###
	private ServerSocket serverSocket;
	private Socket socket;
	private int port = 8000;
	private String ipAddress = "127.0.0.1";
	
	boolean setupDone;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		StringServerExampleConsole runtime = new StringServerExampleConsole();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public StringServerExampleConsole()
	{
		System.out.println("Starting some shitty server @ " + ipAddress + ":" + port + " on " + new java.util.Date() + "\n");
		
		// Run the server on a new thread
		new Thread(() -> {
			try
			{
				
				// Setup the server socket
				serverSocket = new ServerSocket(8000);
				
				// Tell the server to listen for a single connection request
				socket = serverSocket.accept();
				
				// Setup the server I/O streams.
				dataForClient = new ObjectOutputStream(socket.getOutputStream());
				dataFromClient = new ObjectInputStream(socket.getInputStream());
				
				// Infintite loop to keep listening for the client's messages
				while (true)
				{
					// Receive String from client
					String clientInput = dataFromClient.readUTF();
					
					// Print the client's message
					System.out.println("The client said: " + clientInput);
					
					// Send ACK to client
					dataForClient.writeUTF("*Red Alert Russian Accent* Acknowledged!");
					dataForClient.flush();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				// Exit gracefully
				System.exit(0);
			}
			
		}).start();
	}
}
