package acsse.csc2a.plant.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import acsse.csc2a.plant.model.EHARDNESS;
import acsse.csc2a.plant.model.Perennial;
import acsse.csc2a.plant.model.Shrub;
import acsse.csc2a.plant.model.Tree;

public class PerennialFileHandler {

	public static ArrayList<Perennial> readPerennials(File file) 
	{
		ArrayList<Perennial> Perennials= new ArrayList<Perennial>();
		
		try(Scanner SC = new Scanner(file))
		{
			String Line = "";
			while(SC.hasNextLine())
			{
				Line="";
				Line=SC.nextLine();
				String ID ; 
				String Type;
				double hieght;
				int growthRate;
				EHARDNESS hardness;
				StringTokenizer parse = new StringTokenizer(Line,"\t");
				if(isShrub(Line)==true)
				{
				
					ID=parse.nextToken();
					Type = parse.nextToken();
					hieght=Double.parseDouble(parse.nextToken());
					Perennials.add(new Shrub(ID, Type, hieght));
				}else
				{
					if(isTree(Line)==true)
					{
						ID=parse.nextToken();
						Type = parse.nextToken();
						growthRate=Integer.parseInt(parse.nextToken());
						hardness = EHARDNESS.valueOf(parse.nextToken());
						Perennials.add(new Tree(ID, Type, growthRate, hardness));

					}
				}
				}
		}catch (Exception e) 
		{
			e.getMessage();
		}
		return Perennials;
	}

	private static boolean isTree(String line) 
	{
		String regex = "[A-Za-z0-9]{8}\\t[A-Za-z]+\\t\\d+\\t[HARDWOOD|PSEUDOWOOD|SOFTWOOD]";
		Pattern PTN = Pattern.compile(regex);
		Matcher MT = PTN.matcher(line);
		
		if(MT.matches())
		{
			return true;
		}else 
		{
			return false;
		}
	}

	private static boolean isShrub(String line) 
	{
		String regex = "[A-Za-z0-9]{8}\\t[A-Za-z]+\\t\\d+[.]\\d+";
		Pattern PTN = Pattern.compile(regex);
		Matcher MT = PTN.matcher(line);
		
		if(MT.matches())
		{
			return true;
		}else 
		{
			return false;
		}
	}

}
