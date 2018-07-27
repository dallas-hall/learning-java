package chapter14_javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * <h1>TextExample</h1>
 * <p>
 * This program shows how to use strings inside the Text object.
 * </p>
 * <p>
 * tags:	Shape; Text; Font; FontWeight; FontPosture;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-07-27
 */
public class TextExample extends Application
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
		pane.setPadding(new Insets(5, 5, 5, 5));
		Text text1 = new Text(20, 20, "Programming is fun.");
		text1.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));
		pane.getChildren().add(text1);
		
		Text text2 = new Text(60, 60, "Programming in Java is fun.\nSo is JavaFX.");
		pane.getChildren().add(text2);
		
		Text text3 = new Text(10, 100, "Programming in C is fun.\nSo is Python.");
		text3.setFill(Color.RED);
		text3.setUnderline(true);
		text3.setStrikethrough(true);
		pane.getChildren().add(text3);
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TextExample");
		primaryStage.show();
	}
}
