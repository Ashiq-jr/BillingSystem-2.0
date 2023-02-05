package category;

public class Category {
	
	String name;
	
	//Constructors
	public Category(){
		
	}
	
	public Category(String name) {
		this.name = name;
	}

	//Getter
	public String getName() {
		return name;
	}
	
	//Validation
	public void ValidateName()
	{
		if(this.getName().isBlank() || this.getName().length() < 3 || this.getName().length() > 25)
		{
			throw new IllegalArgumentException("Invalid Category Name.");
		}
		else if( this.getName().startsWith("0") || this.getName().startsWith("1") || this.getName().startsWith("2") || this.getName().startsWith("3")|| this.getName().startsWith("4") || 
				this.getName().startsWith("5") || this.getName().startsWith("6") ||this.getName().startsWith("7")|| this.getName().startsWith("8") || this.getName().startsWith("9") )
		        {
		            throw new IllegalArgumentException("Invalid Category Name. ");
		        }
	}
	
	
	@Override
	public String toString()
	{
		return this.name;
	}

}
