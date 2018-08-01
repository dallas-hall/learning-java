package chapter14_javafx.shapes;/**
 * <h1>ColoredCentredCircle</h1>
 * <p>
 * This program shows how to make shapes and use the Color class.
 * </p>
 * <p>
 * tags:	JavaFX shapes; Color;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-07-04
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ColoredCentredCircle extends Application
{
	//@@@ JAVAFX @@@
	@Override
	public void start(Stage primaryStage)
	{
		// Create the pane which is the layout container
		Pane pane = new Pane();
		
		// Create a circle
		Circle circle = new Circle();
		// Centre the circle, only works if width and height are the same
		circle.centerXProperty().bind(pane.widthProperty().divide(2));
		circle.centerYProperty().bind(pane.widthProperty().divide(2));
		// Update the circle state
		circle.setRadius(50);
		circle.setStroke(Color.BLACK);
		Color white = new Color(1, 1, 1, 1);
		circle.setFill(white);
		
		// Add the circle to the pane
		pane.getChildren().add(circle);
		
		// Create the scene
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("ColoredCentredCircle");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
