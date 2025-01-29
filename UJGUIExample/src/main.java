
//Application provides us with an entry point for JavaFX 2 import javafx.application.Application; 3 //Event allows us to interact with events and properties 4 import javafx.event.ActionEvent; 5 import javafx.event.EventHandler; 6 //Scene gives us controls for use in a scene 7 import javafx.scene.Scene; 8 //Controls allow for interaction with the user 9 import javafx.scene.control.Button;
 import javafx.scene.control.TextField;
 //Layouts allow for nodes to be arranged automatically
import javafx.scene.layout.VBox;
//Stage gives us a stage to load scenes
import javafx.stage.Stage;

 //Must extend Application (JavaFX)
public class Main extends Application{

 public static void main(String[] args) {
 launch(args); //We launch the application from here

}
//Class scope attribute to store text
 private TextField txt= new TextField();

//Start method from Application (JavaFX entry point)
@Override
 public void start(Stage primaryStage) throws Exception {
 //start() gives us our stage from Application
 primaryStage.setTitle
("Hello World!");
 Button btn= new Button();
 btn.setText("Say 'Hello World'");
 btn.setOnAction(new EventHandler<ActionEvent>() {
 @Override
 public void handle(ActionEvent event) {
 txt.setText("Hello World!");

}
});

 //Create root node
 VBox root= new VBox();
 root.getChildren().add(btn);
 root.getChildren().add(txt);

 //Set the scene for the stage
 primaryStage.setScene(new Scene(root, 300, 250));

//"Open the curtains"
 primaryStage.show();

}

}
