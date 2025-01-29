/**
 * 
 */
package acsse.csc2a.fmb.file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import acsse.csc2a.fmb.model.E_COLOUR;
import acsse.csc2a.fmb.model.Firework;
import acsse.csc2a.fmb.model.FireworkDisplay;
import acsse.csc2a.fmb.model.PyroTechnician;

/**
 * 
 */
public class DisplayFileHandler 
{

	public FireworkDisplay readDisplay(String FilePath, int iterator) 
	{
		
		int counter = 0;
		FireworkDisplay Display = null;

		
		try (Scanner in = new Scanner(new File("./data/" + FilePath))) 
		{
			
			
			while (in.hasNextLine() == true) 
			{
				
				
				counter++;
				String Line = "";
				Line = in.nextLine();
				StringTokenizer Split = new StringTokenizer(Line, "\t");

				if (counter == 1) 
				{
					if (this.ValidateFireworkDisplayInformation(Line) == true) 
					{
						
						String displayID=Split.nextToken(); 				// a unique alphanumeric ID of the Firework Display
						String displayName=Split.nextToken(); 			// The name of the Firework Display
						String displayTheme=Split.nextToken();			// The theme of the Firework Display
						PyroTechnician TempTech=new PyroTechnician();
						Display = new FireworkDisplay(displayID, displayName, displayTheme, TempTech);
					 
						
					} else 
					{						
						System.err.println("FireworkDisplay details do not meet required match standards.");
						System.out.println(Line);
						System.out.println("File number : " + (iterator + 1) + " ,Line : " + counter);
						break;
					}
				}
				
				
				if (counter == 2) 
				{

					if (this.ValidateTechnicainDetails(Line) == true) 
					{
						String strline = Split.nextToken();
						StringTokenizer Token = new StringTokenizer(strline,"-");
						
						String TempFirstName = Token.nextToken();
						String TempLastName = Token.nextToken();
						String TempPhoneNumber = Split.nextToken();
						
						PyroTechnician TempTechnician = new PyroTechnician(TempFirstName, TempLastName,TempPhoneNumber);
						Display.setLeadTechnician(TempTechnician);
						
						
					} else 
					{
						System.err.println("Technician Details do meet required match standards.");
						System.out.println(Line);
						System.out.println("File number : " + (iterator + 1) + " ,Line : " + counter);
						break;
					}
				}

				if (counter > 2) 
				{
					if (this.ValidateFirework(Line) == true)
					{
						String fireworkID = Split.nextToken(); // a unique alphanumeric ID of the firework
						String fireworkName = Split.nextToken(); // The name of the firework
						double fuseLength = Double.parseDouble(Split.nextToken()); // Controls when the explosion will
						// occur in seconds
						E_COLOUR colour = this.checkColour(Split.nextToken());
						Firework NewFireWork = new Firework(fireworkID, fireworkName, fuseLength, colour);
						Display.addFireWork(NewFireWork);
					} else 
					{
						System.err.println("Firework Details do meet required match standards.");
						System.out.println(Line);
						System.out.println("File number : " + (iterator + 1) + " ,Line : " + counter);
					}
					
				}
				
			}

		} catch (IOException e) 
		{
			System.err.println(e.getMessage());
		}
		

		return Display;

	}

	public boolean ValidateFireworkDisplayInformation(String Line) 
	{
		String ptn = "(FD\\d{4})\t((\\[)[\\w\\s]+(\\]))\t((\\\")[\\w\\s]+(\\\"))";
		Pattern PT = Pattern.compile(ptn);
		Matcher MT = PT.matcher(Line);

		if (MT.matches()) {
			return true;
		} else {
			return false;
		}
	}

	private boolean ValidateFirework(String line) 
	{
		String ptn = "[F][W]\\d{6}(\\t)(([A-Z]{1}[a-z]+)(\\s)([A-Z]{1}[a-z]+))(\\t)(\\d[\\.][1-9]+)(\\t)([A-Z]+)";
		Pattern PT = Pattern.compile(ptn);
		Matcher MT = PT.matcher(line);

		if (MT.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean ValidateTechnicainDetails(String Line) 
	{

		String ptn = "(([A-Z])([a-z])+)(\\-)(([A-Z])([a-z])+)(\t)([1-9]\\d{2})(\\-)(\\d{3})(\\-)(\\d{3}[1-9])";
		Pattern PT = Pattern.compile(ptn);
		Matcher MT = PT.matcher(Line);

		if (MT.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public E_COLOUR checkColour(String Colour) 
	{
		E_COLOUR Temp = null;
		switch (Colour) 
		{
			case "RED": {
				Temp = Temp.RED;
				break;
			}
	
			case "GREEN": {
				Temp = Temp.GREEN;
				break;
			}
	
			case "BLUE": {
				Temp = Temp.BLUE;
				break;
			}
	
			case "YELLOW": 
			{
				Temp = Temp.YELLOW;
				break;
			}
	
			case "MAGENTA": 
			{
				Temp = Temp.MAGENTA;
				break;
			}
	
			case "WHITE": 
			{
				Temp = Temp.WHITE;
				break;
			}
	
			case "ORANGE": 
			{
				Temp = Temp.ORANGE;
				break;
			}
	
			case "CYAN": 
			{
				Temp = Temp.CYAN;
				break;
			}
		}
		return Temp;
	}

}
