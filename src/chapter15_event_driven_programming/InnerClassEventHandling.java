package chapter15_event_driven_programming;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * <h1>InnerClassEventHandling</h1>
 * <p>
 * This program shows how to do primitive event handling for buttons, using inner classes.
 * </p>
 * <p>
 * tags:	HBox; Button; EventHandler<ActionEvent>; inner class;
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2018-08-13
 */
public class InnerClassEventHandling extends Application
{
	//@@@ CLASS VARIABLES @@@
	
	
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
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		// The event sources are created.
		Button button_Ok = new Button("OK");
		Button button_Cancel = new Button("Cancel");
		
		// The listener is created.
		OkHandlerClass handler_buttonOk = new OkHandlerClass();
		// The event source has a listener bound against an event.
		button_Ok.setOnAction(handler_buttonOk);
		
		// The listener is created.
		CancelHandlerClass handler_buttonCancel = new CancelHandlerClass();
		// The event source has a listener bound against an event.
		button_Cancel.setOnAction(handler_buttonCancel);
		
		hBox.getChildren().addAll(button_Ok, button_Cancel);
		
		Scene scene = new Scene(hBox);
		primaryStage.setTitle("InnerClassEventHandling");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//@@@ INNER CLASS(ES) @@@
	// The event handler classes are defined.
	class OkHandlerClass implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent actionEvent)
		{
			System.out.println("OK button was clicked.");
		}
	}
	
	class CancelHandlerClass implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent actionEvent)
		{
			System.out.println("Cancel button was clicked.");
		}
	}
}
