package chapter14_javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * <h1>BorderPaneExample</h1>
 * <p>
 * This program
 * </p>
 * <p>
 * tags:	<insert concept tags here for training code only>
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-07-24
 */
public class BorderPaneExample extends Application
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
		// Create the BorderPane and add panes to its 5 regions
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(new CustomPane("Top"));
		borderPane.setRight(new CustomPane("Right"));
		borderPane.setBottom(new CustomPane("Bottom"));
		borderPane.setLeft(new CustomPane("Left"));
		borderPane.setCenter(new CustomPane("Centre"));
		
		// Create, set, and show the scene.
		Scene scene = new Scene(borderPane);
		primaryStage.setTitle("BorderPaneExample");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//@@@ INNER CLASS(ES) @@@
	private class CustomPane extends StackPane
	{
		private CustomPane(String title)
		{
			getChildren().add(new Label(title));
			setStyle("-fx-border-color: red");
			setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		}
	}
}
