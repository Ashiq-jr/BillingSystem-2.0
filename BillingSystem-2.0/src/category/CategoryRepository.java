package category;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fileRepository.FileRepository;

public class CategoryRepository {
	
	final String categoryInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\category.txt";
	static List<Category> list = new ArrayList<Category>();
	static List<String> categoryNamesList = new ArrayList<String>();
	
		//Method to Load Categories From File
		public List<Category> loadCategory() throws IOException
		{
			list.clear();
			FileRepository fp = new FileRepository();
			List<String[]> al = fp.loadFileData(categoryInfoPath);
			
			for(String[] x : al)
			{
				String name = x[0];
				Category category = new Category(name);
				list.add(category);
			}
			
			return list;
		}
		
		//Method to get List of Category Names
		public List<String> getCategoryNamesList() throws IOException
		{
			list.clear();
			list = this.loadCategory();
			for(Category x : list)
			{
				categoryNamesList.add(x.getName());
			}
			
			return categoryNamesList;
		}
		
		//Method to Add Category	
		public void addCategory(String name) throws IOException
		{
			categoryNamesList = getCategoryNamesList();
			if(categoryNamesList.contains(name))
			{
				throw new IllegalArgumentException("Category Already Exists.");
			}
			else {
				Category category = new Category(name);
				validateCategory(category);
				FileRepository fp = new FileRepository();
				fp.writeNewInfoOnFile(categoryInfoPath, "\n" + name);
			}
			
		}
		
		//Method to Remove a Category
		public void removeCategory(String remove) throws IOException
		{
			list.clear();
			list = this.loadCategory();
			String info = "";
			Iterator<Category> itr = list.iterator();
			while(itr.hasNext())
			{
				Category cat = (Category)itr.next();
				if(cat.getName().equals(remove))
				{
					itr.remove();
				}
				else
				{
					info += cat.getName() + "\n";
				}
			}
			FileRepository fp = new FileRepository();
			fp.overWriteDataInFile(categoryInfoPath, info.trim());;
			
		}
		
		//Validate Category
		
		private void validateCategory(Category category)
		{
			category.ValidateName();
		}

}
