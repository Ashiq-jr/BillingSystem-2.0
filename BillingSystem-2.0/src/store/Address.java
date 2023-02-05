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
	
	
	//Validation
	public void validateDoorNumber()
	{
		if(this.doorNo.isBlank() || this.doorNo.length() > 5)
		{
			throw new IllegalArgumentException("Door Number Length is Either 0 or Greater than 4.");
		}
	}
	
	public void validateArea()
	{
		if(this.area.contains("0") || this.area.contains("1") || this.area.contains("2") || this.area.contains("3")
		  || this.area.contains("4") || this.area.contains("5") || this.area.contains("6") ||this.area.contains("7")
		  || this.area.contains("8") || this.area.contains("9"))
		{
			throw new IllegalArgumentException("Area Name Can't Have Numbers. ");
		}
		else if(this.area.length() > 15)
		{
			throw new IllegalArgumentException("Invalid Area Name. ");
		}
	}
	
	public void validateCity()
	{
		if(this.city.contains("0") || this.city.contains("1") || this.city.contains("2") || this.city.contains("3")
		  || this.city.contains("4") || this.city.contains("5") || this.city.contains("6") ||this.city.contains("7")
		  || this.city.contains("8") || this.city.contains("9"))
		{
			throw new IllegalArgumentException("City Name Can't Have Numbers. ");
		}
		else if(this.city.length() > 20)
		{
			throw new IllegalArgumentException("Invalid City Name. ");
		}
	}
	
	public void validateState()
	{
		if(this.state.contains("0") || this.state.contains("1") || this.state.contains("2") || this.state.contains("3")
		  || this.state.contains("4") || this.state.contains("5") || this.state.contains("6") ||this.state.contains("7")
		  || this.state.contains("8") || this.state.contains("9"))
		{
			throw new IllegalArgumentException("State Name Can't Have Numbers. ");
		}
		else if(this.state.length() > 20)
		{
			throw new IllegalArgumentException("Invalid State Name. ");
		}
	}
	
	public void validatePinCode()
	{
		String pin = String.valueOf(this.getPincode());
		
		if( !(pin.startsWith("1") || pin.startsWith("2") || pin.startsWith("3")|| pin.startsWith("4") || 
				pin.startsWith("5") || pin.startsWith("6") ||pin.startsWith("7")|| pin.startsWith("8")) )
		{
			throw new IllegalArgumentException("Invalid Pin Code. ");
		}
		else if(pin.length() > 7)
		{
			throw new IllegalArgumentException("Invalid Pin Length. ");
		}
	}

	@Override
	public String toString()
	{
		return this.doorNo + " " + this.area + " " + this.city + " " + this.state + " " + this.pincode;
	}


}
