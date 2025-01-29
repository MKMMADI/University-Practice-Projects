import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class HttpServer implements Runnable{
	
	private ServerSocket sSocket = null;
	private Socket soc = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private DataOutputStream write =null;
	
	
	
	public void HttpServerSetUP() 
	{
		try
		{
			this.sSocket=new ServerSocket(4231);
			System.out.println("Server Running");
			this.soc=sSocket.accept();
			System.out.println("Connected");
			this.in=new BufferedReader(new InputStreamReader(soc.getInputStream()));
			this.out=new PrintWriter(soc.getOutputStream(),true);
			
			//Writing non textual data to client
			this.write = new DataOutputStream(soc.getOutputStream());
			
		String response = in.readLine();
		response = response.trim();
		String[] requestElements = response.split(" ");
		System.out.println("File Requestes "+requestElements[1]);
		if(requestElements[0].equalsIgnoreCase("GET"))
		{
			//get path
			String filepath="data"+requestElements[1];
			//create file 
			File httpFile = new File(filepath);
			
			
			//Initialize BufferedReader ,used to read in non textual data
			FileInputStream read = new FileInputStream(httpFile);
			
			
			//HTTP/1.1 200 OK
			write.writeBytes("HTTP/1.1 200 OK\r\n");
			//Date: Mon, 23 May 2005 22:38:34 GMT
			write.writeBytes("Date: "+new Date()+"\r\n");
			//Content-Type: text/html; charset=UTF-8
			write.writeBytes("Content-Type: text/html; charset=UTF-8\r\n");
			
			//Content-Length: 155
			write.writeBytes(String.valueOf(httpFile.length())+"\r\n");
			//Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT
			//Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)
			//ETag: "3f80f-1b6-3e1cb03b"
			//Accept-Ranges: bytes
			
			write.writeBytes("Connection : close\r\n");
			//Connection: close
			write.writeBytes("\r\n");
			
			//send file to client in bytes 
			byte[] buffer = new byte[2048];
			int numberOfBytesWritten = 0;
			
			//when you reach end of input stream the function returns a -1;
			while((numberOfBytesWritten=read.read())>0)
			{
				write.write(buffer,0, numberOfBytesWritten);
				write.flush();
			}
			
			write.writeBytes("\r\n");
			
			


			
			//send file size to Client.
			int fileLength=(int)httpFile.length();
		}
		
		}catch(UnknownHostException UHE)
		{
			UHE.printStackTrace();
		}catch(IOException IO)
		{
			IO.printStackTrace();
		}
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		HttpServer server=new HttpServer();
		server.HttpServerSetUP();
	}
}
