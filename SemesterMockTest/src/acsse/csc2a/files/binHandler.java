package acsse.csc2a.files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class binHandler
{
	public static void binWriter()
	{
		try(DataOutputStream DOS = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("data/file.dat")))))
		{
			DOS.writeUTF("PR01 Gauteng 2 23:59 \n");
			DOS.writeUTF("PR02 Limpopo 3 01:34 \n");
			DOS.writeUTF("CT01 Durban 2 23:59 \n");
			DOS.writeUTF("PR03 Western Cape \n");
			DOS.writeUTF("PR## Eastern Cape 2 12:59 \n");
			
			System.out.println("Wrote To File Successfuly");
			
		}catch(IOException IO)
		{
			IO.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void binReader(File binFile)
	{
		try(BufferedReader DIS = new BufferedReader(new FileInputStream(new File("data/file.dat"))),"UTF-8")))
		{
			String Line = DIS;
			String Regex = "PR0[1-9]\\s([A-Z][a-z]+)\\s(\\d)+\\s([0-1][0-9]|[2][0-3])";
			Pattern PTN = Pattern.compile(Regex);
			Matcher MT = PTN.matcher(Regex);
			
			
			while(DIS.readLine()!=null)
			{
				String Line=DIS.readUTF();
			}
			System.out.println("Read From File Successfuly");
			
		}catch(IOException IO)
		{
			IO.printStackTrace();
		}
	}
}
