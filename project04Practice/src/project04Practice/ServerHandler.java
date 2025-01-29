package project04Practice;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandler implements Runnable 
{
	private Socket soc ;
	private InputStream is;
	private OutputStream os;
	private DataInputStream dis;
	private DataOutputStream dos;
	private PrintWriter out;
	private BufferedReader in;
	
	private boolean processing=true;	
	
	public ServerHandler(Socket soc) 
	{
		try 
		{
			this.soc=soc;

			this.is=soc.getInputStream();
			this.os=soc.getOutputStream();
			
			this.dis=new DataInputStream(is);
			this.dos=new DataOutputStream(os);
			
			this.in = new BufferedReader(new InputStreamReader(is));
			this.out=new PrintWriter(os,true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public void run() 
	{
		System.out.println("Server ready to process user ccommands.");
		while(processing)
		{
			try 
			{
				String command = this.in.readLine();
				System.out.println("User command is : " + command);
				
				if(command.contains("LST"))
				{
					File filetoSend = new File("data/server/list.txt");
					
					if(filetoSend.exists())
					{
						this.out.println(filetoSend.length());
						this.out.flush();
						System.out.println("Sent file size to client.");
						
						FileInputStream fis = new FileInputStream(filetoSend);
						byte[] buffer = new byte[1028];
						int n = 0;
						
						while((n=fis.read(buffer))>0)
						{
							dos.write(buffer,0,n);
							dos.flush();
						}
						fis.close(); 
						System.out.println("File Sent Successfully");
					}
				}
				
				if(command.contains("RET"))
				{
					File fileTosend = new File("data/server/Practical 6.pdf");

					if(fileTosend.exists())
					{
						long fileSize = fileTosend.length();
						this.out.println(fileSize);
						
						System.out.println();
						FileInputStream fis = new FileInputStream(fileTosend);
						byte[] buffer = new byte[1028*5];
						int byteCount=0;
						
						while((byteCount=fis.read(buffer))>0)
						{
							dos.write(buffer, 0, byteCount);
							dos.flush();
						}
						fis.close();
						System.out.println("Successfully wrote to file.");						
					}
					
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
