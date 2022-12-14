package chapter14_javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * <h1>SingleStage</h1>
 * <p>
 * This program showcases the basic structure of a JavaFX program.
 * </p>
 * <p>
 * tags:	Stage; Scene; Button; JavaFX;
 * </p>
 *
 * @author dhall
 * @version 0.0.1 - 2018-06-28
 */
public class SingleStage extends Application
{
	//@@@ JAVAFX @@@
	// The start method from Application
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		// Create a scene and place a button on the scene
		Button buttonOK = new Button("OK");
		Scene scene = new Scene(buttonOK, 640, 480);
		// Update the stage which the window
		// Add a title
		primaryStage.setTitle("SingleStage JavaFX");
		// Add the scene to the stage
		primaryStage.setScene(scene);
		// Display the stage
		primaryStage.show();
	}
	
	//@@@ MAIN METHOD @@@
	// This can be omitted because the JVM will automatically invoke this when it is omitted.
	public static void main(String[] args)
	{
		System.out.println("main method");
		Application.launch(args);
	}
}
