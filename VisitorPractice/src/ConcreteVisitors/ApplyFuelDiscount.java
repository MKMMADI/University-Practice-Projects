package ConcreteVisitors;

import CreditCards.DiamondCreditCard;
import CreditCards.GoldCreditCard;
import CreditCards.SilverCreditCard;
import Interfaces.Visitor;

public class ApplyFuelDiscount implements Visitor{

	@Override
	public void FuelDiscount(SilverCreditCard SV) 
	{
		// TODO Auto-generated method stub
		System.out.println("Applied Silver Credit card Discount");
		
	}

	@Override
	public void FuelDiscount(GoldCreditCard GC)
	{
		// TODO Auto-generated method stub
		System.out.println("Applied Gold Credit Card Discount");
		
	}

	@Override
	public void FuelDiscount(DiamondCreditCard DC) 
	{
		// TODO Auto-generated method stub
		System.out.println("Applied Diamond Credit Card Discount");
		
	}

}
