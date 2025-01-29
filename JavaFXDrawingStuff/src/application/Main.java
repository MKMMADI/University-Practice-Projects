package application;
	

import javax.swing.text.html.ImageView;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		Group root = new Group();
		Scene scene = new Scene(root,600,600,Color.LIGHTGRAY);
		//initializing text object
		Text text = new Text();
		//setting text
		text.setText("Hello You :)");
		//positioning text
		text.setX(50);
		text.setY(50);
		//changing text font and color
		text.setFont(Font.font("Verdena", 25));
		text.setFill(Color.KHAKI);
		
		
		Line ln = new Line();
		ln.setStartX(200);
		ln.setStartY(200);
		ln.setEndX(500);
		ln.setEndY(200);
		ln.setStrokeWidth(5);
		ln.setStroke(Color.BISQUE);
		ln.setOpacity(0.50);
		ln.setRotate(45);
		
		Rectangle rectangle=new Rectangle();
		rectangle.setX(100);
		rectangle.setY(100);
		rectangle.setWidth(50);
		rectangle.setHeight(50);
		rectangle.setFill(Color.OLIVE);
		rectangle.setStrokeWidth(5);
		rectangle.setStroke(Color.AZURE);
		
		Polygon triangle = new Polygon();
		triangle.getPoints().setAll(200.0,200.0,300.0,300.0,200.0,300.0);
		triangle.setFill(Color.MEDIUMPURPLE);
		
		Circle circle = new Circle();
		circle.setCenterX(350);
		circle.setCenterY(350);
		circle.setRadius(50);
		circle.setFill(Color.BLANCHEDALMOND);
		
		Image img = new Image("https://th.bing.com/th/id/OIG2._Wa4pysgPHVJX_kMBI2b?w=173&h=173&c=6&r=0&o=5&pid=ImgGn");
		//ImageView IV = new ImageView(img);
		//Displaying text
		root.getChildren().add(circle);
		root.getChildren().add(triangle);
		root.getChildren().add(text);
		root.getChildren().add(ln);	
	
		//setting scene
		stage.setScene(scene);
		//displaying stage
		stage.show();
	}
}
