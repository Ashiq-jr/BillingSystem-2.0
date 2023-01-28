package customer;

import java.io.IOException;
import java.util.*;

import fileRepository.FileRepository;

public class CustomerRepository {
	
	static List<Customer> custList = new ArrayList<Customer>();
	
	
	
	//Methods
	

	
	//Method to Add a Customer to File
	
	public void saveCustomer(Customer cust) throws IOException
	{
		FileRepository fp = new FileRepository();
		String info = "\n" + String.valueOf(cust.getId()) + "|" + cust.getName() + "|" + String.valueOf(cust.getMobileNum()) + "|" + cust.getMailId();
		fp.addNewCustomerInfoOnFile(info);
	}
	
	
	
		
}
