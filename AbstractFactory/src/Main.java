import java.util.Random;

public class Main {
	public static void main(String[] args)
	{
		Vehicle v ;
		
		Random gen = new Random();
		
		int rand = gen.nextInt();
		
		if(rand%2==0)
		{
			v=new Ford();
		}else
		{
			v=new Toyota();
		}
		
		VehicleFactory Factory = new VehicleFactory(v);
		Factory.creatCar();
	}
}
