import ConnectionPackage.Connection;

public class Main{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		
		Connection c1=new Connection();
		Connection c2=new Connection();
		Connection c3=new Connection();
		Connection c4=new Connection();
		Thread t1=new Thread(c2);
		t1.start();
	}
}