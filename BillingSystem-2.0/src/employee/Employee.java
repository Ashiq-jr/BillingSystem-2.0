package employee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import fileRepository.FileRepository;
import personalInfo.PersonalInfo;

public class Employee extends PersonalInfo{
	

	Designation designation;
	
	static TreeMap<Integer,Employee> tMap = new TreeMap<Integer,Employee>();
	
	
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
	
	//Method to Load Employee Information From File Into a TreeMap
	
	public TreeMap<Integer, Employee> loadEmployeeInfo() throws FileNotFoundException
	{
		FileRepository fp = new FileRepository();
		List<String[]> list = fp.getEmployeeDetailsAsList();
		for(String[] x : list)
		{
			int id = Integer.parseInt(x[0]);
			long mobileNum = Long.parseLong(x[2]);
			Employee employee = new Employee(id, x[1], mobileNum, x[3], Designation.valueOf(x[4]));
			tMap.put(id, employee);
		}
		
		return tMap;
	}
	
	//Method to Find an Employee Using his Name and Return Object
	
	public Employee findEmployeeByName(String name) throws FileNotFoundException
	{
		tMap.clear();
		tMap = this.loadEmployeeInfo();
		Employee employee = new Employee();
		Employee tempEmployee = new Employee();
		for(Integer x : tMap.keySet())
		{
			employee = tMap.get(x);
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
		tMap.clear();
		tMap = this.loadEmployeeInfo();
		int id = 0;
		for(int x : tMap.keySet())
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
