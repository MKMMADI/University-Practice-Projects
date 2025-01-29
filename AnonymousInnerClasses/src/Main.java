

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String args[])
	{
		
		Greeting greet = new Greeting() {
			
			@Override	
			public void welcome()
			{
				System.out.println("Yoh");
			}
		};
		
		greet.welcome();
			
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Menu menu = new Menu("Files");
		MenuItem mi = new MenuItem("Open File Explorer");
		MenuBar mb = new MenuBar();
		menu.getItems().add(mi);
		mb.getMenus().add(menu);
		
		FileChooser fc = new FileChooser();
		fc.setTitle("Print Hello");
		menu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
			fc.showOpenMultipleDialog(primaryStage);
			}
		} );
		
		Button btn = new Button("Print Hello");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("2020-10-14");
			}
		});
		
		BorderPane BP = new BorderPane();
		BP.setTop(mb);
		BP.setBottom(btn);
		Scene sc = new Scene(BP,810,600);
		
		primaryStage.setScene(sc);
		primaryStage.show();
		
		
		
		
	}
}
