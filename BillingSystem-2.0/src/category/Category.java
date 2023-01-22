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
	
	
	@Override
	public String toString()
	{
		return this.name;
	}

}
