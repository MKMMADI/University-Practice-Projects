import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.concurrent.Task;

public class Server {
	
	private ServerSocket ss;
	private Socket soc ;
	
	public Server(int Port ) {
		// TODO Auto-generated constructor stub
		
		try 
		{
			ss=new ServerSocket(Port);

			
			while(true)
			{
				soc=ss.accept();
				System.out.println("Connection Established.");
				
				Thread task = new Thread(new ServerHandler(soc));
				task.start();
			}
				
		}catch(IOException IO)
		{
			System.out.println(IO.getMessage());
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			InetAddress Address = InetAddress.getLoopbackAddress();
			System.out.println(Address.toString());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
