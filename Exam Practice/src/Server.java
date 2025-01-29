import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
	private ServerSocket SS ;
	private Socket socket;
	
	
	public Server(int port)
	{
		try
		{
			this.SS= new ServerSocket(port);
			this.socket = SS.accept();
			
			new Thread(new ServerHandler(socket));
	
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}	
	
}