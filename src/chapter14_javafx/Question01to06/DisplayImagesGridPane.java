package chapter14_javafx.Question01to06;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * <h1>DisplayImagesGridPane</h1>
 * <p>
 * This program shows how to download 4 images and add them to a grid pane.
 * </p>
 * <p>
 * tags:	Image; ImageView; GridPane; Scene;
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2018-08-11
 */
public class DisplayImagesGridPane extends Application
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
		
		// Create the Image objects which are the images themselves
		Image image_australianFlagSmall = new Image("https://flaglane.com/download/australian-flag/australian-flag-small.png");
		Image image_southKoreanFlagSmall = new Image("https://flaglane.com/download/south-korean-flag/south-korean-flag-small.png");
		Image image_britishFlagSmall = new Image("https://flaglane.com/download/british-flag/british-flag-small.png");
		Image image_canadianFlagSmall =  new Image("https://flaglane.com/download/canadian-flag/canadian-flag-small.png");
		
		// Create the ImageView objects that can display Image objects
		ImageView imageView_australianFlagSmall =  new ImageView(image_australianFlagSmall);
		ImageView imageView_southKoreanFlagSmall =  new ImageView(image_southKoreanFlagSmall);
		ImageView imageView_britishFlagSmall =  new ImageView(image_britishFlagSmall);
		ImageView imageView_canadianFlagSmall =  new ImageView(image_canadianFlagSmall);
		
		// Add the ImageView objects to the GridPane so they can be displayed in the UI
		gridPane.add(imageView_australianFlagSmall, 0, 0);
		gridPane.add(imageView_southKoreanFlagSmall, 0, 1);
		gridPane.add(imageView_britishFlagSmall, 1, 0);
		gridPane.add(imageView_canadianFlagSmall, 1, 1);
		
		// Create and set the Scene
		Scene scene = new Scene(gridPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("DisplayImagesGridPane");
		primaryStage.show();
	}
}
