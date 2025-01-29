package acsse.csc2a.Business.extract;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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

import acsse.csc2a.Business.employee.Employee;

public class  WorkWithEmployeeData 
{
	public static ArrayList<Employee> ExtractEmployeeData()
	{
		ArrayList<Employee> StaffMembers = new ArrayList<>();
		
		try(Scanner SC = new Scanner(new File("data/employee_data.txt")))
		{
			
			while(SC.hasNext())
			{
				Employee TempEmployee = new Employee();
				StringTokenizer Split = new StringTokenizer(SC.nextLine()," ");
				TempEmployee.setEmployee_ID(Split.nextToken());
				TempEmployee.setDepartment(Split.nextToken());
				TempEmployee.setNumberOfDependencies(Integer.parseInt(Split.nextToken()));
				TempEmployee.setNumberOfYearsAtCompany(Integer.parseInt(Split.nextToken()));
				TempEmployee.setDegreeType(Split.nextToken());
				StaffMembers.add(TempEmployee);	
			}
			
		}catch(IOException IO)
		{
			IO.printStackTrace();
		}
		
		System.out.println("Successfully Read Data From Text File");
		return StaffMembers;
		
	}
	
	public static void WriteToBinaryFile(ArrayList<Employee> Staff) 
	{
		
		try(DataOutputStream DOS = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("data/employee_data.dat")))))
		{
			for(Employee staff : Staff)
			{
				DOS.writeUTF(staff.getEmployee_ID());
				DOS.writeUTF(staff.getDepartment());
				DOS.write(staff.getNumberOfYearsAtCompany());
				DOS.write(staff.getNumberOfDependencies());
				DOS.writeUTF(staff.getDegreeType());
			}
			
			
		}catch(IOException IO)
		{
			IO.printStackTrace();
		}
		System.out.println("Successfully Wrote Attributes To Binary");
	}
	
	
	public static void WriteObjectToBinaryFile(ArrayList<Employee> Staff) 
	{
		
		try(ObjectOutputStream OOS = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("data/employee_Object_data.dat")))))
		{
			for(Employee staff : Staff)
			{
				OOS.writeObject(staff);
			}
			
			
		}catch(IOException IO)
		{
			IO.printStackTrace();
		}
		
		System.out.println("Successfully Wrote Object From File");
	}
	
	
	public static ArrayList<Employee> ReadDataFromBinaryFile() 
	{
		ArrayList<Employee> Staff = new ArrayList<>();
		try(DataInputStream DOS = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("data/employee_data.dat")))))
		{
			
			while(DOS.available()>0)
			{
				Employee TempEmployee = new Employee();
				TempEmployee.setEmployee_ID(DOS.readUTF());
				TempEmployee.setDepartment(DOS.readUTF());
				TempEmployee.setNumberOfDependencies(DOS.read());
				TempEmployee.setNumberOfYearsAtCompany(DOS.read());
				TempEmployee.setDegreeType(DOS.readUTF());
				Staff.add(TempEmployee);
			}
			
			
		}catch(IOException IO)
		{
			IO.printStackTrace();
		}
		System.out.println("Read Succesfully From Binary File");
		return Staff;
	}
	
	public static ArrayList<Employee> ReadObjectFromBinaryFile() 
	{
		ArrayList<Employee> Staff = new ArrayList<>();
		try(ObjectInputStream OOS = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("data/employee_data.dat")))))
		{
			
			while(OOS.available()!=-1)
			{
				if(OOS.readObject() instanceof Employee)
				{
					Staff.add((Employee)OOS.readObject());
				}
				
			}
			
			
		}catch(IOException | ClassNotFoundException IO)
		{
			IO.printStackTrace();
		}
		System.out.println("Read Object Succesfully From Binary File");
		return Staff;
	}


}
