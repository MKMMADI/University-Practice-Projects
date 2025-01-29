import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import acsse.csc2a.supermarket.file.FoodFileHandler;
import acsse.csc2a.supermarket.model.Store;

public class Main 
{

	public static void main(String[] args) 
	{
		ArrayList<Store> Stores = new ArrayList<Store>();
		File Files = new File("data");
		
		String[] strFiles = Files.list();
		
		for(String Store : strFiles)
		{
			
			Stores.add(FoodFileHandler.readStore(new File("data/"+Store)));
		}
		
		boolean blnContinue=true;
		Scanner in = new Scanner(System.in);
		do
		{
			
			System.out.println("Choose an Option :");
			System.out.println("1.Show Frozen Food.");
			System.out.println("2. Show Canned Food.");
			System.out.println("3. Exit.");
			int choice = in.nextInt();
			
			switch(choice)
			{
				case 1:
				{
					System.out.println("BarCode\tQuality\tWieght");
					for(int i = 0 ; i< Stores.size();i++)
					{
						Stores.get(i).display(choice);
					}
					break;
				}
				
				case 2:
				{
					for(int i = 0 ; i< Stores.size();i++)
					{
						Stores.get(i).display(choice);	
					}
					break;
				}
					
				
			}
			
		}while(blnContinue);
		in.close();
		
	}
}