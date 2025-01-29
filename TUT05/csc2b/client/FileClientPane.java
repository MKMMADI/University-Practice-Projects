package csc2b.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FileClientPane extends GridPane{
	
	private Socket clientSocket = null;
	private BufferedReader txtin = null;
	private PrintWriter txtout = null;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	private OutputStream os = null;
	private InputStream is = null;
	
	Label lblHeader = null;
	Button btnConnect = null;
	Button btnDownload = null;	
	TextArea txtResponse = null;
	
	public FileClientPane() {
		setUpGUI();
		
		btnConnect.setOnAction((event)->{
			try {
				clientSocket = new Socket("localhost",1234);
				os = clientSocket.getOutputStream();
				is = clientSocket.getInputStream();
				
				txtin = new BufferedReader(new InputStreamReader(is));
				txtout = new PrintWriter(os);
				
				dis = new DataInputStream(is);
				dos = new DataOutputStream(os);
				
				txtResponse.appendText("Connected to server on port " + clientSocket.getPort() + "\n");	
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		btnDownload.setOnAction((event)->{
			txtout.println("RETURN");
			txtout.flush();
			
			FileOutputStream fos = null;
			
			
			try {
				String response = txtin.readLine();
				txtResponse.appendText("Retrieving file. \n");
				int fileSize = Integer.parseInt(response);				
				File fileToDownload = new File("data/client/beautifulSong.mp3");			
				
				fos = new FileOutputStream(fileToDownload);
				byte[] buffer = new byte[2048];
				int n=0;
				int totalBytes = 0;
				
				while(totalBytes!=fileSize) {
					n=dis.read(buffer,0,buffer.length);
					fos.write(buffer,0,n);
					fos.flush();
					totalBytes+=n;
				}
				
				txtResponse.appendText("File Download Complete. \n");
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(fos!=null && clientSocket!=null) {
					try {
						fos.close();
						clientSocket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
	}
	
	private void setUpGUI() {
		setHgap(10);
		setVgap(10);
		setAlignment(Pos.CENTER);
		
		lblHeader = new Label("File Client");
		lblHeader.setFont(Font.font("Arial",FontWeight.BOLD,16));		
		add(lblHeader,0,0,1,1);
		
		btnConnect = new Button("Connect to Server");
		add(btnConnect,0,1,1,1);
		
		btnDownload = new Button("Download Song");
		add(btnDownload,0,2,1,1);
		
		txtResponse = new TextArea();
		txtResponse.setPrefHeight(200);
		add(txtResponse,0,3,1,1);
	}

}
