package acsse.csc2a.ocean.model;

public class Crustacean extends Aquatic
{
	private double eggCount ; 
	
	/**
	 * @param toxicity
	 * @param eggCount
	 */
	public Crustacean(float toxicity, double eggCount) {
		super(toxicity);
		this.eggCount = eggCount;
	}

	/**
	 * @return the eggCount
	 */
	public double getEggCount() {
		return eggCount;
	}

	/**
	 * @param eggCount the eggCount to set
	 */
	public void setEggCount(double eggCount) {
		this.eggCount = eggCount;
	}





	@Override
	public float reportToxicity() 
	{
		return this.toxicity*(float)this.eggCount;
	}
	
	
}
