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
		
		Category cat = new Category();
		cat.addCategory("test");
		

}
}
