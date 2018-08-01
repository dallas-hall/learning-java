package chapter14_javafx.layouts;
/**
 * <h1>FlowPaneExample</h1>
 * <p>
 * This program shows how to use a FlowPane.
 * </p>
 * <p>
 * tags: FlowPane;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-07-18
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneExample extends Application
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
		// Create the FlowPane and update its state
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(11, 12, 13, 14));
		flowPane.setHgap(5);
		flowPane.setVgap(5);
		
		// Get the FlowPane list and add some stuff to it
		flowPane.getChildren().addAll(new Label("First Name:"), new TextField(), new Label("MI:"));
		TextField textField_mi = new TextField();
		textField_mi.setPrefColumnCount(1);
		flowPane.getChildren().addAll(textField_mi, new Label("Last Name:"), new TextField());
		
		// Create the scene & add it to the stage
		Scene scene = new Scene(flowPane, 200, 250);
		primaryStage.setTitle("FlowPane Example");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
