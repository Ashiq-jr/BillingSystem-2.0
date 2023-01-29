package bill;

public class StoredBillInfo {
	
	String billNumber;
	String date;
	int customerId;
	int employeeId;
	
	//Getters
	
	public String getBillNumber() {
		return billNumber;
	}
	public String getDate() {
		return date;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public int getCustomerId() {
		return customerId;
	}

	//Constructor
	
	public StoredBillInfo(String billNumber, String date, int customerId, int employeeId) {
		this.billNumber = billNumber;
		this.date = date;
		this.customerId = customerId;
		this.employeeId = employeeId;
	}
	
}
