package acsse.csc2a.Generic;

import java.util.ArrayList;

public class CollectionOfTypes<T> 
{
	public T[] CollectionOfItems;
	public int ArrayLength;
	
	@SuppressWarnings("unchecked")
	public CollectionOfTypes(ArrayList<T> Items)
	{
		this.ArrayLength=Items.size();
		
		this.CollectionOfItems=(T[])(new Object[this.ArrayLength]);

		int index=0;
		for(T item : Items)
		{
			this.CollectionOfItems[index]=item;
			index++;
		}
		
		
	}
	
	
	public void printArrayList()
	{
		for(T item : this.CollectionOfItems)
		{
			System.out.println(item);
		}
	}
}
