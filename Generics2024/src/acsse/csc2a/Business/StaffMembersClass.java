package acsse.csc2a.Business;

import java.util.ArrayList;

import acsse.csc2a.Business.employee.Employee;

public class StaffMembersClass 
{
	private ArrayList<Employee>StaffMembers ;
	
	public StaffMembersClass(ArrayList<Employee> StaffMembers)
	{
		this.StaffMembers = StaffMembers;
	}
	
	public void display()
	{
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~EMPLOYEE DATA~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for(Employee Staff : this.StaffMembers)
		{
			System.out.print("\t"+Staff.getEmployee_ID());
		    System.out.print("\t"+Staff.getDepartment());
			System.out.print("\t"+Staff.getNumberOfYearsAtCompany());
			System.out.print("\t"+Staff.getNumberOfDependencies());
			System.out.print("\t"+Staff.getDegreeType());
			System.out.println();
			
		}
		

	}
	
	
	public void display(ArrayList<Employee> Staff)
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~EMPLOYEE DATA~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for(Employee staff : Staff)
		{
			System.out.print("\t"+staff.getEmployee_ID());
		    System.out.print("\t"+staff.getDepartment());
			System.out.print("\t"+staff.getNumberOfYearsAtCompany());
			System.out.print("\t"+staff.getNumberOfDependencies());
			System.out.print("\t"+staff.getDegreeType());
			System.out.println();
			
		}
		
	}

	/**
	 * @return the staffMembers
	 */
	public ArrayList<Employee> getStaffMembers() {
		return StaffMembers;
	}
	
	
	
}
