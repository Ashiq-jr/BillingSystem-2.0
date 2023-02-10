package customer;

import personalInfo.PersonalInfo;

public class Customer extends PersonalInfo{
	
	//Constructor
	public Customer(int id, String name, long mobileNum, String mailId){
		
		super(id,name,mobileNum,mailId);

	}

	//Validation of Id
	@Override
	public void validateId()
	{
		String idString = String.valueOf(this.getId());
		if(idString.isBlank() || idString.length() != 9)
		{
			throw new IllegalArgumentException("Invalid Product Id.");
		}
		else if( !( idString.startsWith("1") || idString.startsWith("2") || idString.startsWith("3")|| idString.startsWith("4") || 
				idString.startsWith("5") || idString.startsWith("6") ||idString.startsWith("7")||idString.startsWith("8") || idString.startsWith("9") ) )
		        {
		            throw new IllegalArgumentException("Invalid Product Id. ");
		        }		
	}
	

}
