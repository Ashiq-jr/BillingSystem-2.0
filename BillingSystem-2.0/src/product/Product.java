package product;

import java.io.*;
import java.util.*;

import category.Category;
import fileRepository.FileRepository;
import subCategory.SubCategory;

public class Product {

	int id;
	String name;
	Category category;
	SubCategory subCategory;
	double unitPrice;
	TaxCategory taxCategory;
	Status status;
	
	static TreeMap<Integer, Product> tMap = new TreeMap<Integer, Product>();
	static List<Product> prodList = new ArrayList<Product>();
	static List<String> nameList = new ArrayList<String>();
	
	//Getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public TaxCategory getTaxCategory() {
		return taxCategory;
	}

	public Status getStatus() {
		return status;
	}
	
	//Constructors
	public Product(){	
	}
	
	public Product(int id, String name, Category category, SubCategory subCategory, double unitPrice, TaxCategory taxCategory, Status status) {
		
		this.id = id;
		this.name = name;
		this.category = category;
		this.subCategory = subCategory;
		this.unitPrice = unitPrice;
		this.taxCategory = taxCategory;
		this.status = status;
	}
	
	//Method to Load Product Info From File as a HashMap	
	public TreeMap<Integer, Product> loadProductsIntoTreeMap() throws IOException
	{
		tMap.clear();
		FileRepository fp = new FileRepository();
		String productInfoPath = fp.getProductInfoPath();
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
			TaxCategory tax = new TaxCategory();
			double taxValue = tax.getTaxValue(taxName);
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
		tMap = this.loadProductsIntoTreeMap();
		for(Integer x : tMap.keySet())
		{
			nameList.add(tMap.get(x).getName());
		}
		return nameList;
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
	
	//Method to Add New Product
	public void addNewProduct(Product product) throws IOException
	{
		FileRepository fp = new FileRepository();
		int id = this.generateProductId();
		String info = "\n" + id + "|" + product.getName() + "|" + product.getCategory().getName() + "|" + product.getSubCategory().getName() + "|" + product.getUnitPrice() + "|" + product.getTaxCategory().getName() + "|" + product.getStatus().name();
		fp.addNewProductInfoOnFile(info);
		
	}

	
	@Override
	public String toString()
	{
		return this.id + " " + this.name + " " + this.category.getName() + " " + this.subCategory.getName() + " " + this.unitPrice + " " + this.taxCategory.getName() + " " + this.status.name();
	}
}
