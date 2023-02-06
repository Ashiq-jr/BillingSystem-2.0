package product;

public enum Status {
	
	DISCONTINUED(0),
	ACTIVE(1);
	
	int code;
	
	//Getter
	public int getCode() {
		return code;
	}
	
	//Validate
	public boolean statusExists(String name) {
		
		Status[] statuses = Status.values();
		for(Status x : statuses)
		{
			if(x.name().equals(name))
			{
				return true;
			}
		}
		return false;		
	}
	
	public void validateStatus(String name) {
		
		if(!statusExists(name))
		{
			throw new IllegalArgumentException("Invalid Status");
		}
	}
	
	//Constructor
	Status(int code)
	{
		this.code = code;
	}

}
