package product;

public class Product {
	
	int id;
	String name;
	String category;
	String subCategory;
	double unitPrice;
	TaxCategory taxCategory;
	Status status;
	
	
	public Product(){	
	}
	
	public Product(int id, String name, String category, String subCategory, double unitPrice, TaxCategory taxCategory, Status status) {
		
		this.id = id;
		this.name = name;
		this.category = category;
		this.subCategory = subCategory;
		this.unitPrice = unitPrice;
		this.taxCategory = taxCategory;
		this.status = status;
	}

}
