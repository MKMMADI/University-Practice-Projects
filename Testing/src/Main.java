import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		MenuBar MB = new MenuBar();
		MenuItem menuItem = new MenuItem();
		Menu menu = new Menu("File");
		
		menuItem.setText("Open File");;
		menu.getItems().add(menuItem);
		MB.getMenus().add(menu);
		
		VBox Accordion_Control = new VBox();	
		TitledPane FireworkDisplay = new TitledPane("Firework Display",new ListView<>());
		TitledPane Lead_Pyro_Technician = new TitledPane("Lead Pyro Technician",new ListView<>());
		TitledPane Fireworks = new TitledPane("Fireworks",new ListView<>());
		Accordion_Control.getChildren().addAll(FireworkDisplay,Lead_Pyro_Technician,Fireworks);
		
		
		BorderPane BP = new BorderPane();
		BP.setTop(MB);
		BP.setLeft(Accordion_Control);
		BP.setCenter(new Canvas());
		
		
		Scene SC = new Scene(BP,800,600);
		primaryStage.setScene(SC);
		primaryStage.setFullScreen(false);
		primaryStage.show();
		
		
		
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

}
