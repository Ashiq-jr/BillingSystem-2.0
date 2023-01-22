package product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fileRepository.FileRepository;

public class TaxCategoryRepository {

	
	static List<TaxCategory> list = new ArrayList<TaxCategory>();
	static List<String> nameList = new ArrayList<String>();
	
	
		//Method to Load Tax Category as a List

		public List<TaxCategory> loadTaxcategory() throws IOException
		{
			list.clear();
			
			FileRepository fp = new FileRepository();
			List<String[]> taxList = fp.getTaxCategoriesAsList();
			for(String[] x : taxList)
			{
				TaxCategory tax = new TaxCategory(x[0], Double.parseDouble(x[1]));
				list.add(tax);
			}
			
			return list;
		}
		
		//Method to Check if the Tax Slab Exists
		
		public int checkTaxCategory(String x) throws IOException
		{
			list.clear();
			int count = 0;
			list = this.loadTaxcategory();
			for(TaxCategory z : list)
			{
				if(z.getName().toString().equals(x))
				{
					//return true;
					count++;
				}
			}
			return count;
			
		}
		
		// Method to get Tax Value Using the Name of the Tax Category
		
		public double getTaxValue(String name) throws IOException
		{
			double temp = 0;
			list.clear();
			list = this.loadTaxcategory();
			for(TaxCategory x : list)
			{
				if(x.getName().equals(name))
				{
					temp = x.getValue();
				}
			}
			return temp;
		}
		
		// Method to Add New Tax Category
		
		public void addTaxCategory(TaxCategory tax) throws IOException
		{
			FileRepository fp = new FileRepository();
			String info = "\n" + tax.getName() + "|" + tax.getValue();
			fp.addNewTaxCategoryInfoOnFile(info);
		}
		
		//Method to get List of Tax Category Names
		
		public List<String> getTaxCategoryNamesList() throws IOException
		{
			list.clear();
			list = this.loadTaxcategory();
			for(TaxCategory x : list)
			{
				nameList.add(x.getName());
			}
			return nameList;
		}
}
