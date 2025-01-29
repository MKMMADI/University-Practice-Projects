package csc2b.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;

public class Client extends Application{

	private Socket clientSocket = null;
	private BufferedReader txtin = null;
	private PrintWriter txtout = null;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	private OutputStream os = null;
	private InputStream is = null;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Server File Sender");
		FileClientPane clientPane = new FileClientPane();
		Scene scene = new Scene(clientPane, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
	
	

}
