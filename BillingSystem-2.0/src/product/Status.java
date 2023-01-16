package product;

public enum Status {
	
	DISCONTINUED(0),
	ACTIVE(1);
	
	int code;
	
	public int getCode() {
		return code;
	}
	
	
	Status(int code)
	{
		this.code = code;
	}

}
