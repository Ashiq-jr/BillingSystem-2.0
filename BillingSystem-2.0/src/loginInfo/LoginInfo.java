package loginInfo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import employee.Designation;
import employee.Employee;
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
	
	//Method to Return Object of a Particular Info using Id.
	
	public LoginInfo getInfoUsingId(int id) throws FileNotFoundException
	{
		logInfoList.clear();
		logInfoList = this.getLoginInfoList();
		LoginInfo info = new LoginInfo();
		for(LoginInfo x : logInfoList)
		{
			if(Integer.parseInt(x.getName()) == id)
			{
				info = x;
			}
		}
		
		return info;		
	}

	
	//Method to Get Login Info As a List
	
	public List<LoginInfo> getLoginInfoList() throws FileNotFoundException
	{
		list.clear();
		logInfoList.clear();
		FileRepository fp = new FileRepository();
		list = fp.getOperatorLoginInfosAsList();
		
		for(String[] x : list)
		{
			this.name = x[0];
			this.password = x[1];
			this.designation = Designation.valueOf(x[2]);
			LoginInfo li = new LoginInfo(this.name, this.password, this.designation);
			logInfoList.add(li);
		}
		return logInfoList;		
	}
	
	// Method to Write New Login Info Into the File
	
	public void addNewLoginInfo(String name) throws IOException
	{
		Employee employee = new Employee();
		employee = employee.findEmployeeByName(name);
		LoginInfo log = new LoginInfo(String.valueOf(employee.getId()), String.valueOf(employee.getMobileNum()), employee.getDesignation());
		String temp = "\n" + log.getName() + "|" + log.getPassword() + "|" + log.getDesignation();
		
		FileRepository fp = new FileRepository();
		fp.writeNewInfoOnLoginInfoFile(temp);


	}
	
	// Method to Change Password of an Existing Login Info Using the Id.
	
	public void changePassword(int id, String pwd) throws IOException
	{
		logInfoList.clear();
		logInfoList = this.getLoginInfoList();
		
		LoginInfo info = this.getInfoUsingId(id);
		LoginInfo temp = new LoginInfo(info.getName(),pwd,info.getDesignation());
		logInfoList.set(id-101, temp);
		StringBuffer buffer = new StringBuffer();
		for(LoginInfo x : logInfoList)
		{
			buffer.append(x.getName() + "|" + x.getPassword() + "|" + x.getDesignation() + System.lineSeparator());
		}
		
		String overallInfo = buffer.toString().trim();
		FileRepository fp = new FileRepository();
		fp.updateLoginInfoOnFile(overallInfo);
		
	}
	
	
	
	
	
	@Override
	public String toString()
	{
		return this.name + " " + this.password + " " + this.designation.toString() ;
	}

}
