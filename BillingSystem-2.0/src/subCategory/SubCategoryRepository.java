 package subCategory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import category.Category;
import fileRepository.FileRepository;

public class SubCategoryRepository {
	
	final String subCategoryInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\subcategory.txt";
	static List<SubCategory> list = new ArrayList<SubCategory>();
	static List<String> nameList = new ArrayList<String>();
	
	
	
	//Method to Load SubCategories From File

		public List<SubCategory> loadSubCategory() throws FileNotFoundException
		{
			list.clear();
			
			FileRepository fp = new FileRepository();
			List<String[]> subCatList = fp.loadFileData(subCategoryInfoPath);
			for(String[] x : subCatList)
			{
				Category category = new Category(x[0]);
				SubCategory subCategory = new SubCategory(category, x[1]);
				list.add(subCategory);
			}
			
			return list;
		}
		
		//Method to Add SubCategory
		
		public void addSubCategory(SubCategory subcategory) throws IOException
		{
			nameList = getNameList();
			if(nameList.contains(subcategory.getName()))
			{
				throw new IllegalArgumentException("SubCategory Already Exists.");
			}
			validateSubCategory(subcategory);
			FileRepository fp = new FileRepository();
			String info = "\n" + subcategory.getCategory().getName() + "|" + subcategory.getName();
			fp.writeNewInfoOnFile(subCategoryInfoPath, info);
		}
		
		//Method to get List of Sub Category Names
		
		public List<String> getNameList() throws FileNotFoundException
		{
			list.clear();
			list = this.loadSubCategory();
			for(SubCategory x : list)
			{
				nameList.add(x.getName());
			}
			return nameList;
		}
		
		//Method to Remove SubCategory
		
		public void removeSubCategory(String name) throws IOException
		{
			list.clear();
			list = this.loadSubCategory();
			
			Iterator<SubCategory> itr = list.iterator();
			String info = "";
			while(itr.hasNext())
			{
				SubCategory subCat = (SubCategory)itr.next();
				if(subCat.getName().equals(name))
				{
					itr.remove();
				}
				else
				{
					info += subCat.getCategory().getName() + "|" + subCat.getName() + "\n";
				}
			}
			
			FileRepository fp = new FileRepository();
			fp.overWriteDataInFile(subCategoryInfoPath, info.trim());
			
		}
		
		//Validate SubCategory
		
		private void validateSubCategory(SubCategory subCategory)
		{
			subCategory.validateName();
			Category category = subCategory.getCategory();
			category.ValidateName();
		}

		
		
		

}
