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
	

	//Validation
	public void validateId()
	{
		String idString = String.valueOf(this.getId());
		if(idString.isBlank() || idString.length() < 3 || idString.length() > 4)
		{
			throw new IllegalArgumentException("Invalid Product Id.");
		}
		else if( !( idString.startsWith("1") || idString.startsWith("2") || idString.startsWith("3")|| idString.startsWith("4") || 
				idString.startsWith("5") || idString.startsWith("6") ||idString.startsWith("7")||idString.startsWith("8") || idString.startsWith("9") ) )
		        {
		            throw new IllegalArgumentException("Invalid Product Id. ");
		        }		
	}
	
	public void validateName()
	{
		if(this.getName().isBlank() || this.getName().length() < 3 || this.getName().length() > 25)
		{
			throw new IllegalArgumentException("Invalid Product Name.");
		}
		else if( this.getName().startsWith("0") || this.getName().startsWith("1") || this.getName().startsWith("2") || this.getName().startsWith("3")|| this.getName().startsWith("4") || 
				this.getName().startsWith("5") || this.getName().startsWith("6") ||this.getName().startsWith("7")|| this.getName().startsWith("8") || this.getName().startsWith("9") )
		        {
		            throw new IllegalArgumentException("Invalid Product Name. ");
		        }	
	}
	
	public void validateUnitPrice() {
		
		String priceString = String.valueOf(this.getUnitPrice());
		
		if(priceString.isBlank() || priceString.startsWith("0") || priceString.length() > 5 || priceString.startsWith("-"))
		{
			throw new IllegalArgumentException("Invalid Unit Price.");
		}		
	}
	

	
	@Override
	public String toString()
	{
		return this.id + " " + this.name + " " + this.category.getName() + " " + this.subCategory.getName() + " " + this.unitPrice + " " + this.taxCategory.getName() + " " + this.status.name();
	}
}