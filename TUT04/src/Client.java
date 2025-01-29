import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application {
	
	
	private PrintWriter txtout = null;
	private BufferedReader txtin= null;
	
	private DataOutputStream dos = null;
	private DataInputStream dis = null;
	
	private OutputStream os = null;
	private InputStream is = null;
	
	
	
	
	public static void main(String[] args)
	{
		launch(args);
	}




	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("My GUI");
		FileClientPane clientPane = new FileClientPane();
		Scene scene = new Scene(clientPane,800,600);
		stage.setScene(scene);
		stage.show();
		
	}
}
