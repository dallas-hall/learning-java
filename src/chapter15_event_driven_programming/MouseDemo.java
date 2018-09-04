package chapter15_event_driven_programming;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * <h1>MouseDemo</h1>
 * <p>
 * This program shows how to drag a text node around with the mouse.
 * </p>
 * <p>
 * tags:	setOnMouseDragged; lambda;
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2018-09-04
 */
public class MouseDemo extends Application
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
		Pane pane = new Pane();
		Text text_drag = new Text(50, 50, "Click me, or click and drag me!");
		Text text_message = new Text(15, 15, "");
		pane.getChildren().addAll(text_drag, text_message);
		// Handle click and hold
		text_drag.setOnMousePressed(e -> {
			if(e.isPrimaryButtonDown())
				text_message.setText("Left button clicked and held.");
			else if(e.isMiddleButtonDown())
				text_message.setText("Middle button clicked and held.");
			else if(e.isSecondaryButtonDown())
				text_message.setText("Right button clicked and held.");
		});
		// Handle click
		text_drag.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY)
				text_message.setText("Left button clicked.");
			else if (e.getButton() == MouseButton.MIDDLE)
				text_message.setText("Middle button clicked.");
			else if (e.getButton() == MouseButton.SECONDARY)
				text_message.setText("Left button clicked.");
		});
		// Handle click and drag
		text_drag.setOnMouseDragged(e -> {
			text_drag.setX(e.getX());
			text_drag.setY(e.getY());
			text_message.setText("Mouse clicked and dragged.");
		});
		
		Scene scene = new Scene(pane, 320, 240);
		primaryStage.setTitle("MouseDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
