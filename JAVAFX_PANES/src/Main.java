import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		MenuBar MB = new MenuBar();
		MenuItem menuItem = new MenuItem("Open File");
		Menu menu = new Menu("Options");
		FileChooser FC = new FileChooser();
		FC.setTitle("Files");
		menu.getItems().add(menuItem);
		MB.getMenus().add(menu);
		menu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FC.showOpenDialog(primaryStage);
			}
		});
		
		VBox LeftPane = new VBox();
		TitledPane FireWorkDisplay = new TitledPane("Firework Display",new ListView<>());
		TitledPane Lead_Technician = new TitledPane("Firework Technician",new ListView<>());
		TitledPane FireWork = new TitledPane("Firework Details",new ListView<>());

		LeftPane.getChildren().addAll(FireWorkDisplay);	
		LeftPane.getChildren().addAll(Lead_Technician);
		LeftPane.getChildren().addAll(FireWork);
		
		Canvas canvas = new Canvas();
		GraphicsContext gc = canvas.getGraphicsContext2D();
		int rows = 10; // Number of rows
		int cols = 10; // Number of columns

		double cellWidth = canvas.getWidth() / cols;
		double cellHeight = canvas.getHeight() / rows;

		// Draw horizontal lines
		for (int row = 0; row < rows; row++) {
		    double y = row * cellHeight;
		    gc.strokeLine(0, y, canvas.getWidth(), y);
		}

		// Draw vertical lines
		for (int col = 0; col < cols; col++) {
		    double x = col * cellWidth;
		    gc.strokeLine(x, 0, x, canvas.getHeight());
		}

		
		

		
		
		GridPane GP = new GridPane();
		
		BorderPane BP =new BorderPane();
		BP.setTop(MB);
		BP.setLeft(LeftPane);
		BP.setCenter(canvas);
		
		Group g = new Group();
		
		primaryStage.setScene(new Scene(BP,800,600));
		primaryStage.setTitle("JavaGui");
		primaryStage.show();
		
	}

}
