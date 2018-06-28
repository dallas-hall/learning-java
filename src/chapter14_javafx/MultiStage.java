package chapter14_javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * <h1>MultiStage</h1>
 * <p>
 * This program showcases creating multiple stages. So effectively 2 program windows launch.
 * </p>
 * <p>
 * tags:	JavaFX; Scene; Stage; Button;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-06-28
 */
public class MultiStage extends Application
{
	//@@@ JAVAFX @@@
	// This is the entry point for JavaFX programs.
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		// Create the scene & its properties
		Scene scene = new Scene(new Button("OK"), 640, 480);
		// Configure the stage
		primaryStage.setTitle("MultiStage JavaFX");
		primaryStage.setScene(scene);
		// Display the stage
		primaryStage.show();
		
		// Create another stage
		Stage stage = new Stage();
		stage.setTitle("Secondary Stage");
		stage.setScene(new Scene(new Button("New Stage"), 100, 100));
		// Stop the user from resizing the stage window
		stage.setResizable(false);
		stage.show();
	}
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		System.out.println("main method");
		Application.launch(args);
	}
}
