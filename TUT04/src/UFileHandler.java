import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class UFileHandler implements Runnable {

	private Socket incomingSocketConnection= null;

	private PrintWriter txtout = null;
	private BufferedReader txtin= null;
	
	private DataOutputStream dos = null;
	private DataInputStream dis = null;
	
	private OutputStream os = null;
	private InputStream is = null;
	
	private boolean processing ;
	
	
	
	public UFileHandler(Socket incominSocketConnection)
	{
		this.incomingSocketConnection=incominSocketConnection;
		
		try
		{
			os = incominSocketConnection.getOutputStream();
			is=incomingSocketConnection.getInputStream();
			
			dos = new DataOutputStream(os);
			dis = new DataInputStream(is);
			
			
			txtout = new PrintWriter(os);
			txtin = new BufferedReader(new InputStreamReader(is));
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Server Ready To Process Commands");
		this.processing=true;
		
		
		try
		{
			while(processing)
			{
				String commandline = txtin.readLine();
				System.out.println("Command : "+commandline);
				
				if(commandline.equals("RETURN"))
				{
					//FILE ID AS NEXT TOKEN
					
						File fileToReturn = new File("data/server/CNdebe.png");
						
						
						if(fileToReturn.exists())
						{
							System.out.println("The file to be sent exists");
							txtout.println(fileToReturn.length());
							txtout.flush();
							
							//sending binary file 
							
							try (FileInputStream fis = new FileInputStream(fileToReturn)) {
								byte[] buffer = new byte[2048];
								int n = 0;
								
								while((n = fis.read(buffer))>0)
								{
									dos.write(buffer,0,n);
									dos.flush();
									System.out.println("file size and file sent to client!");
								}
							}
						}
				}
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
























