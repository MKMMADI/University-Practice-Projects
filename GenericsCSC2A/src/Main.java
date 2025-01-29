import java.util.ArrayList;
import acsse.csc2a.Employee.Employee;
import acsse.csc2a.Generic.CollectionOfTypes;
import acsse.csc2a.ReadAndWriteEmployeeData.ReadAndWriteEmployeeData;

public class Main 
{	
	public static void main(String[] Args)
	{
		ArrayList<Employee> Employees = ReadAndWriteEmployeeData.ReadEmployeeDataFromTXT();
		CollectionOfTypes<Employee> ArrayEmployees = new CollectionOfTypes<Employee>(Employees);
		ArrayEmployees.printArrayList();
	}
}
