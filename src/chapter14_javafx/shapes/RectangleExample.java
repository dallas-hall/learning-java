package chapter14_javafx.shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * <h1>RectangleExample</h1>
 * <p>
 * This program shows how to use the Rectangle class.
 * </p>
 * <p>
 * tags:	setStroke; setFill; Color.COLOR_NAME;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-07-29
 */
public class RectangleExample extends Application
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
		// Create the pane
		Pane pane = new Pane();
		
		// Create a Rectangle
		Rectangle rectangle1 = new Rectangle(25, 10, 60, 30);
		rectangle1.setStroke(Color.BLACK);
		rectangle1.setFill(Color.WHITE);
		pane.getChildren().add(new Text(10, 27, "r1"));
		pane.getChildren().add(rectangle1);
		
		Rectangle rectangle2 = new Rectangle(25, 50, 60, 30);
		pane.getChildren().add(new Text(10, 67, "r2"));
		pane.getChildren().add(rectangle2);
		
		Rectangle rectangle3 = new Rectangle(25, 90, 60, 30);
		rectangle3.setArcWidth(15);
		rectangle3.setArcHeight(25);
		pane.getChildren().add(new Text(10, 107, "r3"));
		pane.getChildren().add(rectangle3);
		
		for (int i = 0; i < 4; i++) {
			Rectangle rectangle = new Rectangle(100, 50, 100, 30);
			rectangle.setRotate(i * 360 / 8);
			rectangle.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
			rectangle.setFill(Color.WHITE);
			pane.getChildren().add(rectangle);
		}
		
		Scene scene = new Scene(pane, 250, 150);
		primaryStage.setTitle("RectangleExample");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
