package acsse.csc2a.ocean.model;

public class Fish extends  Aquatic 
{

	private float boancy;

	/**
	 * @param toxicity
	 */
	public Fish(float toxicity , float boancy) 
	{
		super(toxicity);
		this.boancy=boancy;
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @return the boancy
	 */
	public float getBoancy() 
	{
		return boancy;
	}

	
	
	/**
	 * @param boancy the boancy to set
	 */
	public void setBoancy(float boancy) 
	{
		this.boancy = boancy;
	}
	
	
	@Override
	public float  reportToxicity()
	{
		return this.toxicity/this.boancy;
	}
	
	

}
