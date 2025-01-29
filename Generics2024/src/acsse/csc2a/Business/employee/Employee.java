package acsse.csc2a.Business.employee;

import java.io.Serializable;

public class Employee implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String Employee_ID;
	private String Department;
	private int NumberOfYearsAtCompany;
	private int NumberOfDependencies;
	private String DegreeType;
	
	
	
	
	/**
	 * @param employee_ID
	 * @param department
	 * @param numberOfYearsAtCompany
	 * @param numberOfDependencies
	 * @param degreeType
	 */
	public Employee(String employee_ID, String department, int numberOfYearsAtCompany, int numberOfDependencies,
			String degreeType) {
		Employee_ID = employee_ID;
		Department = department;
		NumberOfYearsAtCompany = numberOfYearsAtCompany;
		NumberOfDependencies = numberOfDependencies;
		DegreeType = degreeType;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the employee_ID
	 */
	public String getEmployee_ID() {
		return Employee_ID;
	}
	/**
	 * @param employee_ID the employee_ID to set
	 */
	public void setEmployee_ID(String employee_ID) {
		Employee_ID = employee_ID;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return Department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		Department = department;
	}
	/**
	 * @return the numberOfYearsAtCompany
	 */
	public int getNumberOfYearsAtCompany() {
		return NumberOfYearsAtCompany;
	}
	/**
	 * @param numberOfYearsAtCompany the numberOfYearsAtCompany to set
	 */
	public void setNumberOfYearsAtCompany(int numberOfYearsAtCompany) {
		NumberOfYearsAtCompany = numberOfYearsAtCompany;
	}
	/**
	 * @return the numberOfDependencies
	 */
	public int getNumberOfDependencies() {
		return NumberOfDependencies;
	}
	/**
	 * @param numberOfDependencies the numberOfDependencies to set
	 */
	public void setNumberOfDependencies(int numberOfDependencies) {
		NumberOfDependencies = numberOfDependencies;
	}
	/**
	 * @return the degreeType
	 */
	public String getDegreeType() {
		return DegreeType;
	}
	/**
	 * @param degreeType the degreeType to set
	 */
	public void setDegreeType(String degreeType) {
		DegreeType = degreeType;
	}
	
}
