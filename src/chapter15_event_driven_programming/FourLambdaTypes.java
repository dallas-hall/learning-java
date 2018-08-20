package chapter15_event_driven_programming;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * <h1>FourLambdaTypes</h1>
 * <p>
 * This program shows how to use 4 different Java lambdas to handle events.
 * </p>
 * <p>
 * tags:	HBox; Button; EventHandler<ActionEvent>; lambda;
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2018-08-20
 */
public class FourLambdaTypes extends Application
{
	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Application.launch(args);
	}
	
	//@@@ JAVAFX @@@
	@Override
	public void start(Stage primaryStage)
	{
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		Button button_new = new Button("New");
		Button button_open = new Button("Open");
		Button button_save = new Button("Save");
		Button button_print = new Button("Print");
		hBox.getChildren().addAll(button_new, button_open, button_save, button_print);
		
		// 4 different types of lambdas
		button_new.setOnAction((ActionEvent actionEvent) -> {
			System.out.println("New button pressed.");
		});
		
		button_open.setOnAction((actionEvent) -> {
			System.out.println("Open button pressed.");
		});
		
		button_save.setOnAction(actionEvent -> {
			System.out.println("Save button pressed.");
		});
		
		button_print.setOnAction(actionEvent -> System.out.println("Print button pressed."));
		
		// Create scene and set the stage
		Scene scene = new Scene(hBox);
		primaryStage.setTitle("AnonymousAndLambdaHandler");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
