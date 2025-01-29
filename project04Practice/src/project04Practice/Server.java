package project04Practice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
	private ServerSocket ss;
	
	
	public Server(int port)
	{
		try 
		{
			this.ss= new ServerSocket(port);
			System.out.println("Bound to port number : "+port);
			
			Socket soc = ss.accept();
			System.out.println("Connected to client");
			
			Thread task =new Thread(new ServerHandler(soc));
			
			task.start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server(4321);
	}

}
