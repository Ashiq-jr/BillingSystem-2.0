package fileRepository;

import java.io.*;
import java.util.*;

import category.Category;
import product.Product;
import product.Status;
import product.TaxCategory;
import subCategory.SubCategory;

public class FileRepository {
	
	static List<String[]> list = new ArrayList<String[]>();
	
	final String storeInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\store.txt";
	final String loginInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\logDetails.txt";
	final String employeeInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\employeeInfo.txt";
	final String productInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\product.txt";
	final String categoryInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\category.txt";
	final String subCategoryInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\subcategory.txt";
	final String taxCategoryInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\taxCategory.txt";

	
	
	//Reading file
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
		return list = loadFileData(subCategoryInfoPath);
	}
	
	public List<String[]> getTaxCategoriesAsList() throws FileNotFoundException
	{
		list.clear();
		return list = loadFileData(taxCategoryInfoPath);
	}
	
	// Return the Path of ProductInfo File
	
	public String getProductInfoPath()
	{
		return productInfoPath;
	}
	
	
	//Writing
	public void writeNewInfoOnEmpInfoFile(String info) throws IOException
	{
		writeNewInfoOnFile(employeeInfoPath, info);
	}
	
	public void writeNewInfoOnLoginInfoFile(String info) throws IOException
	{
		writeNewInfoOnFile(loginInfoPath, info);
	}
	
	public void updateLoginInfoOnFile(String info) throws IOException
	{
		overWriteDataInFile(loginInfoPath, info);
	}
	
	public void updateStoreInfoOnFile(String info) throws IOException
	{
		overWriteDataInFile(storeInfoPath, info);
	}
	
	public void addNewProductInfoOnFile(String info) throws IOException
	{
		writeNewInfoOnFile(productInfoPath, info);
	}
	
	public void addNewCategoryInfoOnFile(String info) throws IOException
	{
		writeNewInfoOnFile(categoryInfoPath, info);
	}
	public void addNewSubCategoryInfoOnFile(String info) throws IOException
	{
		writeNewInfoOnFile(subCategoryInfoPath, info);
	}
	public void addNewTaxCategoryInfoOnFile(String info) throws IOException
	{
		writeNewInfoOnFile(taxCategoryInfoPath, info);
	}
	public void updateCategoryInfoOnFile(String info)throws IOException
	{
		overWriteDataInFile(categoryInfoPath, info);
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
	
	public static void writeNewInfoOnFile(String path, String info) throws IOException
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


