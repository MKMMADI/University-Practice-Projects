package project04Practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) 
	{	
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		clientPane cpane = new clientPane(primaryStage);
		Scene scene = new Scene(cpane,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
