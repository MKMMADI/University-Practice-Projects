package CreditCards;

import Interfaces.Visitable;
import Interfaces.Visitor;

public class DiamondCreditCard implements Visitable 
{

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.FuelDiscount(this);
	}

}
