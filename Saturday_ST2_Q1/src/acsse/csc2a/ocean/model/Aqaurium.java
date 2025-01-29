package acsse.csc2a.ocean.model;

import java.util.ArrayList;

public class Aqaurium 
{
	ArrayList<Aquatic> Aquatics = new ArrayList<>();
	
	
	public Aquatic getAqautic(int index)
	{
		
		return this.getAqautic(index);
	}
	
	public void addAqautic(Aquatic newAqautic)
	{
		this.Aquatics.add(newAqautic);
	}
	
	
	
	/**
	 * @return the aquatics
	 */
	public ArrayList<Aquatic> getAquatics() {
		return Aquatics;
	}

	/**
	 * @param aquatics the aquatics to set
	 */
	public void setAquatics(ArrayList<Aquatic> aquatics) {
		Aquatics = aquatics;
	}

	public void reportTotalToxicity()
	{
		for(Aquatic Aq : this.Aquatics)
		{
			if(Aq instanceof Fish)
			{
				Fish Instance = (Fish)Aq;
				System.out.printf("Fish Toxixity : %f\n",Instance.reportToxicity());
			}else
			{
				Crustacean Instance = (Crustacean)Aq;
				System.out.printf("Crustacean Toxixity : %f\n",Instance.reportToxicity());
			}
			
		}
	}
}
