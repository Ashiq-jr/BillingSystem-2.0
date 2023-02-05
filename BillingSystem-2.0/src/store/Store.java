package store;


public class Store {

	String name;
	Address address;
	String gstNumber;
	long mobileNum;
	String mailId;
	
	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public long getMobileNum() {
		return mobileNum;
	}

	public String getMailId() {
		return mailId;
	}
	
	
	public Store() {
		
	}
	
	public Store(String name, Address address, String gstNumber, long mobileNum, String mailId) {
		
		this.name = name;
		this.address = address;
		this.gstNumber = gstNumber;
		this.mobileNum = mobileNum;
		this.mailId = mailId;
	}
	
	
	
	//Validation
	public void validateStoreName()
	{
		if(this.name.isBlank() || this.name.length() < 7 || this.name.length() > 25)
		{
			throw new IllegalArgumentException("Store Name Length is Either 0 or Greater than 25.");
		}
	}
	
	public void validateGstNumber() {
		
		if(this.gstNumber.isBlank() || this.gstNumber.length() < 10 || this.gstNumber.length() > 20)
		{
			throw new IllegalArgumentException("GST Number Length is Either 0 or Greater than 20.");
		}
		
	}
	
    public void validateMobileNum()
    {
        String number = String.valueOf(this.mobileNum);
        if(number.length() != 10 )
        {
            throw new IllegalArgumentException("Invalid Number Length");
        }
        else if(!(number.startsWith("1") || number.startsWith("2") || number.startsWith("3")|| number.startsWith("4") || 
        number.startsWith("5") || number.startsWith("6") ||number.startsWith("7")|| number.startsWith("8") || number.startsWith("9")))
        {
            throw new IllegalArgumentException("Invalid Mobile Number");
        }
    }
    
    public void validateMailId() {
    	
    	if(this.mailId.isBlank() || this.mailId.length() < 15)
    	{
    		throw new IllegalArgumentException("Invalid E-Mail Id.");
    	}
    	
    }
	
	@Override
	public String toString()
	{
		return this.name + " " + this.address + " " + this.gstNumber + " " + this.mobileNum + " " + this.mailId;
	}
	
	
	
	

}
