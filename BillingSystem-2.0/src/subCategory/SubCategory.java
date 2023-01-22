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
	
	

}
