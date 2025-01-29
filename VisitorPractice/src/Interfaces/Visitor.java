package Interfaces;

import CreditCards.DiamondCreditCard;
import CreditCards.GoldCreditCard;
import CreditCards.SilverCreditCard;

public interface Visitor 
{
	void FuelDiscount(SilverCreditCard SV);
	void FuelDiscount(GoldCreditCard GC);
	void FuelDiscount(DiamondCreditCard DC);
}
