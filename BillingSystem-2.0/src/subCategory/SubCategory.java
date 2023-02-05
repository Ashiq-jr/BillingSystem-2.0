package subCategory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import category.Category;
import fileRepository.FileRepository;

public class SubCategory {
	
	Category category;
	String name;

	//Constructors
	public SubCategory() {
		
	}
	
	public SubCategory(Category category, String name) {
		this.category = category;
		this.name = name;
	}
	
	//Getters
	public Category getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}
	
	//Validation
	public void validateName()
	{
		if(this.getName().isBlank() || this.getName().length() < 3 || this.getName().length() > 25)
		{
			throw new IllegalArgumentException("Invalid Sub Category Name.");
		}
		else if( this.getName().startsWith("0") || this.getName().startsWith("1") || this.getName().startsWith("2") || this.getName().startsWith("3")|| this.getName().startsWith("4") || 
				this.getName().startsWith("5") || this.getName().startsWith("6") ||this.getName().startsWith("7")|| this.getName().startsWith("8") || this.getName().startsWith("9") )
		        {
		            throw new IllegalArgumentException("Invalid SubCategory Name. ");
		        }
		
	}
	
	

}