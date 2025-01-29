import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket ss;
	private boolean ready;
	
	public Server(int port)
	{
		try {
			ss= new ServerSocket(port);
			System.out.println("Server Connected To Port");
			ready=true;
			
			while(ready)
			{
				//accept client connection
				Socket incomingConnection = ss.accept();
				
				
				Thread t = new Thread(new UFileHandler(incomingConnection));
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Server server = new Server(2022);
	}

}
