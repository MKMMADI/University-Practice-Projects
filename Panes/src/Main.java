import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception 
	{
		MenuBar MB = new MenuBar();
		Menu menu = new Menu("Options...");
		MenuItem item1 = new MenuItem("Open File.");
		menu.getItems().add(item1);	
		MB.getMenus().add(menu);
		FileChooser FC = new FileChooser();
		FC.setTitle("Open File");
		menu.setOnAction(e->FC.showOpenDialog(arg0));
		
		
		VBox  LeftPanel = new VBox();
		TitledPane FireWorkDisplay = new TitledPane("Firework_Display",new ListView<>());
		TitledPane Technician = new TitledPane("Technician Display",new ListView<>());
		TitledPane Firework = new TitledPane("Firework Display",new ListView<>());
		LeftPanel.getChildren().addAll(FireWorkDisplay,Firework,Technician);
		LeftPanel.getChildren().add(MB);
		
		Canvas RightPanel = new Canvas();
		GraphicsContext GC = RightPanel.getGraphicsContext2D();
		
		Group g = new Group(RightPanel);
		BorderPane BP = new BorderPane();
		BP.setTop(MB);
		BP.setLeft(LeftPanel);
		BP.setCenter(RightPanel);
		Scene scene = new Scene(g,800,600);
		arg0.setScene(scene);
		arg0.setTitle("FireWork Display");
		arg0.show();
		
		
		
	}

}
