import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

	ServerSocket ss = null;
	Socket soc = null;
	PrintWriter out = null;
	BufferedReader in = null;

	public Server(int port) {
		// TODO Auto-generated constructor stub

		try {
			this.ss = new ServerSocket(port);
			this.soc = ss.accept();
			System.out.println("Successfully connected with client");

			in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			out = new PrintWriter(soc.getOutputStream(), true);
			int NumberOfResponses = 0;

			NumberOfResponses++;
			out.println(
					"0" + NumberOfResponses + "HELLO - you may make 4 requests and I'll provide weather information.");
			String request = in.readLine();
			int NumberOfUserRequests = 0;
			int requestCounter = 0;

		
		} catch (UnknownHostException UHE) {
			UHE.printStackTrace();
		} catch (IOException IO) {
			IO.printStackTrace();
		}

	}

}
