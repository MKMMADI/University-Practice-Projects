package csc2b.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.File;
import java.io.FileInputStream;

public class FileHandler implements Runnable {
	
	private Socket incomingConnection;
	
	private PrintWriter txtout=null;
	private BufferedReader txtin=null;
	
	private DataOutputStream dos=null;
	private DataInputStream dis=null;
	
	private OutputStream os=null;
	private InputStream is=null;

	private boolean processing;

	public FileHandler(Socket connection) {
		this.incomingConnection = connection;
		
		try {
			os = incomingConnection.getOutputStream();
			is = incomingConnection.getInputStream();
			
			dos = new DataOutputStream(os);
			dis = new DataInputStream(is);
			
			txtout = new PrintWriter(os);
			txtin = new BufferedReader(new InputStreamReader(is));			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Server ready to process files");
		
		processing=true;
		
		while(processing) {
			try {
				String command = txtin.readLine();
				System.out.println("Command: " + command);
				
				if(command.equals("RETURN")) {
					File fileToReturn = new File("data/server/beautifulSong.mp3");
					
					if(fileToReturn.exists()) {
						txtout.println(fileToReturn.length());
						txtout.flush();
						
						FileInputStream fis = new FileInputStream(fileToReturn);
						
						byte[] buffer = new byte[2048];
						
						int n=0;
						
						while((n=fis.read(buffer))>0) {
							dos.write(buffer,0,n);
							dos.flush();
						}
						fis.close();
						
						System.out.println("File sent to client");
						
						processing = false;
						
					}
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
}
