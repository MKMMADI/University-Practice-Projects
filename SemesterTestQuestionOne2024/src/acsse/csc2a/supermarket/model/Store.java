package acsse.csc2a.supermarket.model;

import java.util.ArrayList;

public class Store 
{
	ArrayList<Food> Foods;

	/**
	 * @param foods
	 */
	public Store(ArrayList<Food> foods) 
	{
		Foods = foods;
	}

	/**
	 * @return the foods
	 */
	public ArrayList<Food> getFoods() 
	{
		return Foods;
	}

	/**
	 * @param foods the foods to set
	 */
	public void setFoods(ArrayList<Food> foods) {
		Foods = foods;
	}
	
	public Food getAtFoodIndex(int index)
	{
		return this.Foods.get(index);
	}
	
	public void addFoodToList(Food item)
	{
		this.Foods.add(item);
	}
	
	public void display(int Choice)
	{
		for(int i = 0 ; i < this.Foods.size();i++)
		{
			if (Choice == 1)
			{
				if(this.Foods.get(i)instanceof FrozenFood)
				{
					FrozenFood Temp = (FrozenFood)this.Foods.get(i);
					Temp.display();	
				}
			}
			
			if (Choice == 2)
			{
				if(this.Foods.get(i)instanceof CannedFood)
				{
					CannedFood Temp = (CannedFood)this.Foods.get(i);
					Temp.display();	
				}
			}
			
		}
			
	}
	
	
}
