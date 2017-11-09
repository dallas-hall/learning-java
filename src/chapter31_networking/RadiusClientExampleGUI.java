package chapter31_networking;

import java.io.*;
import java.net.*;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by blindcant on 9/11/17.
 *
 * This is an example from the book showing how a server and client interacts.
 */
public class RadiusClientExampleGUI extends Application
{
	//@@@ INSTANCE VARIABLES @@@
	// IO streams
	DataOutputStream toServer = null;
	DataInputStream fromServer = null;
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage)
	{
		// Panel p to hold the label and text field
		BorderPane paneForTextField = new BorderPane();
		paneForTextField.setPadding(new Insets(5, 5, 5, 5));
		paneForTextField.setStyle("-fx-border-color: green");
		paneForTextField.setLeft(new Label("Enter a radius: "));
		TextField textField = new TextField();
		textField.setAlignment(Pos.BOTTOM_RIGHT);
		paneForTextField.setCenter(textField);
		BorderPane mainPane = new BorderPane();
		
		// Text area to display contents
		TextArea textArea = new TextArea();
		mainPane.setCenter(new ScrollPane(textArea));
		mainPane.setTop(paneForTextField);
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(mainPane, 450, 200);
		primaryStage.setTitle("Client");
		
		// Place the scene in the stage & display it
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// Setup the client and server details
		try
		{
			// Create a socket to connect to the server
			Socket socket = new Socket("localhost", 8000);
			
			// Example Sockets
			// Socket socket = new Socket("130.254.204.36", 8000);
			// Socket socket = new Socket("drake.Armstrong.edu", 8000);
			
			// Create an input stream to receive data from the server
			fromServer = new DataInputStream(socket.getInputStream());
			
			// Create an output stream to send data to the server
			toServer = new DataOutputStream(socket.getOutputStream());
		}
		catch (IOException ex)
		{
			textArea.appendText(ex.toString() + '\n');
		}
		
		// Event listener for when the user enters data into the text field
		textField.setOnAction(e -> {
			try
			{
				// Get the radius from the text field
				double radius = Double.parseDouble(textField.getText().trim());
				
				// Send the radius to the server
				toServer.writeDouble(radius);
				toServer.flush();
				
				// Get area from the server
				double area = fromServer.readDouble();
				
				// Display to the text area
				textArea.appendText("Radius is " + radius + "\n");
				textArea.appendText("Area received from the server is " + area + '\n');
			} catch (IOException ex)
			{
				System.err.println(ex);
			}
		});
	}
}