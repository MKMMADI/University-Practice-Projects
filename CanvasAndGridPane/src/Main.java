import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception 
	{
		try
		{
			Canvas canvas = new Canvas(600,600);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			int rows = 15; // Number of rows
			int cols = 15; // Number of columns

			
			//declaring pixel sizes 
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

			arg0.setScene(new Scene(new Pane(canvas),600,600));;
			arg0.show();
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}

}
