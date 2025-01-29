import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ServerHandler implements Runnable {

	
	private Socket socToRecieve ;
	private Socket socToSend ;
	
	private DataOutputStream dos;
	private FileInputStream fis;
	
	private DataInputStream dis;
	private FileOutputStream fos;
	
	private PrintWriter out; 
	private BufferedReader in;
	
	public ServerHandler(Socket soc)
	{
		
		try 
		{
			this.socToRecieve=soc;
			this.out = new PrintWriter(this.socToRecieve.getOutputStream());
			this.in = new BufferedReader(new InputStreamReader(this.socToRecieve.getInputStream()));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		boolean blnContinue = true;
		while(blnContinue==true)
		{
			try 
			{
				
				String message = this.in.readLine();
				
				if(message.contains("Connect"))
				{
					this.out.write("Established Connection");		
				}
				
				if(message.contains("Disconnect"))
				{
					this.out.write("Connection Ended");		
				}
				
				if(message.contains("GET"))
				{
					File fileToSend = new File("data/DataToSendToClient/FileWithNotingButOneDigit.txt");
					if(fileToSend.exists())
					{
						this.fis = new FileInputStream(fileToSend);
						this.dos=new DataOutputStream(this.socToRecieve.getOutputStream());
						
						byte[] buffer = new byte[1025*5];
						
						int bytesRead=0;
										
						while((bytesRead=fis.read(buffer))>0)
						{
							this.dos.write(buffer,0,bytesRead);
							this.dos.flush();
						}

						this.out.write("File Sent");
						this.out.close();
					}	
				}
				
				if(message.contains("POST"))
				{
					
					//read in file name 
					String filename = message.split(" ").toString().replaceAll("POST", "");
					//create file 
					File FileRecieved = new File("data/FileFromClient/"+filename+".txt");
					//read in file data
					
					//read in file bytes
					String file =this.in.readLine();
					
					//get file size
					int fileSize = file.length();				
				
					//initialise dos 
					this.dis = new DataInputStream(this.socToRecieve.getInputStream());
					
					//init. file output stream 
					this.fos=new FileOutputStream(FileRecieved);
					
					byte[] buffer = new byte[1028*8];
					int byteCount=0; 
					int totalBytes=0;
					
					while(totalBytes!=fileSize)
					{
						byteCount = this.dis.read(buffer,0,buffer.length);
						this.fos.write(buffer,0,byteCount);
						this.fos.flush();
						totalBytes++;
					}
					
					this.out.close();
				}
				
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
		}
	

	}

}
