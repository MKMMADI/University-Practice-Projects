import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

	public static void main(String[] args) 
	{
		try 
		{
			System.out.println("Client Started");
			Socket soc = new Socket("localhost",9806);
			BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter a string");
			String msg = br.readLine();
			PrintWriter pw = new PrintWriter(soc.getOutputStream(),true);
			pw.println(msg);
			BufferedReader  brIn = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			System.out.println(brIn.readLine());
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
		
	}

}
