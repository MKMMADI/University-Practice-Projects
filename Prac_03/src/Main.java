import java.io.File;
import acsse.csc2a.fmb.file.DisplayFileHandler;
import acsse.csc2a.fmb.model.FireworkDisplay;

public class Main {
	
	public static void main(String[] args)
	{
		DisplayFileHandler Read = new DisplayFileHandler();
		
		File data = new File("./data");
		int Counter = 13;
		String[] FilePaths = new String[Counter];
		String Greet = new String(FilePaths[0]);
		System.out.println(Greet);
		
		Counter=0;
		for(File files : data.listFiles())
		{
			FilePaths[Counter]=files.getName();
			Counter++;
		}
		
		FireworkDisplay[] FireworkDisplays = new FireworkDisplay[Counter+1];
	
		for(int i =0;i<FilePaths.length;i++)
		{
			FireworkDisplays[i] =Read.readDisplay(FilePaths[i],i);
		}
		
		System.out.println();
		
		for(FireworkDisplay FD : FireworkDisplays)
		{
			if(FD!=null) 
			{
				if(FD.getDisplayName()!=null || FD.getLeadTechnician().getFullName()!=null)
				{
					FD.printDisplay();
					System.out.println();
					
				}
			}
		}
	}

}
