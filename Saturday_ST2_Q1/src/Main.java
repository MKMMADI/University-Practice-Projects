import java.util.Random;

import acsse.csc2a.ocean.model.Aqaurium;
import acsse.csc2a.ocean.model.Crustacean;
import acsse.csc2a.ocean.model.Fish;

public class Main 
{
	public static void main(String[] args)
	{
		Aqaurium FishHeadz = new Aqaurium();
		
		for(int i = 0 ; i < 10 ; i++ ) 
		{
			Random random = new Random();
			int n = random.nextInt();
			if((n%2)==0)
			{
				float toxicity = random.nextFloat(1f, 100f);
				float boancy = random.nextFloat(0.2f, 1.5f);
				FishHeadz.addAqautic(new Fish(toxicity,boancy));
			}
			else if((n%2)!=0)
			{
				float toxicity = random.nextFloat(1f, 100f);
				double eggCount = random.nextDouble(1.0,300.0);
				FishHeadz.addAqautic(new Crustacean(toxicity,eggCount));
			}
		}
		
		FishHeadz.reportTotalToxicity();
	}
}
