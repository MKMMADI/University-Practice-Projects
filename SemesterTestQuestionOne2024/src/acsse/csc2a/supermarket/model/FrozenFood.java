package acsse.csc2a.supermarket.model;

public class FrozenFood extends Food
{
	
	private int temperature ;
	private EDietType diet;
	/**
	 * @param temperature
	 * @param diet
	 */
	public FrozenFood(String barcode , String quality,int temperature, EDietType diet) 
	{
		super(barcode, quality);
		this.temperature = temperature;
		this.diet = diet;
	}
	/**
	 * @return the temperature
	 */
	public int getTemperature() {
		return temperature;
	}
	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	/**
	 * @return the diet
	 */
	public EDietType getDiet() {
		return diet;
	}
	/**
	 * @param diet the diet to set
	 */
	public void setDiet(EDietType diet) {
		this.diet = diet;
	}
	
	public void display()
	{
		System.out.println(this.getBarcode()+"\t"+this.getQuality()+"\t"+this.getDiet()+"\t"+this.getTemperature());
	}
	
	
	
	
}
