package bill;

import java.io.*;
import java.util.*;

import product.Product;
import product.ProductInCart;
import store.Store;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BillRepository {
	
	private static String currentBillNumber = "";
	private static String currentDate = "";
	
	
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
        billWriter.write("BILL DETAILS : " + "\n");
        billWriter.write(bill.getNumber() + "|" + bill.date + "|" + bill.getCustomerId() + "|" + bill.getEmpId());
        Store store = bill.getStore();
        billWriter.write("\nSTORE DETAILS : " +"\n");
        billWriter.write(store.getName() + "|" + store.getAddress().getDoorNo() + "|" + store.getAddress().getArea() + "|" + store.getAddress().getCity() + "|" + store.getAddress().getState() + "|" + store.getAddress().getPincode() + "|" + store.getGstNumber() + "|" + store.getMobileNum() + "|" + store.getMailId());
        billWriter.write("\nITEMS BOUGHT  " + "\n");
        for(ProductInCart x : bill.getProductsinCart())
        {
        	Product pr = x.getProduct();
            billWriter.write(x.getS_No() + "|" + pr.getName() + "|" +  pr.getUnitPrice() + "|" + x.getQuantity()  + "|" +  x.getNetPrice() + "\n");
        }
        billWriter.write("TOTAL : \n" + bill.getTotal());
        billWriter.write("\nPAYMENT TYPE : \n" + bill.getPayType().toString());
        billWriter.close();
	}
		


	








}
