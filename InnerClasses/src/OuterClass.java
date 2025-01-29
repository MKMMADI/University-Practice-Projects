
public class OuterClass 
{
	public void print()
	{
		System.out.println("Hey There !!");
		
		class localInnerClass
		{
			int number = 6;
			
			public void getNumber()
			{
				System.out.println(this.number);
			}
		}
		
		localInnerClass local = new localInnerClass();
		local.getNumber();
	}
	
	public static class innerClass
	{
		public void print()
		{
			System.out.println("Hey There 2!!");
		}
	}
}
