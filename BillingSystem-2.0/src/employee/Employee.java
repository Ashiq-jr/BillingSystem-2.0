package employee;

import personalInfo.PersonalInfo;

public class Employee extends PersonalInfo{
	

	Designation designation;
	
	
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

}
