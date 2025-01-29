package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private Socket socToRecieve ;
	private Socket socToSend ;
	
	private DataOutputStream dos;
	private FileInputStream fis;
	
	private DataInputStream dis;
	private FileOutputStream fos;
	
	private PrintWriter out; 
	private BufferedReader in;
	
	public Client() 
	{
		try 
		{
			this.socToRecieve=new Socket("localhost",80);
			this.out=new PrintWriter(this.socToRecieve.getOutputStream());
			this.in = new BufferedReader(new InputStreamReader(this.socToRecieve.getInputStream()));
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void GET(String FileName)
	{
		this.out.write("GET "+FileName);;
		
		File fileToSend = new File("data/FilesToSendToServers/FileToSendToServer.txt");
		
		if(fileToSend.exists() ==true)
		{
			try 
			{
				this.fis=new FileInputStream(fileToSend);
				this.dis= new DataInputStream(this.socToRecieve.getInputStream());	
				
				byte[] buffer = new byte[1028*5];
				int byteCount = 0;
				
				while((byteCount=this.fis.read(buffer))>0)
				{
					this.dos.write(buffer,0,byteCount);
					this.dos.flush();
				}
				
				this.dos.close();
				this.fis.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
	
	public void POST()
	{
		
	}
	
	
}
