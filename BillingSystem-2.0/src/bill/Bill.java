package bill;

import java.io.FileNotFoundException;
import java.util.List;

import product.ProductInCart;
import store.Address;
import store.Store;
import store.StoreRepository;

public class Bill {
	
	Store store;
	String number;															
	String date;
	int customerId;
	int empId;
	List<ProductInCart> productsinCart;
	double total;
	PaymentType payType;
	
	//Getters

	public Store getStore() {
		return store;
	}

	public String getNumber() {
		return number;
	}


	public String getDate() {
		return date;
	}


	public int getCustomerId() {
		return customerId;
	}


	public int getEmpId() {
		return empId;
	}

	public PaymentType getPayType() {
		return payType;
	}

	public List<ProductInCart> getProductsinCart() {
		return productsinCart;
	}


	public double getTotal() {
		return total;
	}
	
	//Constructor
	public Bill(String number, String date, int customerId, int empId, List<ProductInCart> productsinCart, double total, PaymentType payType) {

		StoreRepository storeRep = new StoreRepository();
		Store store = null;
		try {
			store = storeRep.loadStoreDetails();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.store = store;
		this.number = number;
		this.date = date;
		this.customerId = customerId;
		this.empId = empId;
		this.productsinCart = productsinCart;
		this.total = total;
		this.payType = payType;
	}


	@Override
	public String toString() {
		return "shopName=" + store.getName() + ", gstNumber=" + store.getGstNumber() + ", address=" + store.getAddress() + ", number=" + number
				+ ", date=" + date + ", customerId=" + customerId + ", productsinCart=" + productsinCart + ", total="
				+ total;
	}

}
