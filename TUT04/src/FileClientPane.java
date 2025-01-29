import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FileClientPane extends GridPane {
	private Socket ClientSocket = null;

	private PrintWriter txtout = null;
	private BufferedReader txtin = null;

	private DataOutputStream dos = null;
	private DataInputStream dis = null;

	private OutputStream os = null;
	private InputStream is = null;

	private Button btnConnect;
	private Button btnReturn;
	private TextArea listArea;

	FileClientPane()
	{
		setUpGui();
		
		btnConnect.setOnAction((e)->
		{
		
				try
				{
					this.ClientSocket= new Socket("localhost",2022);
					
					os=ClientSocket.getOutputStream();
					is=ClientSocket.getInputStream();
					txtin=new BufferedReader(new InputStreamReader(is));
					txtout = new PrintWriter(os);
					dis = new DataInputStream(is);
					dos = new DataOutputStream(os);
						
					listArea.appendText("Connected to Server On Port " + ClientSocket.getPort()+"\n");
				}catch (Exception IO) {
					// TODO: handle exception
					IO .printStackTrace();
				}
		});
		
		
		btnReturn.setOnAction((e->{
			
			txtout.println("RETURN");
			txtout.flush();
			
			
			//server will now come back with file size 
			
			FileOutputStream fos = null;
			
			try
			{
				String Response = txtin.readLine();
				listArea.appendText("File sixe: " + Response);
				int filesize = Integer.parseInt(Response);
				
				File filetoDownload = new File("data/server/ImgList.txt"); 
				
				
				fos = new FileOutputStream(filetoDownload);
				byte[] buffer = new byte[2048];
				int totalbytes = 0;
				int n=0;
				
				while(totalbytes!=filesize)
				{
					n=dis.read(buffer,0,n);
					fos.write(buffer,0,n);
					fos.flush();
					totalbytes+=n;
					
				}
				
				listArea.appendText("File has been downloaded by client"); 
			}catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}finally
			{
				if(fos!=null && ClientSocket!=null)
				{
					try {
						fos.close();
						ClientSocket.close();

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
			
		}));
		
	
}

	private void setUpGui() {
		// TODO Auto-generated method stub
		setHgap(10);
		setVgap(10);
		setAlignment(Pos.CENTER);
		
		
		Label HeaderLabel = new Label("File Client");
		HeaderLabel.setFont(Font.font("Arial",FontWeight.BOLD,16));
		add(HeaderLabel,0,0,1,1);
		
		btnConnect = new Button("Connect");
		add(btnConnect,0,1,1,1);
		
		
		btnReturn = new Button("Return");
		add(btnReturn,0,2,1,1);
		
		
		listArea = new TextArea();
		listArea.setPrefHeight(200);
		add(listArea,0,3,1,1);  
	}
	
}
