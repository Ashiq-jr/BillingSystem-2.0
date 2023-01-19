package fileRepository;

import java.io.*;
import java.util.*;

public class FileRepository {
	
	static List<String[]> list = new ArrayList<String[]>();
	
	final String storeInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\store.txt";
	final String loginInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\logDetails.txt";
	final String employeeInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\employeeInfo.txt";
	final String productInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\product.txt";
	final String categoryInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\category.txt";
	final String SubCategoryInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\subcategory.txt";

	
	
	//Reading
	public List<String[]> getStoreDetailsAsList() throws FileNotFoundException
	{
		list.clear();
		return list = loadFileData(storeInfoPath);
	}
	
	public List<String[]> getOperatorLoginInfosAsList() throws FileNotFoundException
	{
		list.clear();
		return list = loadFileData(loginInfoPath);
	}
	
	public List<String[]> getEmployeeDetailsAsList() throws FileNotFoundException
	{
		list.clear();
		return list = loadFileData(employeeInfoPath);
	}
	
	public List<String[]> getCategoriesAsList() throws FileNotFoundException
	{
		list.clear();
		return list = loadFileData(categoryInfoPath);
	}
	
	public List<String[]> getSubCategoriesAsList() throws FileNotFoundException
	{
		list.clear();
		return list = loadFileData(SubCategoryInfoPath);
	}
	
	
	//Writing
	public void writeNewInfoOnEmpInfoFile(String info) throws IOException
	{
		writeNewDataInFile(employeeInfoPath, info);
	}
	
	public void writeNewInfoOnLoginInfoFile(String info) throws IOException
	{
		writeNewDataInFile(loginInfoPath, info);
	}
	
	public void updateLoginInfoOnFile(String info) throws IOException
	{
		overWriteDataInFile(loginInfoPath, info);
	}
	
	public void updateStoreInfoOnFile(String info) throws IOException
	{
		overWriteDataInFile(storeInfoPath, info);
	}
	
	
	
	
	
	
	
	
	
	
	public static List<String[]> loadFileData(String path) throws FileNotFoundException
	{
		File file = new File(path);
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
	
	public static void writeNewDataInFile(String path, String info) throws IOException
	{
		FileWriter writer = new FileWriter(path, true);
		writer.write(info);
		writer.close();		
	}
	
	public static void overWriteDataInFile(String path, String info) throws IOException
	{
		FileWriter writer = new FileWriter(path);
		writer.write(info);
		writer.close();		
	}

}


