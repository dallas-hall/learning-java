package chapter14_javafx.shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * <h1>ArcExample</h1>
 * <p>
 * This program shows how to use arcs.
 * </p>
 * <p>
 * tags:	setFill; setStroke; setType;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-07-31
 */
public class ArcExample extends Application
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
		// Create the layout container
		Pane pane = new Pane();
		
		// Create Arc objects, set their state, and add them to the layout container
		/*
		First 2 numbers are the X and Y starting position
		Second 2 numbers are the X and Y radius
		Third number is the starting angle
		Forth number is the length
		*/
		Arc arc1 = new Arc(150, 100, 80, 80, 30, 35);
		arc1.setFill(Color.RED);
		arc1.setType(ArcType.ROUND);
		pane.getChildren().add(new Text(210, 40, "arc1: round"));
		pane.getChildren().add(arc1);
		
		Arc arc2 = new Arc(150, 100, 80, 80, 30 + 90, 35);
		arc2.setFill(Color.WHITE);
		arc2.setType(ArcType.OPEN);
		arc2.setStroke(Color.BLACK);
		pane.getChildren().add(new Text(20, 40, "arc2: open"));
		pane.getChildren().add(arc2);
		
		Arc arc3 = new Arc(150, 100, 80, 80, 30 + 180, 35);
		arc3.setFill(Color.WHITE);
		arc3.setType(ArcType.CHORD);
		arc3.setStroke(Color.BLACK);
		pane.getChildren().add(new Text(20, 170, "arc3: chord"));
		pane.getChildren().add(arc3);
		
		Arc arc4 = new Arc(150, 100, 80, 80, 30 + 270, 35);
		arc4.setFill(Color.GREEN);
		arc4.setType(ArcType.CHORD);
		arc4.setStroke(Color.BLACK);
		pane.getChildren().add(new Text(210, 170, "arc4: chord"));
		pane.getChildren().add(arc4);
		
		// Create, set, and display the scene.
		Scene scene = new Scene(pane);
		primaryStage.setTitle("ArcExample");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
