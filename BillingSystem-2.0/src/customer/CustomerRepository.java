package customer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import fileRepository.FileRepository;

public class CustomerRepository {
	
	static List<Customer> custList = new ArrayList<Customer>();
	
	
	
	
	
	
	
	
	
	
	//Method to Load Customer Details in the List
	
	public void loadCustomerDetails() throws FileNotFoundException
	{
		FileRepository fp = new FileRepository();
		List<String[]> list  = fp.getCustomerDetailsAsList();
		for(String[] x : list)
		{
			int id = Integer.parseInt(x[0]);
			String name = x[1];
			long number = Long.parseLong(x[2]);
			String mail = x[3];
			Customer customer = new Customer(id, name, number, mail);
			custList.add(customer);
			
		}
	}
	
	//Method to Generate Customer Id
	
	public int generateCustomerId() throws FileNotFoundException
	{
		
		custList.clear();
		this.loadCustomerDetails();
		int id = 0;
		for(Customer x : custList)
		{
			if(x.getId() > id)
			{
				id = x.getId();
			}
		}
		return id + 1;
		
	}
	
	//Method to Check if Customer Details Already Exisits
	
	public boolean checkifDetailsExist(long phNumber, String mail) throws FileNotFoundException
	{
		custList.clear();
		this.loadCustomerDetails();
		for(Customer x : custList)
		{
			if(x.getMobileNum() == phNumber || x.getMailId().equals(mail))
			{
				return true;
			}
		}
		return false;
	}
	
	//Method to Get Customer Details Using His Phone Number
	
	public Customer getCustomerDetailsUsingPhNumber(long phNumber) throws FileNotFoundException
	{
		custList.clear();
		this.loadCustomerDetails();
		Customer customer = null;
		for(Customer x : custList)
		{
			if(x.getMobileNum() == phNumber)
			{
				customer = x;
			}
		}
		return customer;
	}
	
	//Method to Check if Registered Phone Number Exists
	
	public boolean isPhoneNumberValid(long phNumber) throws FileNotFoundException
	{
		custList.clear();
		this.loadCustomerDetails();
		for(Customer x : custList)
		{
			if(x.getMobileNum() == phNumber)
			{
				return true;
			}
		}
		return false;
	}
	
	// Method to Get Id Using Phone Number
	
	public int getIdUsingPhNumber(long phNumber) throws FileNotFoundException
	{
		int id = 0;
		custList.clear();
		this.loadCustomerDetails();
		for(Customer x : custList)
		{
			if(x.getMobileNum() == phNumber)
			{
				id = x.getId();
			}
		}
		return id;
	}
	 
	//Method to Add a Customer to File
	
	public void addCustomer(Customer customer) throws IOException
	{
		FileRepository fp = new FileRepository();
		String info = "\n" + String.valueOf(customer.getId()) + "|" + customer.getName() + "|" + String.valueOf(customer.getMobileNum()) + "|" + customer.getMailId();
		fp.addNewCustomerInfoOnFile(info);
	}
	
	
	
		
}
