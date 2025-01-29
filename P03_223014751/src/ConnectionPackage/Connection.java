package ConnectionPackage;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection  implements Runnable{

	public void connect(String filename,int Port)
	{
		Socket Connect=null;
		ServerSocket ServerConnection=null;
	
		File file=null;
		try {
			 file=new File(filename);
			ServerConnection=new ServerSocket(Port);
			Connect=ServerConnection.accept();
			Send("GET / HTTP/1.0\\n\\n",Connect);
			ReadFile(file,Connect);
			Send("CONNECT / HTTP/1.0\\n\\n",Connect);
			ReadFile(file,Connect);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("could not connect to server");		
			}
		finally
		{
		if(ServerConnection!=null)
		{
			try {
				ServerConnection.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(Connect!=null)
		{
			try {
				Connect.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}
	
	
	//function to send protocols
	public void Send(String command,Socket socket)
	{
		PrintWriter write=null;
		BufferedReader read=null;
	try {
		 write=new PrintWriter(socket.getOutputStream(),true);
		 read=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		 write.println(command);
		 write.flush();
		 String response=read.readLine();
		switch(response)
		{
			case "404":
				 System.err.println("content cannot be found.");
				 break;
			case "500":
				 System.err.println("an error has occured");
				 break;
			default:
				 System.out.println(response);
				break;
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
	System.err.println("Could not write to server");	}
	finally
	{
		if(write!=null)
		{
			write.close();
		}
	}
	}
	
	public void ReadFile(File file,Socket socket)
	{	
		//create a file inputStream 
	FileInputStream fis=null;
	
	DataOutputStream dos=null;
	final int ByteSize=2048;
	try {
		
		dos=new DataOutputStream(socket.getOutputStream());
		Send(Long.toString(file.length()),socket);
		dos.flush();
		fis=new FileInputStream(file);
		byte[] Byte=new byte[ByteSize];
		int n=0;
		while((n=fis.read(Byte))>0)
		{
			dos.write(Byte,0,n);
			dos.flush();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
	System.err.println("An IO exception has occured");
	}finally
	{
		if(dos!=null)
		{
			try {
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(fis!=null)
		{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		connect("data/Durban.html",4321);
		connect("data/Joburg.html",4321);
		connect("data/CapeWithImage.html",4321);
		
	}


	
	
	
}
