package acsse.csc2a.ocean.model;

public abstract class Aquatic
{
	protected float toxicity ;
	
	public Aquatic(float toxicity)
	{
		this.toxicity=toxicity;
	}
	
	public Aquatic() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the toxicity
	 */
	public float getToxicity() {
		return toxicity;
	}

	/**
	 * @param toxicity the toxicity to set
	 */
	public void setToxicity(float toxicity) {
		this.toxicity = toxicity;
	}
	
	
	
	abstract float reportToxicity();
	
}
