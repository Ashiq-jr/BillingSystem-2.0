package product;

public class Product {
	
	int id;
	String name;
	String Category;
	double unitPrice;
	TaxCategory taxCategory;
	Status status;
	
	
	public Product(){	
	}
	
	public Product(int id, String name, String category, double unitPrice, TaxCategory taxCategory, Status status) {
		
		this.id = id;
		this.name = name;
		Category = category;
		this.unitPrice = unitPrice;
		this.taxCategory = taxCategory;
		this.status = status;
	}

}
