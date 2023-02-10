package personalInfo;


public class PersonalInfo {
	
	protected int id;
	protected String name;
	protected long mobileNum;
	protected String mailId;
	
	//Constructors
	public PersonalInfo() {
	
	}
	
	public PersonalInfo(int id, String name, long mobileNum, String mailId) {
		
		this.id = id;
		this.name = name;
		this.mobileNum = mobileNum;
		this.mailId = mailId;
	}
	
	//Getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getMobileNum() {
		return mobileNum;
	}

	public String getMailId() {
		return mailId;
	}
	
	//Validation
	public void validateId()
	{
		String idString = String.valueOf(this.getId());
		if(idString.isBlank() || idString.length() != 3)
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
	 
	 public void validateMailId() 
	 { 
		 if(this.mailId.isBlank() || this.mailId.length() < 15)
	     {
	    	throw new IllegalArgumentException("Invalid E-Mail Id.");
	     }	
	 }	
		    
		    

}
