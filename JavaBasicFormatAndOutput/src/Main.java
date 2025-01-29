import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.canvas.GraphicsContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int One = in.nextInt();
		GraphicsContext gc ;
		System.out.printf("My name  %s .\n Age : %d \n Bank Balance : %01.2f \n ","Katlego ",12,12.75468);
		ArrayList<Integer> Numbers = new ArrayList<>();
		Numbers.add(1);
		Numbers.add(2);
		Numbers.add(3);
		int my =1;
		int max = Numbers.get(1);
		for(int i = 2 ; i < Numbers.size();i++)
		{
			if(Numbers.get(i)>max)
			{
				max = Numbers.get(i);
			}
		}
		
		System.err.println(max);
		
	}	
	
	public boolean validate() 
	{
		return false;
		
	}
	
	

}
