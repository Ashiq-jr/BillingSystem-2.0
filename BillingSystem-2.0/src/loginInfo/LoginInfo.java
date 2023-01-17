package loginInfo;

import java.io.FileNotFoundException;
import java.util.*;

import employee.Designation;
import fileRepository.FileRepository;

public class LoginInfo {
	
	Designation designation;
	String name;
	String password;
	
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
	
	public LoginInfo(Designation designation, String name, String password) {
		this.designation = designation;
		this.name = name;
		this.password = password;
	}

	
	//Methiods
	public List<LoginInfo> getLoginInfoList() throws FileNotFoundException
	{
		FileRepository fp = new FileRepository();
		list = fp.getOperatorLoginInfosAsList();
		
		for(String[] x : list)
		{
			this.designation = Designation.valueOf(x[0]);
			this.name = x[1];
			this.password = x[2];
			LoginInfo li = new LoginInfo(this.designation, this.name, this.password);
			logInfoList.add(li);
		}
		return logInfoList;		
	}
	
	
	
	
	
	@Override
	public String toString()
	{
		return this.name + " " + this.password ;
	}

}
