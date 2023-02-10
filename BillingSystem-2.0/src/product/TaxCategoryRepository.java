package product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fileRepository.FileRepository;

public class TaxCategoryRepository {

	final String taxCategoryInfoPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\taxCategory.txt";	
	static List<TaxCategory> list = new ArrayList<TaxCategory>();
	static List<String> nameList = new ArrayList<String>();
	
	
		//Method to Load Tax Category as a List

		public List<TaxCategory> loadTaxcategory() throws IOException
		{
			list.clear();
			
			FileRepository fp = new FileRepository();
			List<String[]> taxList = fp.loadFileData(taxCategoryInfoPath);
			for(String[] x : taxList)
			{
				TaxCategory tax = new TaxCategory(x[0], Double.parseDouble(x[1]));
				list.add(tax);
			}
			
			return list;
		}
		
		// Method to get Tax Value Using the Name of the Tax Category
		
		public double getTaxValue(String name) throws IOException
		{
			double temp = 0;
			list.clear();
			list = this.loadTaxcategory();
			nameList.clear();
			nameList = this.getTaxCategoryNamesList();
			if(nameList.contains(name))
			{
				for(TaxCategory x : list)
				{
					if(x.getName().equals(name))
					{
						temp = x.getValue();
					}
				}
				return temp;
			}
			else {
				throw new IllegalArgumentException("Tax Category Doesnt Exist");
			}
		}
		
		// Method to Add New Tax Category
		
		public void addTaxCategory(TaxCategory tax) throws IOException
		{
			nameList.clear();
			nameList = this.getTaxCategoryNamesList();
			if(nameList.contains(tax.getName()))
			{
				throw new IllegalArgumentException("TaxCategory Already Exists");
			}
			else {
				validateTaxCategory(tax);
				FileRepository fp = new FileRepository();
				String info = "\n" + tax.getName() + "|" + tax.getValue();
				fp.writeNewInfoOnFile(taxCategoryInfoPath, info);				
			}
			
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
		
		//Method to remove a Tax Category
		
		public void removeTaxCategory(String name) throws IOException
		{
			list.clear();
			list = this.loadTaxcategory();
			nameList.clear();
			nameList = this.getTaxCategoryNamesList();
			if(nameList.contains(name))
			{
				Iterator<TaxCategory> itr = list.iterator();
				String info = "";
				while(itr.hasNext())
				{
					TaxCategory tax = (TaxCategory) itr.next();
					if(!tax.getName().equals(name))
					{
						info += tax.getName() + "|" + tax.getValue() + "\n";
					}
				}
				FileRepository fp = new FileRepository();
				fp.overWriteDataInFile(taxCategoryInfoPath, info.trim());
			}
			else {
				throw new IllegalArgumentException("Tax Category Doesnt Exist.");
			}
			
		}
		
		//Method to Edit a Tax Category
		
		public void editTaxCategory(TaxCategory taxCategory) throws IOException
		{
			list.clear();
			list = this.loadTaxcategory();
			nameList.clear();
			nameList = this.getTaxCategoryNamesList();
			if(nameList.contains(taxCategory.getName()))
			{
				Iterator<TaxCategory> itr = list.iterator();
				String info = "";			
				while(itr.hasNext())
				{
					TaxCategory tax = (TaxCategory) itr.next();
					if(tax.getName().equals(taxCategory.getName()))
					{
						info += taxCategory.getName() + "|" + taxCategory.getValue() + "\n";
					}
					else {
						info += tax.getName() + "|" + tax.getValue() + "\n";
					}
					
				}
				FileRepository fp = new FileRepository();			
				fp.overWriteDataInFile(taxCategoryInfoPath, info.trim());
			}
			else {
				throw new IllegalArgumentException("TaxCategory Doesnt Exist.");
			}
		}
		
		//Validate Tax Category
		
		private void validateTaxCategory(TaxCategory taxCategory)
		{
			taxCategory.validateName();
			taxCategory.validateTaxValue();
		}
}
