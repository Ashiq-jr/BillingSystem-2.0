package fileRepository;

import java.io.*;
import java.util.*;

public class FileRepository {
	
	static List<String[]> list = new ArrayList<String[]>();
	
	final String loginInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\logDetails.txt";
	final String taxCategoryInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\taxCategory.txt";
	final String customerInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\customer.txt";
	final String storedBillInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\storedBillInfo.txt";

	
	//Reading file
	
	public List<String[]> getOperatorLoginInfosAsList() throws FileNotFoundException
	{
		list.clear();
		return list = loadFileData(loginInfoPath);
	}
	
	public List<String[]> getCustomerDetailsAsList() throws FileNotFoundException
	{
		list.clear();
		return list = loadFileData(customerInfoPath);
	}
	
	public List<String[]> getStoredBillInfosAsList() throws FileNotFoundException
	{
		list.clear();
		return list = loadFileData(storedBillInfoPath);
	}
	
	public void writeNewInfoOnLoginInfoFile(String info) throws IOException
	{
		writeNewInfoOnFile(loginInfoPath, info);
	}
	
	public void updateLoginInfoOnFile(String info) throws IOException
	{
		overWriteDataInFile(loginInfoPath, info);
	}
	
	public void addNewCustomerInfoOnFile(String info) throws IOException
	{
		writeNewInfoOnFile(customerInfoPath, info);
	}
	public void addStoredBillInfoOnFile(String info) throws IOException
	{
		writeNewInfoOnFile(storedBillInfoPath, info);
	}
	
	
	
	
	
	
	//Methods to Load, write and OverWrite File.
	
	public List<String[]> loadFileData(String path) throws FileNotFoundException
	{
		File file = new File(path);
		if(file.exists())
		{
			list.clear();
			Scanner sc = new Scanner(file);
			while(sc.hasNext())
			{
				String temp[] = sc.nextLine().split("\\|");
				list.add(temp);
			}
			sc.close();
			return list;
		}
		else {
			throw new FileNotFoundException("Invalid File Path");
		}
		
	}
	
	public void writeNewInfoOnFile(String path, String info) throws IOException
	{
		File file = new File(path);
		if(file.exists())
		{
			FileWriter writer = new FileWriter(path, true);
			writer.write(info);
			writer.close();	
		}
		else {
			throw new FileNotFoundException("Invalid File Path");
		}
			
	}
	
	public void overWriteDataInFile(String path, String info) throws IOException
	{
		File file = new File(path);
		if(file.exists())
		{
			FileWriter writer = new FileWriter(path);
			writer.write(info);
			writer.close();		
		}
		else {
			throw new FileNotFoundException("Invalid File Path");
		}
	}

}


