import java.io.File;
import java.util.ArrayList;

import acsse.csc2a.plant.file.PerennialFileHandler;
import acsse.csc2a.plant.model.Perennial;
import acsse.csc2a.plant.model.Shrub;
import acsse.csc2a.plant.model.Tree;

public class Main 
{

	public static void main(String[] args) 
	{
		File files = new File("./data");
		String[] strFiles = files.list();
		ArrayList<Perennial> Perennials = new ArrayList<Perennial>();
		
		for(String file : strFiles)
		{
			Perennials.addAll(PerennialFileHandler.readPerennials(new File("./data/"+file)));
		}
		
		for(Perennial p : Perennials)
		{
			if(p instanceof Shrub Shrub)
			{
				System.out.println(Shrub.toString());
			}else 
			if(p instanceof Tree Tree)
			{
				System.err.println(Tree.toString());
			}
		}

	}

}
