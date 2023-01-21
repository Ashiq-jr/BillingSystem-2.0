import java.io.IOException;
import java.util.*;

import category.Category;
import fileRepository.FileRepository;
import loginInfo.LoginInfo;
import product.*;
import store.Store;
import subCategory.SubCategory;


public class App {

	public static void main(String[] args) throws IOException {
		

		Product pr = new Product();
//		TreeMap<Integer, Product> hMap = pr.loadProducts();
//		for(Integer x : hMap.keySet())
//		{
//			System.out.println(hMap.get(x));
//		}
//		int id  = pr.generateProductId();
//		Category Cat = new Category("TEST");
//		SubCategory subcat = new SubCategory(Cat,"Test");
//		TaxCategory tax = new TaxCategory("LOW", 15);
//		Product p = new Product(id,"tt",Cat,subcat,200,tax, Status.ACTIVE);
//		p.addNewProduct(p);
//		System.out.print("added");
		

		
		List<Category> list = new ArrayList<Category>();
		Category cat1 = new Category("test1");
		Category cat2 = new Category("test2");
		Category cat3 = new Category("test3");
		Category cat4 = new Category("test4");
		Category cat5 = new Category("test5");
		list.add(cat1);
		list.add(cat2);
		list.add(cat3);
		list.add(cat4);
		list.add(cat5);
		
		String info = "";
		Iterator<Category> itr = list.iterator();
		while(itr.hasNext())
		{
			Category cat = (Category)itr.next();
			if(cat.getName().equals("test1"))
			{
				itr.remove();
			}
			else
			{
				info += cat.getName() + "\n";
			}
		}
		System.out.println(info);

		

}
}
