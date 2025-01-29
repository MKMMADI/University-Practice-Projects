package csc2b.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket ss;
	private boolean ready;
	
	public static void main(String[] args) {
		Server server = new Server(1234);
	}
	
	public Server(int port) {
		try {
			ss = new ServerSocket(port);
			System.out.println("Server started on port " + port);
			ready = true;
			
			while(ready) {
				Socket connection = ss.accept();
				Thread t = new Thread(new FileHandler(connection));
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
