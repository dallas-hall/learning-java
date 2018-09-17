package chapter15_event_driven_programming;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * <h1>CircleResizingWithEvents</h1>
 * <p>
 * This program showcases how to define event sources, create and fire event objects, and listen for and handle event objects.
 * </p>
 * <p>
 * tags:	HBox; BorderPane; setOnAction; implements EventHandler<ActionEvent>; Button; EventHandler<ActionEvent>;
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2018-08-15
 */
public class CircleResizingWithEvents extends Application
{
	//@@@ CLASS VARIABLES @@@
	private CirclePane circlePane = new CirclePane();
	
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
		// Create a horizontal box for the buttons
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		
		// Create and add the buttons to the HBox
		Button button_enlarge = new Button("Enlarge");
		Button button_shrink = new Button("Shrink");
		
		hBox.getChildren().add(button_enlarge);
		hBox.getChildren().add(button_shrink);
		
		// Create and register the event handler with inner event handler classes
		button_enlarge.setOnAction(new EnlargeHandler());
		// Use lambda
		button_shrink.setOnAction(e -> circlePane.shrink());
		
		circlePane.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				circlePane.enlarge();
			}
			else if (e.getButton() == MouseButton.SECONDARY) {
				circlePane.shrink();
			}
		});
		
		circlePane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.U) {
				circlePane.enlarge();
			}
			else if (e.getCode() == KeyCode.D) {
				circlePane.shrink();
			}
		});
		
		// Create the main layout container
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(circlePane);
		borderPane.setBottom(hBox);
		borderPane.setAlignment(hBox, Pos.CENTER);
		
		// Create and set the scene
		Scene scene = new Scene(borderPane, 320, 240);
		primaryStage.setTitle("CircleResizingWithEvents");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// Request input focus
		circlePane.requestFocus();
	}
	
	//@@@ INNER CLASS(ES) @@@
	private class CirclePane extends StackPane
	{
		private Circle circle = new Circle(50);
		
		public CirclePane()
		{
			this.getChildren().add(circle);
			circle.setStroke(Color.BLACK);
			circle.setFill(Color.WHITE);
		}
		
		public void enlarge()
		{
			circle.setRadius(circle.getRadius() + 2);
		}
		
		public void shrink()
		{
			// If the new radius is greater than 2, shrink it, otherwise leave it.
			circle.setRadius(circle.getRadius() > 2 ? circle.getRadius() - 2 : circle.getRadius());
		}
	}
	
	private class EnlargeHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent actionEvent)
		{
			circlePane.enlarge();
		}
	}
}
