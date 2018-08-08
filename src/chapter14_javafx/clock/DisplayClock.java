package chapter14_javafx.clock;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * <h1>DisplayClock</h1>
 * <p>
 * This program uses a variety of JavaFX classes to make a clock.
 * </p>
 * <p>
 * tags:	BorderPane; Label;
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2018-08-08
 */
public class DisplayClock extends Application
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
		ClockPane clockPane = new ClockPane();
		
		String hour = null;
		String minute = null;
		String second = null;
		if (clockPane.getHour() % 24 < 10) {
			hour = "0" + clockPane.getHour();
		}
		else {
			hour = String.valueOf(clockPane.getHour());
		}
		
		if (clockPane.getMinute() % 60 < 10) {
			minute = "0" + clockPane.getMinute();
		}
		else {
			minute = String.valueOf(clockPane.getMinute());
		}
		
		if (clockPane.getSecond() % 60 < 10) {
			second = "0" + clockPane.getSecond();
		}
		else {
			second = String.valueOf(clockPane.getSecond());
		}
		
		String string_currentTime = hour + ":" + minute + ":" + second;
		Label label_currentTime = new Label(string_currentTime);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(clockPane);
		borderPane.setBottom(label_currentTime);
		BorderPane.setAlignment(label_currentTime, Pos.TOP_CENTER);
		
		Scene scene = new Scene(borderPane, 250, 250);
		primaryStage.setTitle("DisplayClock");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
