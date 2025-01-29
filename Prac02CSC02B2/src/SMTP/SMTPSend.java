package SMTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SMTPSend
{

	public SMTPSend(String HostName ,String Port, String From , String To , String Message) 
	{

		Socket soc = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String response = "";
		
		try
		{
			soc=new Socket(HostName,Integer.parseInt(Message));
			out=new PrintWriter(soc.getOutputStream(),true);
			in=new BufferedReader(new InputStreamReader(soc.getInputStream()));
			
			out.println("HELO " + InetAddress.getLocalHost().getCanonicalHostName());
			response=in.readLine();
			System.out.println(response);
			response="";
			
			out.println("MAIL FROM <"+From+">");
			response=in.readLine();
			System.out.println(response);
			response="";
			
			out.println("RCPT TO <"+To+">");
			response=in.readLine();
			System.out.println(response);
			response="";
			
			out.println("DATA");
			response=in.readLine();
			System.out.println(response);
			response="";
			
			out.println(Message);
			out.println(".");
			response=in.readLine();
			System.out.println(response);
			
			out.println("QUIT");
			response=in.readLine();
			System.out.println(response);
			response="";
					
			
		}catch(UnknownHostException UHE)
		{
			UHE.printStackTrace();
		}catch(IOException IO)
		{
			IO.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		new SMTPSend("smtp.example.com", "25", "bob@example.org", "alice@example.com", 
                "Hello Alice.\nThis is a test message with 5 header fields and 4 lines in the message body.\nYour friend,\nBob");	
	}
	
}
