package bill;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import fileRepository.FileRepository;

public class StoredBillInfoRepository {
	
	static List<StoredBillInfo> billInfoList = new ArrayList<StoredBillInfo>();
	static List<String> billNumbersList = new ArrayList<String>();
	
	
	//Method to Load BillInfo's into a List
	
	public void loadStoreInfoList() throws IOException
	{
		billInfoList.clear();
		FileRepository fp = new FileRepository();
		List<String[]> list = fp.getStoredBillInfosAsList();
		
		for(String[] x : list)
		{
			StoredBillInfo info = new StoredBillInfo(x[0], x[1], Integer.parseInt(x[2]), Integer.parseInt(x[3]));
			billInfoList.add(info);			
		}
	}
	
	//Method to Write new BillInfo's inthe File
	
	public void writeNewBillInfo(StoredBillInfo storedBillInfo) throws IOException
	{
		String info = "\n" + storedBillInfo.getBillNumber() + "|" + storedBillInfo.getDate() + "|" + storedBillInfo.getCustomerId() + "|" + storedBillInfo.getEmployeeId();
		FileRepository fp = new FileRepository();
		fp.addStoredBillInfoOnFile(info);
	}
	
	//Method to Get List of Stored Bill Numbers

	public List<String> getListOfStoredBillNumbers() throws IOException
	{
		billInfoList.clear();
		this.loadStoreInfoList();
		
		for(StoredBillInfo x : billInfoList)
		{
			String number = x.getBillNumber();
			billNumbersList.add(number);
		}
		
		return billNumbersList;

	}
	
	// Method to Get Bill Date Using Bill Number
	
	public String getBillDateUsingBillNumber(String billNumber) throws IOException
	{
		String date = "";
		billInfoList.clear();
		this.loadStoreInfoList();
		for(StoredBillInfo x : billInfoList)
		{
			if(x.getBillNumber().equals(billNumber))
			{
				date = x.getDate();
			}
		}
		
		return date;
	}
	
	// Method to Return a List of Bill Numbers Of Bill Purchased By a Particular Customer
	
	public List<String> getAllBillsPurchasedByACustomer(int customerId) throws IOException
	{
		billInfoList.clear();
		billNumbersList.clear();
		this.loadStoreInfoList();
		
		for(StoredBillInfo x : billInfoList)
		{
			if(x.getCustomerId() == customerId)
			{
				billNumbersList.add(x.getBillNumber());
			}
			
		}
		return billNumbersList;
	}
	
	// Method to Return a List Of Bill Numbers Of Bill, Billed by a Paricular Employee
	
	public List<String> getBillsBilledByAnEmployee(int employeeId) throws IOException
	{
		billInfoList.clear();
		billNumbersList.clear();
		this.loadStoreInfoList();
		
		for(StoredBillInfo x : billInfoList)
		{
			if(x.getEmployeeId() == employeeId)
			{
				billNumbersList.add(x.getBillNumber());
			}
			
		}
		return billNumbersList;
	}
	
	// Method to Return a List Of Bills Billed On Particular Date
	
	public List<String> getBillsBilledOnParticularDate(String date) throws IOException
	{
		billInfoList.clear();
		billNumbersList.clear();
		this.loadStoreInfoList();
		
		for(StoredBillInfo x : billInfoList)
		{
			if(x.getDate().equals(date))
			{
				billNumbersList.add(x.getBillNumber());
			}
			
		}
		return billNumbersList;
	}
		
	
	
}
