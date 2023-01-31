package bill;

import java.io.*;
import java.util.*;

import product.Product;
import product.ProductInCart;
import product.ProductRepository;
import store.Store;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BillRepository {
	
	private static Bill currentBill;
	private static String currentBillNumber = "";
	private static String currentDate = "";
	private static List<ProductInCart> cartList = new ArrayList<ProductInCart>();
	
	
	//Method to Generate Bill Number. Also Creates a Folder on Toady's Date to Store the Bill Along with Bill File.
	
	public String generateBillNumber() throws IOException
	{
		//Create A Directory Using Today's Date 
		String directoryPath = "C:\\Users\\ashiq\\OneDrive\\Documents\\Bills\\";
        LocalDate ld = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = ld.format(dateFormatter);
        String year = ld.format(yearFormatter);
        directoryPath += date;
        File f = new File(directoryPath);
        if(!f.exists())
        {
            f.mkdir();
        }

        //Creating Bill Number File

        String enumerateBillFile_Path = "C:\\Users\\ashiq\\OneDrive\\Documents\\Bills\\"+ date +"\\enumerateBill.txt";
        File enumBill_File = new File(enumerateBillFile_Path);
        if(!enumBill_File.exists())
        {
            String billNo = year + "-INV-" + "0";
            FileWriter writer1 = new FileWriter(enumerateBillFile_Path);
            enumBill_File.createNewFile();
            writer1.write(billNo); 
            writer1.close();           
        }

        //Creating New Files Using Enum File

        File file = new File(enumerateBillFile_Path); 
        Scanner sc = new Scanner(file);
        String temp = sc.nextLine();
        sc.close();
        String val1 = temp.substring(0,15);
        String val2 = temp.substring(15,temp.length());
        String billNumber = val1 + String.valueOf(Integer.parseInt(val2) + 1);
        String billfilePath = "C:\\Users\\ashiq\\OneDrive\\Documents\\Bills\\"+ date +"\\" + billNumber + ".txt";
        File billFile = new File(billfilePath);
        billFile.createNewFile();

        //Changing enum Value in Enum File

        FileWriter writer2 = new FileWriter(enumerateBillFile_Path);       
        writer2.write(billNumber);
        writer2.close();
        
        currentBillNumber = billNumber;  
        currentDate = date;
		return billNumber;
		
	}
	
	
	public void storeBill(Bill bill) throws IOException
	{

        //Writing on New Bill File

		String billfilePath = "C:\\Users\\ashiq\\OneDrive\\Documents\\Bills\\"+ currentDate +"\\" + currentBillNumber + ".txt";
        FileWriter billWriter = new FileWriter(billfilePath);
        billWriter.write("BILL_DETAILS:" + "\n");
        billWriter.write(bill.getNumber() + "|" + bill.date + "|" + bill.getCustomerId() + "|" + bill.getEmpId() +"\n");
        Store store = bill.getStore();
        billWriter.write("\nSTORE_DETAILS:" +"\n");
        billWriter.write(store.getName() + "|" + store.getAddress().getDoorNo() + "|" + store.getAddress().getArea() + "|" + store.getAddress().getCity() + "|" + store.getAddress().getState() + "|" + store.getAddress().getPincode() + "|" + store.getGstNumber() + "|" + store.getMobileNum() + "|" + store.getMailId() +"\n");
        billWriter.write("\nITEMS_BOUGHT:" + "\n");
        for(ProductInCart x : bill.getProductsinCart())
        {
        	Product pr = x.getProduct();
            billWriter.write(x.getS_No() + "|" + pr.getName() + "|" +  pr.getUnitPrice() + "|" + x.getQuantity()  + "|" +  x.getNetPrice() + "\n");
        }
        billWriter.write("\nTOTAL:\n" + bill.getTotal() +"\n");
        billWriter.write("\nPAYMENT_TYPE:\n" + bill.getPayType().toString());
        billWriter.close();
	}
	
	public Bill loadBillUsingBillNumber(String billNumber) throws IOException
	{
		StoredBillInfoRepository sbRep = new StoredBillInfoRepository();		
		String folderName = sbRep.getBillDateUsingBillNumber(billNumber);
		String path = "C:\\Users\\ashiq\\OneDrive\\Documents\\Bills\\" + folderName + "\\" + billNumber + ".txt";
		
        File file = new File(path);
        List<String[]> billDetails = new ArrayList<String[]>();
        List<String[]> storeDetails = new ArrayList<String[]>();
        List<String[]> cart = new ArrayList<String[]>();
        String total = "";
        String payType = "";
        Scanner sc = new Scanner(file);
        sc.nextLine();
        while(sc.hasNext())
        {
            String temp = sc.next();           
            if(temp.equals("STORE_DETAILS:"))
            {
                break;
            }
            String[] sam = temp.split("\\|");
            billDetails.add(sam);
        }
        sc.nextLine();
        while(sc.hasNext())
        {
            String temp = sc.next();
            if(temp.equals("ITEMS_BOUGHT:"))
            {
                break;
            }
            String[] sam1 = temp.split("\\|");
            storeDetails.add(sam1);
        }
        sc.nextLine();
        while(sc.hasNext())
        {
            String temp = sc.next();
            if(temp.equals("TOTAL:"))
            {
                break;
            }
            String[] sam1 = temp.split("\\|");
            cart.add(sam1);
        }
        sc.nextLine();
        total = sc.nextLine();
        sc.nextLine();
        sc.nextLine();
        payType = sc.nextLine();
        sc.close();
        
        int custId = 0;
        int empId = 0;
        
        //Working on Bill Details
        for(String[] x : billDetails)
        {
        	currentBillNumber = x[0];
        	currentDate = x[1];
        	custId = Integer.parseInt(x[2]);
        	empId = Integer.parseInt(x[3]);
        }
        
        
        //Working on cart
        cartList.clear();
        for(String[] x : cart)
        {
        	ProductRepository prodRep = new ProductRepository();
        	int s_No = Integer.parseInt(x[0]);
        	String name = x[1];
        	Product product = prodRep.getProductUsingName(name);
        	int quantity = Integer.parseInt(x[3]);
        	double netPrice = Double.parseDouble(x[4]);
        	ProductInCart pc = new ProductInCart(s_No, product, quantity, netPrice);
        	cartList.add(pc);
        }
        
        //Creating Bill
        Bill bill = new Bill(currentBillNumber, currentDate, custId, empId, cartList, Double.parseDouble(total), PaymentType.valueOf(payType));
        return bill;
	}
	
	// Method to Hold Current Bill Details
	
	public void passCurrentBillDetails(Bill bill)
	{
		currentBill = new Bill(bill.getNumber(), bill.getDate(), bill.getCustomerId(), bill.getEmpId(), bill.getProductsinCart(), bill.getTotal(), bill.getPayType());
	}
	
	// Method to Pass Current Bill Details
	
	public Bill getCurrentBillDetails()
	{
		return currentBill;
	}
	
	// Method to Get Total Using Bill Number
	
	public double getTotalUsingBillNumber(String billNumber) throws IOException
	{
		Bill bill = this.loadBillUsingBillNumber(billNumber);
		return bill.getTotal();
	}


	








}
