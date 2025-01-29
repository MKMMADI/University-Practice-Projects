import ConcreteVisitors.ApplyFuelDiscount;
import CreditCards.DiamondCreditCard;
import CreditCards.GoldCreditCard;
import CreditCards.SilverCreditCard;
import Interfaces.Visitor;

public class Client {

	public static void main(String[] args) 
	{
		GoldCreditCard GC = new GoldCreditCard();
		SilverCreditCard SV = new SilverCreditCard();
		DiamondCreditCard DC = new DiamondCreditCard();
		
		ApplyFuelDiscount Apply = new ApplyFuelDiscount();
		GC.accept(Apply);
		SV.accept(Apply);
		DC.accept(Apply);
	}

}
