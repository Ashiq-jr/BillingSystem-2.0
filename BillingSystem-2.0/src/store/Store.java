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
	
	
	
	@Override
	public String toString()
	{
		return this.name + " " + this.address + " " + this.gstNumber + " " + this.mobileNum + " " + this.mailId;
	}
	
	
	
	

}
