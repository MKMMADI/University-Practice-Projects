
public class Main {

	public static void main(String[] args)
	{
		OuterClass oc = new OuterClass();		
		oc.print();
		OuterClass.innerClass inner = new OuterClass.innerClass();
		inner.print();
	}

}
