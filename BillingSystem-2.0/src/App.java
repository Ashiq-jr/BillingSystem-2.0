import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import bill.Bill;
import bill.BillQueue;
import bill.BillRepository;
import bill.StoredBillInfoRepository;
import category.Category;
import customer.Customer;
import customer.CustomerRepository;
import employee.EmployeePerformance;
import employee.Performance;
import fileRepository.FileRepository;
import loginInfo.LoginInfo;
import product.*;
import store.Store;
import subCategory.SubCategory;


public class App {

	public static void main(String[] args) throws IOException {
		

//		Product pr = new Product();
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
		

		
//		List<Category> list = new ArrayList<Category>();
//		Category cat1 = new Category("test1");
//		Category cat2 = new Category("test2");
//		Category cat3 = new Category("test3");
//		Category cat4 = new Category("test4");
//		Category cat5 = new Category("test5");
//		list.add(cat1);
//		list.add(cat2);
//		list.add(cat3);
//		list.add(cat4);
//		list.add(cat5);
//		
//		String info = "";
//		Iterator<Category> itr = list.iterator();
//		while(itr.hasNext())
//		{
//			Category cat = (Category)itr.next();
//			if(cat.getName().equals("test1"))
//			{
//				itr.remove();
//			}
//			else
//			{
//				info += cat.getName() + "\n";
//			}
//		}
//		System.out.println(info);
		
//		int id  = 1;
//		Category Cat = new Category("TEST");
//		SubCategory subcat = new SubCategory(Cat,"Test");
//		TaxCategory tax = new TaxCategory("LOW", 15);
//		Product p = new Product(id,"tt",Cat,subcat,200,tax, Status.ACTIVE);
//		
//		int id1  = 2;
//		Category Cat1 = new Category("TEST2");
//		SubCategory subcat1 = new SubCategory(Cat,"Test2");
//		TaxCategory tax1 = new TaxCategory("LOW", 15);
//		Product pr = new Product(id1,"tt2",Cat1,subcat1,2001,tax1, Status.DISCONTINUED);
//		
//		
//		ProductInCart pc1 = new ProductInCart(1, p, 1, 1);
//		ProductInCart pc2 = new ProductInCart(2, pr, 2, 2);
//		
//		List<ProductInCart> list1 = new ArrayList<ProductInCart>();
//		list1.add(pc1);
//		list1.add(pc2);
//		
//		
//		int id2  = 3;
//		Category Cat2 = new Category("TEST3");
//		SubCategory subcat2 = new SubCategory(Cat2,"Test3");
//		TaxCategory tax2 = new TaxCategory("LOW", 15);
//		Product p2 = new Product(id2,"tt3",Cat2,subcat2,2002,tax2, Status.ACTIVE);
//		
//		int id3  = 4;
//		Category Cat3 = new Category("TEST4");
//		SubCategory subcat3 = new SubCategory(Cat,"Test4");
//		TaxCategory tax3 = new TaxCategory("LOW", 15);
//		Product pr2 = new Product(id3,"tt4",Cat3,subcat3,2003,tax3, Status.DISCONTINUED);
//		
//		
//		ProductInCart pc3 = new ProductInCart(1, p2, 1, 1);
//		ProductInCart pc4 = new ProductInCart(2, pr2, 2, 2);
//		
//		List<ProductInCart> list2 = new ArrayList<ProductInCart>();
//		list2.add(pc3);
//		list2.add(pc4);
		
		
		
		
		
//		Bill bill1 = new Bill(1, "26/01/23", "101", list1, 150);
//		Bill bill2 = new Bill(2,"26/01/23", "102", list2, 160);
//
//		BillQueue queue = new BillQueue();
//		queue.addBill(bill1);
//		queue.addBill(bill2);
//		
//		Bill test = queue.getPreviousBill(2);
//		System.out.println(test);
		
		
//		Customer customer = new Customer(1,"Ashiq",7395892452l,"ashiqjr7@gmail.com");
//		Customer customer1 = new Customer(2,"Ashiq",7395892452l,"ashiqjr7@gmail.com");
//		
//		CustomerRepository custRep = new CustomerRepository();
////		custRep.addCustToTempList(customer);
////		custRep.addCustToTempList(customer1);
//		System.out.println(custRep.getTempId());
		
//		CustomerRepository cp = new CustomerRepository();
//		int id  = cp.getIdUsingPhNumber(7395892452l);
//		System.out.println(id);
//		
//
//		List<String> employeeBillsList = new ArrayList<String>();
//		
//		StoredBillInfoRepository bp = new StoredBillInfoRepository();
//		EmployeePerformance per = new EmployeePerformance();
//		employeeBillsList = per.getThisWeeksCollection(110);
////		
//		for(String x : employeeBillsList)
//		{
//			System.out.println(x);
//		}
		
		
		
		
//		String temp = bp.getBillDateUsingBillNumber("2023-01-31-INV-1");
//		System.out.println(temp);
		
		
//		EmployeePerformance per = new EmployeePerformance();
//		double total = per.getThisMonthsCollection(109);
//
//		System.out.println(total);
		
//		BillRepository billRepository = new BillRepository();
//		double total = 0;
//		try {
//			total = billRepository.getShopsOneDayCollection();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		System.out.println(total);
		
//		List<String> billsList = new ArrayList<String>();
//		DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		String date = LocalDate.now().format(dFormatter);
//		
//		StoredBillInfoRepository bRepository = new StoredBillInfoRepository();
//		billsList = bRepository.getBillsBilledOnParticularDate(date);
//		
//		for(String x : billsList)
//		{
//			System.out.println(x);
//		}
		System.out.println("hi");
		
}
}
