package chapter14_javafx;
/**
 * <h1>ImageAndImageView</h1>
 * <p>
 * This program shows how to display an image in JavaFx.
 * </p>
 * <p>
 * tags:	Image; ImageView;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-07-09
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ImageAndImageView extends Application
{
	//@@@ JAVAFX @@@
	@Override
	public void start(Stage primaryStage)
	{
		Pane pane = new HBox(10);
		pane.setPadding(new Insets(5, 5, 5, 5));
		Image image = new Image("https://flaglane.com/download/australian-flag/australian-flag-small.gif");
		pane.getChildren().add(new ImageView(image));
		
		ImageView imageView2 = new ImageView(image);
		imageView2.setFitHeight(100);
		imageView2.setFitWidth(100);
		
		pane.getChildren().add(imageView2);
		
		ImageView imageView3 = new ImageView(image);
		imageView3.setRotate(90);
		pane.getChildren().add(imageView3);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("ShowImage");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
