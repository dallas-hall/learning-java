package chapter14_javafx.shapes;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

/**
 * <h1>PolygonAndPolyline</h1>
 * <p>
 * This program shows how to create polygons and polylines.
 * </p>
 * <p>
 * tags:	Polygon; Polyline; Math.sin; Math.cos; Math.min; Math.PI;
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2018-08-06
 */
public class PolygonAndPolyline extends Application
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
		double width = 200;
		double height = 200;
		double centreX = width / 2;
		double centreY = height / 2;
		double radius = Math.min(width, height) * 0.4;
		
		Polygon polygon = new Polygon();
		polygon.setFill(Color.WHITE);
		polygon.setStroke(Color.BLACK);
		ObservableList<Double> polygonPoints = polygon.getPoints();
		
		for (int i = 0; i < 6; i++) {
			polygonPoints.add(centreX + radius * Math.cos(2 * i * Math.PI / 6));
			polygonPoints.add(centreY - radius * Math.sin(2 * i * Math.PI / 6));
		}
		
		Polyline polyline = new Polyline();
		polyline.setFill(Color.WHITE);
		polyline.setStroke(Color.BLACK);
		
		ObservableList<Double> polylinePoints = polyline.getPoints();
		
		for (int i = 0; i < 6; i++) {
			polylinePoints.add(centreX + radius * Math.cos(2 * i * Math.PI / 6));
			polylinePoints.add(centreY - radius * Math.sin(2 * i * Math.PI / 6));
		}
		
		
		VBox vBox = new VBox(15);
		vBox.setPadding(new Insets(15, 15, 15, 15));
		vBox.getChildren().add(polygon);
		vBox.getChildren().add(new Label("Polygon"));
		vBox.getChildren().add(polyline);
		vBox.getChildren().add(new Label("Polyline"));
		
		Scene scene = new Scene(vBox);
		primaryStage.setTitle("PolygonAndPolyline");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
