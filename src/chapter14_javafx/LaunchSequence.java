package chapter14_javafx;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * <h1>LaunchSequence</h1>
 * <p>
 * This program
 * </p>
 * <p>
 * tags:	<insert concept tags here for training code only>
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-06-28
 */
public class LaunchSequence extends Application
{
	//@@@ JAVAFX @@@
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		System.out.println("primaryStage.");
	}
	
	//@@@ MAIN METHOD @@@
	// This can be omitted because the JVM will automatically invoke this when it is omitted.
	public static void main(String[] args)
	{
		System.out.println("main method");
		Application.launch(args);
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public LaunchSequence()
	{
		System.out.println("Constructor.");
	}
}
