package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Polygon;
import javafx.scene.Group;
import javafx.scene.image.*;


public class Main extends Application {
	@Override
	public void start(Stage SceneStage) {
		
		
		Group root = new Group();
		Scene sScene = new Scene(root);
		Image Icon = new Image("https://i.pinimg.com/564x/b2/ad/1f/b2ad1f73236a87b49553814eb535389f.jpg");
		//Polygon Square = new Polygon();
		
		
		
		SceneStage.setTitle("Pracicing JavaFx");
		SceneStage.getIcons().add(Icon);
		SceneStage.setScene(sScene);
		SceneStage.show();
		
	}
	
	public static void main(String[] args) {
		luanch(args);
	}
}
