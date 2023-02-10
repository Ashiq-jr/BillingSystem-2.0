 package product;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

import category.Category;
import fileRepository.FileRepository;
import subCategory.SubCategory;

public class ProductRepository {
	
	
	final String productInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\product.txt";
	static TreeMap<Integer, Product> tMap = new TreeMap<Integer, Product>();
	static List<Product> prodList = new ArrayList<Product>();
	static List<String> nameList = new ArrayList<String>();
	

	//Method to Load Product Info From File as a HashMap	
	public TreeMap<Integer, Product> loadProductsIntoTreeMap() throws IOException
	{
		tMap.clear();
		File file = new File(productInfoPath);
		Scanner sc = new Scanner(file);
		while(sc.hasNext())
		{
			String[] x = sc.nextLine().split("\\|");
			int id = Integer.parseInt(x[0]);
			Category category = new Category(x[2]);
			SubCategory subCategory = new SubCategory(category, x[3]);
			double unitPrice = Double.parseDouble(x[4]);			
			String taxName = x[5];
			TaxCategoryRepository taxRep = new TaxCategoryRepository();
			double taxValue = taxRep.getTaxValue(taxName);
			TaxCategory taxCategory = new TaxCategory(taxName, taxValue);		
			Status status = Status.valueOf(x[6]);
			Product product = new Product(id, x[1], category, subCategory, unitPrice, taxCategory, status);
			tMap.put(id, product);
		}
		sc.close();
		return tMap;
	}
	
	//Method to get List of All Product Objects	
	public List<Product> getListOfProducts() throws IOException
	{
		tMap = this.loadProductsIntoTreeMap();
		for(Integer x : tMap.keySet())
		{
			prodList.add(tMap.get(x));
		}
		
		return prodList;
	}
	
	//Method to get List of All product Names
	public List<String> getNameListOfProducts() throws IOException
	{
		nameList.clear();
		tMap = this.loadProductsIntoTreeMap();
		for(Integer x : tMap.keySet())
		{
			nameList.add(tMap.get(x).getName());
		}
		return nameList;
	}
	
	//Method to get A Product Using Name	
	public Product getProductUsingName(String name) throws IOException
	{
		prodList.clear();
		prodList = this.getListOfProducts();
		nameList = this.getNameListOfProducts();
		
		
		if(nameList.contains(name))
		{
			Product product = null;
			for(Product x : prodList)
			{
				if(x.getName().equals(name))
				{
					product = x;
				}
			}
			return product;
		}
		
		else {
			
			throw new IllegalArgumentException("Product Doesn't Exist");
		}
		
	}
	
	
	//Method to Generate Product Id	
	public int generateProductId() throws IOException
	{
		tMap.clear();
		tMap = this.loadProductsIntoTreeMap();
		int temp = 0;
		for(Integer x : tMap.keySet())
		{
			if(x > temp)
			{
				temp = x;
			}
			
		}
		return temp + 1;
	}
	
	//Method to Get Product Id using name
	public int getIdUsingName(String name) throws IOException
	{
		nameList = this.getNameListOfProducts();
		if(nameList.contains(name))
		{
			int id = 0;
			tMap = this.loadProductsIntoTreeMap();
			for(Integer x: tMap.keySet())
			{
				Product product = tMap.get(x);
				if(product.getName().equals(name))
				{
					id = product.getId();
				}
			}
			return id;
		}
		else {
			throw new IllegalArgumentException("Product Doesn't Exist.");
		}
				
	}
	
	//Method to Add New Product
	public void addNewProduct(Product product) throws IOException
	{
		nameList = this.getNameListOfProducts();
		if(nameList.contains(product.getName()))
		{
			throw new IllegalArgumentException("Product Already Exists");
		}
		int id = product.getId();
		if(tMap.containsKey(id))
		{
			throw new IllegalArgumentException("Product Id Already Exists");
		}
		else {
			
			validateProduct(product);
			FileRepository fp = new FileRepository();
			String info = "\n" + id + "|" + product.getName() + "|" + product.getCategory().getName() + "|" + product.getSubCategory().getName() + "|" + product.getUnitPrice() + "|" + product.getTaxCategory().getName() + "|" + product.getStatus().name();
			fp.writeNewInfoOnFile(productInfoPath, info);
		}		
	}
	
	//Method to Update Product info
	
	public void editProduct(Product product) throws IOException
	{
		int index = product.getId() - 101;
		prodList.clear();
		prodList = this.getListOfProducts();
		
		prodList.set(index, product);
		String info = "";
		
		StringBuffer buffer = new StringBuffer();
		for(Product x : prodList)
		{
			buffer.append(x.getId() + "|" + x.getName() + "|" + x.getCategory().getName() + "|" + x.getSubCategory().getName() + "|" + String.valueOf(x.getUnitPrice()) + "|" + x.getTaxCategory().getName() + "|" + x.getStatus().name() + "\n");
		}
		
		info = buffer.toString();
		
		FileRepository fp = new FileRepository();
		try {
			validateProduct(product);
			fp.overWriteDataInFile(productInfoPath, info.trim());
		} catch (IllegalArgumentException e) {
			
		}
	
	}
	
	//Validate Product
	
	private void validateProduct(Product product)
	{
		product.validateId();
		product.validateName();
		product.validateUnitPrice();
		SubCategory subCategory = product.getSubCategory();
		subCategory.validateName();
		Category category = subCategory.getCategory();
		category.ValidateName();
		TaxCategory taxCategory = product.getTaxCategory();
		taxCategory.validateName();
		taxCategory.validateTaxValue();
		Status status = product.getStatus();
		status.validateStatus(status.toString());
	}
	
	
		

}