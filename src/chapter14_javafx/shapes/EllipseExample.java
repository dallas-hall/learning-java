package chapter14_javafx.shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * <h1>EllipseExample</h1>
 * <p>
 * This program shows how multiple ellipses can become a circle.
 * </p>
 * <p>
 * tags:	setStroke; setFill; Math.random();
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-07-30
 */
public class EllipseExample extends Application
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
		Pane pane = new Pane();
		
		for (int i = 0; i < 16; i++) {
			Ellipse ellipse = new Ellipse(150, 100, 100, 50);
			ellipse.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
			ellipse.setFill(Color.WHITE);
			ellipse.setRotate(i * 180 / 16);
			pane.getChildren().add(ellipse);
		}
		
		Scene scene = new Scene(pane, 320, 240);
		primaryStage.setTitle("EllipseExample");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
