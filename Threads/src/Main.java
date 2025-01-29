
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printA A = new printA(5);
		printA B = new printA(10);
		
		Thread tA = new Thread(A);
		Thread tB= new Thread(B);
		
		tB.start();
		try
		{
			tB.join();
		}catch(InterruptedException IE)
		{
			IE.printStackTrace();
		}
		tA.run();
		
		
	}

}
