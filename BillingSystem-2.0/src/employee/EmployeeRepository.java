package employee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import fileRepository.FileRepository;

public class EmployeeRepository {
	
	
	static TreeMap<Integer,Employee> tMap = new TreeMap<Integer,Employee>();
	static List<Integer> empIdList = new ArrayList<Integer>();
	
	
	

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
		return empIdList;
	}
	
	//Methhod to Find An Employee Using his Id And Return Object
	
	public Employee findEmployeeById(int id) throws FileNotFoundException
	{
		tMap.clear();
		tMap = this.loadEmployeeInfo();
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
	
	// Method to get Employee Name Using His Id
	
	public String getNameUsingId(int id) throws FileNotFoundException
	{
		tMap.clear();
		tMap = this.loadEmployeeInfo();
		Employee employee = new Employee();
		String name = "";
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
		
		return false;
		
	}
	
	//Method to Add New Employee Using the Object Received as Argument.
	
	public void addEmployee(Employee employee) throws IOException
	{		
		String temp = "\n" + String.valueOf(employee.getId()) + "|" + employee.getName() + "|" + String.valueOf(employee.getMobileNum()) + "|" + employee.getMailId() + "|" + employee.getDesignation().toString();
		FileRepository fp = new FileRepository();
		fp.writeNewInfoOnEmpInfoFile(temp);
	}

}
