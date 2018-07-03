package chapter14_javafx;/**
 * <h1>ButtonInsidePane</h1>
 * <p>
 * This program
 * </p>
 * <p>
 * tags:	<insert concept tags here for training code only>
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-06-29
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ButtonInsidePane extends Application
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
		// Get the list and add a node to it
		stackPane.getChildren().add(new Button("OK"));
		// Create the scene
		Scene scene = new Scene(stackPane, 320, 240);
		primaryStage.setTitle("Button Inside Pane");
		// Add the scene to the stage
		primaryStage.setScene(scene);
		// Display the stage
		primaryStage.show();
	}
}
