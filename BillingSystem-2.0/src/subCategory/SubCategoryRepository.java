package subCategory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import category.Category;
import fileRepository.FileRepository;

public class SubCategoryRepository extends SubCategory {
	
	
	static List<SubCategory> list = new ArrayList<SubCategory>();
	static List<String> nameList = new ArrayList<String>();
	
	
	
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
		
		//Method to Add SubVategory
		
		public void addSubCategory(SubCategory subcategory) throws IOException
		{
			FileRepository fp = new FileRepository();
			String info = "\n" + subcategory.getCategory().getName() + "|" + subcategory.getName();
			fp.addNewSubCategoryInfoOnFile(info);
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

}