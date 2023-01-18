package store;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import fileRepository.FileRepository;

public class Store {

	String name;
	Address address;
	String gstNumber;
	long mobileNum;
	String mailId;
	
	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public long getMobileNum() {
		return mobileNum;
	}

	public String getMailId() {
		return mailId;
	}
	
	
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
	
	public void updateStoreDetails(Store store) throws IOException
	{
		Address address = store.getAddress();		
		String temp = store.getName() + "|" + address.getDoorNo() + "|" + address.getArea() + "|" + address.city + "|" + address.getState() + "|" + address.getPincode() + "|" + store.getGstNumber() + "|" + store.getMobileNum() + "|" + store.getMailId();
		FileRepository fp = new FileRepository();
		fp.updateStoreInfoOnFile(temp);
	}
	@Override
	public String toString()
	{
		return this.name + " " + this.address + " " + this.gstNumber + " " + this.mobileNum + " " + this.mailId;
	}
	
	
	
	

}
