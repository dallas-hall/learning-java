package chapter14_javafx.Question01to06;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>TicTacToeBoard</h1>
 * <p>
 * This program places x's and o's on a naughts and crosses board with barely any intelligence. It just checks if that board position is in use, nothing else.
 * </p>
 * <p>
 * tags:	Image; ImageView; GridPane; Scene; Math.random; HashMap;
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2018-08-11
 */
public class TicTacToeBoard extends Application
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
		// Create the GridPane container
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		// The gaps between column horizontal and vertical columns.
		gridPane.setHgap(16);
		gridPane.setVgap(16);
		
		// Add the ImageView objects to the GridPane so they can be displayed in the UI
		// x and y stored and the boolean representing if it has been used already.
		Map<String, Boolean> positions = new HashMap<>();
		positions.put("0,0", false);
		positions.put("0,1", false);
		positions.put("0,2", false);
		positions.put("1,0", false);
		positions.put("1,1", false);
		positions.put("1,2", false);
		positions.put("2,0", false);
		positions.put("2,1", false);
		positions.put("2,2", false);
		
		for (int i = 0 ; i < 9; i++) {
			while (true) {
				int x = (int) (Math.random() * 3);
				int y = (int) (Math.random() * 3);
				
				String coordinates = x + "," + y;
				boolean used = positions.get(coordinates);
				if (!used) {
					if ((i + 1) % 2 != 0) {
						gridPane.add(new ImageView(new Image("http://www.pngall.com/wp-content/uploads/2016/04/X-Alphabet-PNG.png", 50, 50, false, false)), x, y);
					}
					else {
						gridPane.add(new ImageView(new Image("http://www.pngall.com/wp-content/uploads/2016/04/O-Alphabet-PNG.png", 50, 50, false, false)), x, y);
					}
					positions.put(coordinates, true);
					break;
				}
			}
		}
		
		// Create and set the Scene
		Scene scene = new Scene(gridPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("DisplayImagesGridPane");
		primaryStage.show();
	}
}
