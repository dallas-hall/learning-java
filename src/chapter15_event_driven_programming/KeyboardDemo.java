package chapter15_event_driven_programming;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * <h1>KeyboardDemo</h1>
 * <p>
 * This program shows how Key Events can be used.
 * </p>
 * <p>
 * tags:	setOnKeyPressed; getCode(); Character.isLetterOrDigit; KeyCode;
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2018-09-17
 */
public class KeyboardDemo extends Application
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
		Pane pane = new Pane();
		Text text = new Text(20, 20, "A");
		
		pane.getChildren().add(text);
		text.setOnKeyPressed(e -> {
			switch (e.getCode()) {
				case DOWN:
					text.setY(text.getY() + 10);
					break;
				case UP:
					text.setY(text.getY() - 10);
					break;
				case LEFT:
					text.setX(text.getY() - 10);
					break;
				case RIGHT:
					text.setX(text.getX() + 10);
					break;
				default:
					if (Character.isLetterOrDigit(e.getText().charAt(0))) {
						text.setText(e.getText());
					}
			}
		});
		
		Scene scene = new Scene(pane, 640, 480);
		primaryStage.setTitle("KeyboardDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		text.requestFocus();
	}
}
