package subCategory;

import java.io.FileNotFoundException;
import java.util.*;

import category.Category;
import fileRepository.FileRepository;

public class SubCategory {
	
	Category category;
	String name;
	
	static List<SubCategory> list = new ArrayList<SubCategory>();
	
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
	
	//Method to Load SubCategories From File

	public List<SubCategory> loadSubCategory() throws FileNotFoundException
	{
		list.clear();
		
		FileRepository fp = new FileRepository();
		List<String[]> subCatList = fp.getSubCategoriesAsList();
		for(String[] x : subCatList)
		{
			Category category = new Category(x[0]);
			SubCategory subCategory = new SubCategory(category, x[1]);
			list.add(subCategory);
		}
		
		return list;
	}

}
