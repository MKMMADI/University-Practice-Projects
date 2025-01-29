package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		//initializing stage
		/*Stage stage = new Stage();
		stage.show();*/
		Group root = new Group();
		
		//initialize scene with root the initialize stage with scene
		Scene scene = new Scene(root,Color.BLACK);
		
		//can`t find image for some reason (.jpeg)
		Image icon = new Image("https://th.bing.com/th/id/OIG2._Wa4pysgPHVJX_kMBI2b?w=173&h=173&c=6&r=0&o=5&pid=ImgGn");
		stage.setWidth(420);
		stage.setHeight(420);
		//stage.setResizable(false);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("q to exit.");
		stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
		
		
		stage.getIcons().add(icon);
		stage.setTitle("Stage Demo Program ");
	
		stage.setScene(scene);
		stage.show();
	}
}
