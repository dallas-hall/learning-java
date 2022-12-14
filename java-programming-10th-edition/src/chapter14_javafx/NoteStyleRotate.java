package chapter14_javafx;/**
 * <h1>NoteStyleRotate</h1>
 * <p>
 * This program shows how nodes can be rotated.
 * </p>
 * <p>
 * tags:	JavaFX; StackPane; Button; setStyle; setRotate;
 * </p>
 *
 * @author dhall
 * @version 0.0.1 - 2018-07-03
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class NoteStyleRotate extends Application
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Application.launch(args);
	}
	
	//@@@ JAVAFX @@@
	@Override
	public void start(Stage primaryStage)
	{
		// This can store a List of nodes
		StackPane stackPane = new StackPane();
		// Create a node
		Button buttonOk = new Button("OK");
		buttonOk.setStyle("-fx-border-color: blue;");
		// Get the list and add a node to it
		stackPane.getChildren().add(buttonOk);
		
		// Apply some JavaFX CSS
		//buttonOk.setRotate(45);
		stackPane.setRotate(45);
		stackPane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
		
		// Create the scene
		Scene scene = new Scene(stackPane, 640, 480);
		// Add the scene to the stage & display
		primaryStage.setTitle("Node Style Rotate");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
