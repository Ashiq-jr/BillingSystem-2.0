package product;


import category.Category;
import subCategory.SubCategory;

public class Product {

	int id;
	String name;
	Category category;
	SubCategory subCategory;
	double unitPrice;
	TaxCategory taxCategory;
	Status status;
	
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
	

	
	@Override
	public String toString()
	{
		return this.id + " " + this.name + " " + this.category.getName() + " " + this.subCategory.getName() + " " + this.unitPrice + " " + this.taxCategory.getName() + " " + this.status.name();
	}
}
