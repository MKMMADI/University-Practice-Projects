import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientServer 
{

	public static void main(String[] args) 
	{
	
		try 
		{
			System.out.println("Waiting for clients");
			ServerSocket ss = new ServerSocket(9806);
			Socket s = ss.accept();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = br.readLine();
			PrintWriter pw = new  PrintWriter(s.getOutputStream(),true);
			pw.println("server says : " + str);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
