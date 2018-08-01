package chapter14_javafx.layouts;
/**
 * <h1>GridPaneExample</h1>
 * <p>
 * This program shows how to use the GridPane.
 * </p>
 * <p>
 * tags:	GridPane; Insets; alignment;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-07-18
 */

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneExample extends Application
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
		// Create the GridPane and update its state
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		gridPane.setHgap(5.5);
		gridPane.setVgap(5.5);
		
		// Add some nodes to the GridPane using grid coordinates
		gridPane.add(new Label("First Name:"), 0, 0);
		gridPane.add(new TextField(), 1, 0);
		gridPane.add(new Label("MI:"), 0, 1);
		gridPane.add(new TextField(), 1, 1);
		gridPane.add(new Label("Last Name:"), 0, 2);
		gridPane.add(new TextField(), 1, 2);
		Button button_add = new Button("Add Name");
		gridPane.add(button_add, 1, 3);
		GridPane.setHalignment(button_add, HPos.RIGHT);
		
		// Create the scene and add it to the stage
		Scene scene = new Scene(gridPane);
		primaryStage.setTitle("GridPane Example");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
}
