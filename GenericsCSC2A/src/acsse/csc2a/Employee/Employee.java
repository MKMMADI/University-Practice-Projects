package acsse.csc2a.Employee;

import java.io.Serializable;

public class Employee implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//Employee information
	private String Employee_ID;
	private String Department;
	private int NumberOfYearsAtCompany;
	private int NumberOfDependencies;
	private String DegreeType;
	
	
	//Constructor used to allocate values to instantiated object,
	public Employee(String ID , String Department , int NumYears ,int NumDependecies ,String Degree)
	{
		this.Employee_ID=ID;
		this.Department=Department;
		this.NumberOfYearsAtCompany=NumYears;
		this.NumberOfDependencies=NumDependecies;
		this.DegreeType=Degree;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	//Getters and Setters
	public String GetEmployeeID()
	{
		return this.Employee_ID;
	}
	
	public void setEmployeeID(String ID)
	{
		this.Employee_ID=ID;
	}
	
	public String getDepartment()
	{
		return this.Department;
	}
	
	public void setDepartment(String Department)
	{
		this.Department=Department;
	}
	
	public int GetNumberOfYearsAtCompany()
	{
		return this.NumberOfYearsAtCompany;
	}
	
	public void setNumberOfYearsAtCompany(int Years)
	{
		this.NumberOfYearsAtCompany=Years;
	}
	
	public int GetNumberOfDependencies()
	{
		return this.NumberOfDependencies;
	}
	
	public void setNumberOfDependencies(int Dependencies)
	{
		this.NumberOfDependencies=Dependencies;
	}
	
	public String GetDegreeType()
	{
		return this.DegreeType;
	}
	
	public void setDegree(String Degree)
	{
		this.DegreeType=Degree;
	}
	
	
}