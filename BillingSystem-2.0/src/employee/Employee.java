package employee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import fileRepository.FileRepository;
import personalInfo.PersonalInfo;

public class Employee extends PersonalInfo{
	

	Designation designation;
	
	static HashMap<Integer,Employee> hMap = new HashMap<Integer,Employee>();
	
	
	// Constructors
	
	public Employee() {
	
	}
	
	public Employee(int id, String name, long mobileNum, String mailId, Designation designation) {
		
		super(id, name, mobileNum, mailId);
		this.designation = designation;
	}
	

	//Getter for Designation 
	
	public Designation getDesignation() {
		return designation;
	}
	
	//Method to Load Employee Information From File Into a HashMap
	
	public HashMap<Integer, Employee> loadEmployeeInfo() throws FileNotFoundException
	{
		FileRepository fp = new FileRepository();
		List<String[]> list = fp.getEmployeeDetailsAsList();
		for(String[] x : list)
		{
			int id = Integer.parseInt(x[0]);
			long mobileNum = Long.parseLong(x[2]);
			Employee employee = new Employee(id, x[1], mobileNum, x[3], Designation.valueOf(x[4]));
			hMap.put(id, employee);
		}
		
		return hMap;
	}
	
	//Method to Find an Employee Using his Name and Return Object
	
	public Employee findEmployeeByName(String name) throws FileNotFoundException
	{
		hMap.clear();
		hMap = this.loadEmployeeInfo();
		Employee employee = new Employee();
		Employee tempEmployee = new Employee();
		for(Integer x : hMap.keySet())
		{
			employee = hMap.get(x);
			if(employee.getName().equals(name))
			{
				tempEmployee = employee;
			}
		}
		
		return tempEmployee;
	}
	
	//Method to Generate New Employee Id
	
	public int generateNewEmployeeId() throws FileNotFoundException
	{
		hMap.clear();
		hMap = this.loadEmployeeInfo();
		int id = 0;
		for(int x : hMap.keySet())
		{
			if(x > id)
			{
				id = x;
			}
		}
		
		return id+1;
		
	}
	
	//Method to Add New Employee Using the Object Received as Argument.
	
	public void addEmployee(Employee employee) throws IOException
	{		
		String temp = "\n" + String.valueOf(employee.getId()) + "|" + employee.getName() + "|" + String.valueOf(employee.getMobileNum()) + "|" + employee.getMailId() + "|" + employee.getDesignation().toString();
		FileRepository fp = new FileRepository();
		fp.writeNewInfoOnEmpInfoFile(temp);
	}

}
