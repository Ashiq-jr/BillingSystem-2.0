package employee;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


import fileRepository.FileRepository;

public class EmployeeRepository {
	
	final String employeeInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\employeeInfo.txt";
	static TreeMap<Integer,Employee> tMap = new TreeMap<Integer,Employee>();
	static List<Integer> empIdList = new ArrayList<Integer>();
	
	
	

	//Method to Load Employee Information From File Into a TreeMap
	
	public TreeMap<Integer, Employee> loadEmployeeInfo() throws FileNotFoundException
	{
		FileRepository fp = new FileRepository();
		List<String[]> list = fp.loadFileData(employeeInfoPath);
		for(String[] x : list)
		{
			int id = Integer.parseInt(x[0]);
			long mobileNum = Long.parseLong(x[2]);
			Employee employee = new Employee(id, x[1], mobileNum, x[3], Designation.valueOf(x[4]));
			tMap.put(id, employee);
		}
		
		return tMap;
	}
	
	//Method to Get Employee Id's As a List
	
	public List<Integer> getEmployeeIdList() throws FileNotFoundException
	{
		empIdList.clear();
		tMap.clear();
		tMap = this.loadEmployeeInfo();
		
		for(int x : tMap.keySet())
		{
			empIdList.add(x);
		}
		empIdList.sort(null);
		return empIdList;
	}
	
	//Methhod to Find An Employee Using his Id And Return Object
	
	public Employee findEmployeeById(int id) throws FileNotFoundException
	{
		tMap.clear();
		tMap = this.loadEmployeeInfo();
		empIdList.clear();
		this.getEmployeeIdList();
		if(empIdList.contains(id))
		{
			Employee employee = new Employee();
			for(Integer x : tMap.keySet())
			{
				if(x == id)
				{
					employee = tMap.get(x);
				}
			}
			
			return employee;
		}
		else {
			throw new IllegalArgumentException("Invalid Id ");
		}
	}
	
	
	//Method to Find an Employee Using his Name and Return Object
	
	public Employee findEmployeeByName(String name) throws FileNotFoundException
	{
		tMap.clear();
		tMap = this.loadEmployeeInfo();
		Employee employee = new Employee();
		Employee tempEmployee = new Employee();
		empIdList.clear();
		this.getEmployeeIdList();
		
		int id = this.getIdUsingName(name);
		if(empIdList.contains(id))
		{
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
		else {
			throw new IllegalArgumentException("Invalid Name. ");
		}
	}
	
	// Method to get Employee Name Using His Id
	
	public String getNameUsingId(int id) throws FileNotFoundException
	{
		tMap.clear();
		tMap = this.loadEmployeeInfo();
		Employee employee = new Employee();
		String name = "";
		empIdList.clear();
		this.getEmployeeIdList();
		if(empIdList.contains(id))
		{
			for(Integer x : tMap.keySet())
			{
				employee = tMap.get(x);
				if(employee.getId() == id)
				{
					name = employee.getName();
				}
			}
			
			return name;
		}
		else {
			throw new IllegalArgumentException("Invalid Id");
		}
	}
	
	// Method to get Employee Id Using His Name
	
	public int getIdUsingName(String name) throws FileNotFoundException
	{
		tMap.clear();
		tMap = this.loadEmployeeInfo();
		Employee employee = new Employee();
		int id  = 0;
		
		for(Integer x : tMap.keySet())
		{
			employee = tMap.get(x);
			if(employee.getName().equals(name))
			{
				id = employee.getId();
			}
		}
		if(id != 0)
		{
			return id;
		}
		else {
			throw new IllegalArgumentException("Invalid Name.");
		}
		
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
	
	// Method to Check if An Employee Id Exists
	
	public boolean checkIfIdExists(int id) throws FileNotFoundException 
	{
		empIdList.clear();
		empIdList = this.getEmployeeIdList();
		if(empIdList.contains(id)) return true;
		
		else {
			throw new IllegalArgumentException("Invalid Id.");
		}
		
	}
	
	// Method to Check if A Phone Number Already Exists
	
	public boolean checkIfPhNumberExists(long phNumber) throws FileNotFoundException 
	{
		this.loadEmployeeInfo();
		for(Integer x : tMap.keySet())
		{
			Employee employee = tMap.get(x);
			if(phNumber == employee.getMobileNum())
			{
				throw new IllegalArgumentException("Mobile Number Already Exists.");
			}
		}
		
		return false;		
	}	
	
	// Method to Check if A Email Already Exists
	
	public boolean checkIfEmailExists(String mailId) throws FileNotFoundException 
	{
		this.loadEmployeeInfo();
		for(Integer x : tMap.keySet())
		{
			Employee employee = tMap.get(x);
			if(mailId.equals(employee.getMailId()))
			{
				throw new IllegalArgumentException("Mail Id Already Exists.");
			}
		}
		
		return false;		
	}
	
	//Method to Add New Employee Using the Object Received as Argument.
	
	public void addEmployee(Employee employee) throws IOException
	{	
		validateEmployee(employee);	
		empIdList.clear();
		this.getEmployeeIdList();
		if(empIdList.contains(employee.getId()) || this.checkIfEmailExists(employee.getMailId()) || this.checkIfPhNumberExists(employee.getMobileNum()))
		{
			throw new IllegalArgumentException("Employee Details Already Exists.");
		}
		else {
			String temp = "\n" + String.valueOf(employee.getId()) + "|" + employee.getName() + "|" + String.valueOf(employee.getMobileNum()) + "|" + employee.getMailId() + "|" + employee.getDesignation().toString();
			FileRepository fp = new FileRepository();
			fp.writeNewInfoOnFile(employeeInfoPath, temp);
		}
		
	}
	
	//Method to Remove an Employee
	
	public void removeEmploee(int id) throws IOException
	{
		this.loadEmployeeInfo();
		StringBuilder info = new StringBuilder();
		for(Integer x : tMap.keySet())
		{
			Employee employee = tMap.get(x);
			if(employee.getId() != id)
			{
				info.append(employee.getId() + "|" + employee.getName() + "|" + employee.getMobileNum() + "|" + employee.getMailId() + "|" + employee.getDesignation() + "\n");
			}			
		}
		FileRepository repository = new FileRepository();
		repository.overWriteDataInFile(employeeInfoPath, info.toString().trim());
		
	}
	
	//Validate
	
	private void validateEmployee(Employee employee)
	{
		employee.validateId();
		employee.validateName();
		employee.validateMailId();
		employee.validateMobileNum();
		Designation designation = employee.getDesignation();
		designation.validateDesignation(designation.toString());
	}

}
