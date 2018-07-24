package chapter14_javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * <h1>HBoxVBoxExample</h1>
 * <p>
 * This program
 * </p>
 * <p>
 * tags:	<insert concept tags here for training code only>
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-07-24
 */
public class HBoxVBoxExample extends Application
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
		// Create a BorderPane and populate it with a VBox and HBox.
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(getHbox());
		borderPane.setLeft(getVbox());
		
		// Create, set, and display the scene.
		Scene scene = new Scene(borderPane);
		primaryStage.setTitle("HBoxVBoxExample");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	
	//@@@ METHODS @@@
	//### GETTERS ###
	private HBox getHbox()
	{
		// Get an image from a URL
		Image image = new Image("https://flaglane.com/download/australian-flag/australian-flag-small.gif");
		ImageView imageView = new ImageView(image);
		
		// Create a HBox and return it
		HBox hBox = new HBox(15);
		hBox.setPadding(new Insets(15, 15, 15, 15));
		hBox.setStyle("-fx-background-color: gold");
		hBox.getChildren().add(new Button("Comp. Sci."));
		hBox.getChildren().add(new Button("Chemistry"));
		hBox.getChildren().addAll(imageView);
		return hBox;
	}
	
	private VBox getVbox()
	{
		VBox vBox = new VBox(15);
		vBox.setPadding(new Insets(15, 15, 15, 15));
		vBox.getChildren().add(new Label("Courses"));
		
		Label[] courses = {
				new Label("CSCI 1301"),
				new Label("CSCI 1302"),
				new Label("CSCI 2410"),
				new Label("CSCI 3720")
		};
		
		for(Label course : courses) {
			VBox.setMargin(course, new Insets(0, 0, 0, 15));
			vBox.getChildren().add(course);
		}
		return vBox;
	}
}
