import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class PortIterator 
{
	
	public PortIterator() 
	{
		IteratePorts();
	}
	
	private void IteratePorts()
	{
		Socket soc = null;
		for(int i = 1 ; i <= 65535 ; i+= 3)
		{
			
			try 
			{
				soc= new Socket(InetAddress.getLocalHost(),i);
				
				if(soc.isConnected()==true)
				{
					System.out.println("Program connected to LocalHost port : " + i);
					System.out.println("Local port of the connection : " + soc.getLocalPort());
					System.out.println("Remote port of the connection : "+soc.getPort());
				}else
				{
					System.err.println("Could not Connect to Localhost at port : "+ i);
				}
				
				System.out.println("The Computer IP Address is : "+ soc.getInetAddress().getHostAddress());
				
			}catch(UnknownHostException UHE)
			{
				UHE.printStackTrace();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			soc=null;

		}
	}
}
