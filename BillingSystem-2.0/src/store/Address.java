package store;

public class Address {
	
	String doorNo;
	String area;
	String city;
	String state;
	int pincode;
	
	// Constructors	
	public Address() {
		
	}
	
	public Address(String doorNo, String area, String city, String state, int pincode) {
		super();
		this.doorNo = doorNo;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	// Getters
	public String getDoorNo() {
		return doorNo;
	}
	public String getArea() {
		return area;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public int getPincode() {
		return pincode;
	}
	
	@Override
	public String toString()
	{
		return this.doorNo + " " + this.area + " " + this.city + " " + this.state + " " + this.pincode;
	}


}
