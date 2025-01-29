package acsse.csc2a.supermarket.model;

public class CannedFood extends Food
{
	private double weight ;

	/**
	 * 
	 */
	public CannedFood(String barcode , String quality,double wieght) {
		super(barcode, quality);
		this.weight=wieght;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void display()
	{
		System.out.println(this.getBarcode()+"\t"+this.getQuality()+"\t"+this.getWeight()+"\t");
	}
	
	
	
	
}
