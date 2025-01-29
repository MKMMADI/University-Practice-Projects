import java.util.Random;

public class printA implements Runnable{

	private int NumberOfIterations ;
	
	public printA(int numIterations)
	{
		this.NumberOfIterations = numIterations;
	}
	public void print()
	{
		Random  gen = new Random();
		
		for(int i= 0 ;i<this.NumberOfIterations;i++)
		{
			if(this.NumberOfIterations < 10)
			{
				System.out.println(gen.nextInt(1,this.NumberOfIterations));
			}
			
			if(this.NumberOfIterations >= 10)
			{
				System.err.println(gen.nextInt(1,this.NumberOfIterations));
			}
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		this.print();
	}
}
