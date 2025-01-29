package acsse.csc2a.ReadAndWriteEmployeeData;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import acsse.csc2a.Employee.Employee;

public class ReadAndWriteEmployeeData 
{
	
	public static ArrayList<Employee> ReadEmployeeDataFromTXT()
	{
		ArrayList<Employee> Employees = new ArrayList<Employee>();
		try(Scanner SC = new Scanner(new File("data/employee_data.txt")))
		{
			
			while(SC.hasNext())
			{
				Employee TempEmployee = new Employee();
				
				String line = SC.nextLine();
				StringTokenizer Split = new StringTokenizer(line , " ");
				
				TempEmployee.setEmployeeID(Split.nextToken());
				TempEmployee.setDepartment(Split.nextToken());
				TempEmployee.setNumberOfDependencies(Integer.parseInt(Split.nextToken()));
				TempEmployee.setNumberOfYearsAtCompany(Integer.parseInt(Split.nextToken()));
				Employees.add(TempEmployee);
			}
			
			
		}catch(IOException IO)
		{
			IO.printStackTrace();
		}
		return Employees;
	}
	
	
	public static void WriteDataToBinary( ArrayList<Employee> Employees)
	{
		try(DataOutputStream DOS = new DataOutputStream(new FileOutputStream(new File("data/employee_data.dat"))))
		{
			for(Employee Emp : Employees)
			{
				DOS.writeUTF(Emp.GetEmployeeID());
				DOS.writeUTF(Emp.getDepartment());
				DOS.write(Emp.GetNumberOfDependencies());
				DOS.write(Emp.GetNumberOfYearsAtCompany());
				DOS.writeUTF(Emp.GetDegreeType());
			}	
		}
		catch(IOException IO)
		{
			IO.printStackTrace();
		}
	}
	
	
	public static void WriteObjectToBinary( ArrayList<Employee> Employees)
	{
		try(ObjectOutputStream OOS = new ObjectOutputStream(new DataOutputStream(new FileOutputStream(new File("data/employee_Object_data.dat")))))
		{
			for(Employee Emp : Employees)
			{
				OOS.writeObject(Emp);
			}	
		}
		catch(IOException IO)
		{
			IO.printStackTrace();
		}
	}
	
	public static void ReadAndDisplayDataFromBinary()
	{
		ArrayList<Employee> Employees = new ArrayList<>();
		try(DataInputStream DOS = new DataInputStream(new FileInputStream(new File("data/employee_data_.dat"))))
		{
			while(DOS.available()>0)
			{
				Employee Temp = new  Employee();
				Temp.setEmployeeID(DOS.readUTF());
				Temp.setDepartment(DOS.readUTF());
				Temp.setNumberOfDependencies(DOS.read());
				Temp.setNumberOfYearsAtCompany(DOS.read());
				Temp.setDegree(DOS.readUTF());
				Employees.add(Temp);
			}
		}catch(IOException IO)
		{
			IO.printStackTrace();
		}
		
		System.out.println("Successfully read from Binary File :)");
	}
	
	public void readAndDisplayObjectFromBinary()
	{
		ArrayList<Employee> Employees = new ArrayList<>();
		try(ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(new File("./data/employee_Object_data"))))
		{
			while(OIS.available()>0)
			{
				Employees.add((Employee)OIS.readObject());
			}
		}catch(IOException IO)
		{
			IO.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
