package category;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fileRepository.FileRepository;

public class Category {
	
	String name;
	
	static List<Category> list = new ArrayList<Category>();
	
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
	
	
	//Method to Load Categories From File
	public List<Category> loadCategory() throws IOException
	{
		list.clear();
		List<String[]> al = new ArrayList<String[]>();
		FileRepository fp = new FileRepository();
		al = fp.getCategoriesAsList();
		
		for(String[] x : al)
		{
			String name = x[0];
			Category category = new Category(name);
			list.add(category);
		}
		
		return list;
	}

}
