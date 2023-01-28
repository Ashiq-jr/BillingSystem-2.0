package product;

public class ProductInCart {

	int s_No;
	Product product;
	int quantity;
	double netPrice;
	
	
	//Getters
	public int getS_No() {
		return s_No;
	}
	public Product getProduct() {
		return product;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getNetPrice() {
		return netPrice;
	}
	
	
	
	//Constructors

	public ProductInCart(int s_No, Product product, int quantity, double netPrice) {
		
		this.s_No = s_No;
		this.product = product;
		this.quantity = quantity;
		this.netPrice = netPrice;
	}
	@Override
	public String toString() {
		return "s_No=" + s_No + ", product=" + product + ", quantity=" + quantity + ", netPrice="
				+ netPrice + "]";
	}
	
	
	

}
