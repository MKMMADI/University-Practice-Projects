package acsse.csc2a.supermarket.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import acsse.csc2a.supermarket.model.CannedFood;
import acsse.csc2a.supermarket.model.EDietType;
import acsse.csc2a.supermarket.model.Food;
import acsse.csc2a.supermarket.model.FrozenFood;
import acsse.csc2a.supermarket.model.Store;

public class FoodFileHandler 
{
	public static Store readStore(File FileHandle)
	{
		ArrayList<Food> Foods = new ArrayList<Food>();
		StringTokenizer Split = null;
		try(Scanner SC = new Scanner(FileHandle) )
		{
			
			String Line="";
		
			while(SC.hasNext())
			{
				
				Line = SC.nextLine();
				Split=new StringTokenizer(Line,"\t");
				
				if(isCannedFoodType(Line)==true)
				{
					String barcode = Split.nextToken();
					String quality=Split.nextToken();
					double wieght=Double.parseDouble(Split.nextToken());
					CannedFood Temp = new CannedFood(barcode, quality, wieght);
					Foods.add(Temp);
				}
				else 
				{
					if(isFrozenFood(Line)==true)
					{
						
						String barcode=Split.nextToken() ;
						String quality=Split.nextToken();
						EDietType diet=parseToEDiet(Split.nextToken());
						int temperature=Integer.parseInt(Split.nextToken());
						
						FrozenFood Temp = new FrozenFood(barcode, quality, temperature, diet);
						Foods.add(Temp);
					}
				}
				Line="";
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		Store tempStore = new Store(Foods);
		return tempStore;
	}

	private static EDietType parseToEDiet(String nextToken) 
	{
		EDietType Temp = null ;
		switch(nextToken)
		{
			case "VEGETARIAN":
			{
				Temp=EDietType.VEGETARIAN;
				break;
			}
		
			case "LACTOFREE":
			{
				Temp=EDietType.LACTOFREE;
				break;
			}
			
			case "MEAT":
			{
				Temp=EDietType.MEAT;
				break;
			}
			
			case "VEGAN":
			{
				Temp=EDietType.VEGAN;
				break;
			}
			
			default:
			{
				System.err.println("Invalid ENUM TYPE");
				System.err.println(nextToken);
				
				break;
			}
		
		}
		
		return Temp;
	}

	private static boolean isFrozenFood(String line) 
	{
		//OOD_BARCODE FOOD_QUALITY FROZENFOOD_DIET FROZENFOOD_TEMPERATURE

		String regex = "([A-Z]{4})(\\d{2})([A-Z]{2})(\\t)((\\w)+)(\\t)([A-Z]+)(\\t)([-]?\\d+)";
		Pattern PTN = Pattern.compile(regex);
		Matcher MTN = PTN.matcher(line);
		
		if(MTN.matches())
		{
			return true;
		}else
		{
			return false;
		}
	}

	private static boolean isCannedFoodType(String line) 
	{
		//FOOD_BARCODE FOOD_QUALITY CANNEDFOOD_WEIGHT
		String regex = "([A-Z]{4})(\\d{2})([A-Z]{2})(\\t)((\\w)+)(\\t)(\\d+[.]\\d+)";
		Pattern PTN = Pattern.compile(regex);
		Matcher MTN = PTN.matcher(line);
		
		if(MTN.matches())
		{
			return true;
		}else
		{
			return false;
		}
	}
}
