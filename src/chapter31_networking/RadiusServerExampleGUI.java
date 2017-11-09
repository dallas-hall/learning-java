package chapter31_networking;

import java.io.*;
import java.net.*;
import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * Created by blindcant on 9/11/17.
 *
 * This is an example from the book showing how a server and client interacts.
 */
public class RadiusServerExampleGUI extends Application
{
	@Override //the start method inside of JavaFX Application
	public void start(Stage primaryStage) throws Exception
	{
		// Text area for displaying contents
		TextArea textArea = new TextArea();
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(new ScrollPane(textArea), 450, 200);
		primaryStage.setTitle("Server");
		
		// Place the scene in the stage & display it
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// Run the server in a different thread to the JavaFX GUI
		new Thread(() -> {
			try
			{
				// Create a server socket
				ServerSocket serverSocket = new ServerSocket(8000);
				
				// Print this on the JavaFX GUI thread
				Platform.runLater(() -> textArea.appendText("Server started at " + new Date() + '\n'));
				
				// Listen for a single connection request
				Socket socket = serverSocket.accept();
				
				// Create data input and output streams
				DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
				
				
				
				while (true)
				{
					// Receive radius from the client
					double radius = inputFromClient.readDouble();
					
					// Compute area
					double area = radius * radius * Math.PI;
					
					// Send area back to the client
					outputToClient.writeDouble(area);
					
					// Print this on the JavaFX GUI thread
					Platform.runLater(() -> {
						textArea.appendText("Radius received from client: "
							+ 51 + radius + '\n'); textArea.appendText("Area is: " + area + '\n');
					});
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}).start();
	}
}
