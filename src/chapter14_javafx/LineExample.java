package chapter14_javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * <h1>LineExample</h1>
 * <p>
 * This program
 * </p>
 * <p>
 * tags:	<insert concept tags here for training code only>
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-07-29
 */
public class LineExample extends Application
{
	//@@@ CLASS VARIABLES @@@
	
	
	//@@@ INSTANCE VARIABLES @@@
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Application.launch(args);
	}
	
	//@@@ JAVAFX @@@
	@Override
	public void start(Stage primaryStage)
	{
		Scene scene = new Scene(new LinePane(), 200, 200);
		primaryStage.setTitle("LineExample");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//@@@ INNER CLASS(ES) @@@
	private class LinePane extends Pane
	{
		private LinePane()
		{
			Line line1 = new Line(10, 10, 10, 10);
			line1.endXProperty().bind(widthProperty().subtract(10));
			line1.endYProperty().bind(heightProperty().subtract(10));
			line1.setStrokeWidth(5);
			line1.setStroke(Color.GREEN);
			getChildren().add(line1);
			
			Line line2 = new Line(10, 10, 10, 10);
			line2.startXProperty().bind(widthProperty().subtract(10));
			line2.endYProperty().bind(heightProperty().subtract(10));
			line2.setStrokeWidth(5);
			line2.setStroke(Color.GREEN);
			getChildren().add(line2);
			
		}
	}
}
