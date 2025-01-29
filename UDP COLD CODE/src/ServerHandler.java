import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class ServerHandler implements Runnable {
	
	DatagramSocket socSend;
	DatagramSocket socReceive;
	
	DatagramPacket packSend;
	DatagramPacket packRecieve;
	
	Socket ClientConnection;
	
	BufferedWriter bw;
	BufferedReader br;
	

	public ServerHandler(Socket soc) {
		// TODO Auto-generated constructor stub
		
		ClientConnection=soc;
		try 
		{
			
			br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		boolean blnContinue = true;
		
		try {
			while(blnContinue==true)
			{
				String Command = br.readLine();
				
				if(Command.contains("HELLO"))
				{
					bw.write("Command Recieved");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		

	}

}
