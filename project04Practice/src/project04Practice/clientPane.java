package project04Practice;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class clientPane extends GridPane
{
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    private PrintWriter out;
    private BufferedReader in;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String[] listData;

    private Button btnConnect;
    private Button btnImageList;

    private TextField txtIDToRetrieve;
    private Label lblID;

    private Button btnGetting;
    private Button btnPosting;
    private TextArea listArea;
    private TextArea responseArea;
    private Label lblList;
    private Label lblResponse;
    private ImageView imgView;
    private Button btnDisplay;
    private String fileToGetName = "";

    public clientPane(Stage stage)
    {
        GUISETUP();

        btnConnect.setOnAction(e -> {
            try
            {
                this.socket = new Socket("localhost", 4321);

                this.is = this.socket.getInputStream();
                this.os = this.socket.getOutputStream();

                this.dis = new DataInputStream(is);
                this.dos = new DataOutputStream(os);

                this.in = new BufferedReader(new InputStreamReader(is));
                this.out = new PrintWriter(os, true);

                this.listArea.appendText("Client has successfully connected\n");
            }
            catch (UnknownHostException UHE)
            {
                UHE.printStackTrace();
            }
            catch (Exception e2)
            {
                e2.printStackTrace();
            }
        });

        btnImageList.setOnAction(e -> {
            this.sendCommand(out, "LST");
            try
            {
            	int fileSize = Integer.parseInt(this.in.readLine());
            	FileOutputStream fos = new FileOutputStream("data/client/list.txt");
            	
            	byte[] buffer = new byte[fileSize];
            	int bytesRead=0;
            	int totalBytesRead=0;
            	
            	while(totalBytesRead!=bytesRead)
            	{
            		bytesRead=dis.read(buffer, 0, buffer.length);
            		fos.write(buffer,0,bytesRead);
            		fos.flush();
            		totalBytesRead+=bytesRead;
            	}               	
            	fos.close();            	
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        });

        btnGetting.setOnAction(e -> {
        	sendCommand(out, "RET");
            try
            {
            	String fileSize =in.readLine();
            	
            	byte[] buffer = new byte[1028*5];
            	File MyPdf = new File("data/client/Practical 6.pdf");
            	FileOutputStream fos = new FileOutputStream(MyPdf);
            	int bytesRead=0;
            	int totalBytesRead=0;
            	
            	while(totalBytesRead!=bytesRead)
            	{
            		bytesRead=dis.read(buffer,0,buffer.length);
            		fos.write(buffer);
            		fos.flush();
            		totalBytesRead+=bytesRead;
            	}
            	fos.close();
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        });

        btnPosting.setOnAction(e -> {
            // Add logic to post the image
        });

        btnDisplay.setOnAction(e -> {
            // Add logic to display the image
        });
    }

    private String ReadResponse(BufferedReader br2)
    {
        // Add logic to read the response from the server
        return fileToGetName;
    }

    private void sendCommand(PrintWriter out2, String command)
    {
        out2.println(command);
    }

    private void GUISETUP()
    {
        setHgap(10);
        setVgap(10);
        setAlignment(Pos.CENTER);

        btnConnect = new Button("Connect");
        btnImageList = new Button("Image List");
        txtIDToRetrieve = new TextField();
        lblID = new Label("ID to Retrieve:");
        btnGetting = new Button("Get Image");
        btnPosting = new Button("Upload Image");

        listArea = new TextArea();
        responseArea = new TextArea();
        responseArea.setPrefHeight(100);
        lblList = new Label("List Of Content");
        lblResponse = new Label("Server And Client Responses");
        btnDisplay = new Button("View Downloaded Image");

        this.getChildren().addAll(btnConnect, btnImageList, lblID, txtIDToRetrieve, btnGetting, btnPosting, lblList, listArea, lblResponse, responseArea, btnDisplay);

        GridPane.setConstraints(btnConnect, 0, 0);
        GridPane.setConstraints(btnImageList, 1, 0);
        GridPane.setConstraints(lblID, 0, 1);
        GridPane.setConstraints(txtIDToRetrieve, 1, 1);
        GridPane.setConstraints(btnGetting, 2, 1);
        GridPane.setConstraints(btnPosting, 3, 1);
        GridPane.setConstraints(lblList, 0, 2);
        GridPane.setConstraints(listArea, 0, 3, 4, 1);
        GridPane.setConstraints(lblResponse, 0, 4);
        GridPane.setConstraints(responseArea, 0, 5, 4, 1);
        GridPane.setConstraints(btnDisplay, 0, 6, 4, 1);
    }
}
