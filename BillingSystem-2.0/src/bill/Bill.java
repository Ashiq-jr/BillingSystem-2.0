package bill;

import java.io.FileNotFoundException;
import java.util.List;

import product.ProductInCart;
import store.Address;
import store.Store;
import store.StoreRepository;

public class Bill {
	
	String shopName;
	String gstNumber;
	Address address;
	
	int number;
	String date;
	String customerId;
	List<ProductInCart> productsinCart;
	double total;
	
	//Getters
	public String getShopName() {
		return shopName;
	}


	public String getGstNumber() {
		return gstNumber;
	}


	public Address getAddress() {
		return address;
	}


	public int getNumber() {
		return number;
	}


	public String getDate() {
		return date;
	}


	public String getCustomerId() {
		return customerId;
	}


	public List<ProductInCart> getProductsinCart() {
		return productsinCart;
	}


	public double getTotal() {
		return total;
	}
	
	//Constructor
	public Bill(int number, String date, String customerId, List<ProductInCart> productsinCart, double total) {

		StoreRepository storeRep = new StoreRepository();
		Store store = null;
		try {
			store = storeRep.loadStoreDetails();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.shopName = store.getName();
		this.gstNumber = store.getGstNumber();
		this.address = store.getAddress();
		this.number = number;
		this.date = date;
		this.customerId = customerId;
		this.productsinCart = productsinCart;
		this.total = total;
	}


	@Override
	public String toString() {
		return "shopName=" + shopName + ", gstNumber=" + gstNumber + ", address=" + address + ", number=" + number
				+ ", date=" + date + ", customerId=" + customerId + ", productsinCart=" + productsinCart + ", total="
				+ total + "]";
	}

}
