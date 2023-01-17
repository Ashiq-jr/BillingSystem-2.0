package store;

import java.io.FileNotFoundException;
import java.util.*;
import fileRepository.FileRepository;

public class Store {
	
	String name;
	Address address;
	String gstNumber;
	long mobileNum;
	String mailId;
	
	public Store() {
		
	}
	
	public Store(String name, Address address, String gstNumber, long mobileNum, String mailId) {
		
		this.name = name;
		this.address = address;
		this.gstNumber = gstNumber;
		this.mobileNum = mobileNum;
		this.mailId = mailId;
	}
	
	public Store getStoreDetails() throws FileNotFoundException
	{
		this.loadStoreDetails();
		Store store = new Store(this.name, this.address, this.gstNumber, this.mobileNum, this.mailId);
		return store;
	}
	
	public void loadStoreDetails() throws FileNotFoundException
	{
		FileRepository fp = new FileRepository();
		List<String[]> list = fp.getStoreDetailsAsList();
		for(String[] x : list)
		{
			this.name = x[0];
			String doorNo = x[1];
			String area = x[2];
			String city = x[3];
			String state = x[4];
			int pinCode = Integer.parseInt(x[5]);
			Address address = new Address(doorNo, area, city, state, pinCode);
			this.address = address;
			this.gstNumber = x[6];
			this.mobileNum = Long.parseLong(x[7]);
			this.mailId = x[8];
		}
	}
	
	@Override
	public String toString()
	{
		return this.name + " " + this.address + " " + this.gstNumber + " " + this.mobileNum + " " + this.mailId;
	}
	
	
	
	

}
