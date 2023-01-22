package loginInfo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import employee.Designation;
import employee.Employee;
import employee.EmployeeRepository;
import fileRepository.FileRepository;

public class LoginInfo {
	
	String name;
	String password;
	Designation designation;
	
	static List<String[]> list = new ArrayList<String[]>();
	static List<LoginInfo> logInfoList = new ArrayList<LoginInfo>();
	
	
	//Getters
	public Designation getDesignation() {
		return designation;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
	//Constructors
	public LoginInfo() {
		
	}
	
	public LoginInfo(String name, String password, Designation designation) {
		
		this.name = name;
		this.password = password;
		this.designation = designation;
	}
	
	
	
	@Override
	public String toString()
	{
		return this.name + " " + this.password + " " + this.designation.toString() ;
	}

}
