package bill;

import java.util.*;

public class BillQueue {

	
	 static List<Bill> queue = new ArrayList<Bill>();
	 static List<String> billNumberList =new ArrayList<String>() ;
	 
	 
	 // Getters
	 
	public List<Bill> getQueue() {
		return queue;
	}

	public static List<String> getBillNumberList() {
		return billNumberList;
	}

	
	 
	 
	 
	 
	 
	 
	 //Method to Generate Temp Bill Number
	
	 public String getTempBillNumber()
	 {
		 queue.sort(null);
		 int bNo = 0;
		 for(Bill x : queue)
		 {
			 bNo = Integer.parseInt(x.getNumber());
		 }
		 return String.valueOf(bNo + 1);
	 }
	 
	 //Method to get Index of a Bill
	 
	 public int getIndexOfABill(String billNumber)
	 {
		 int index  = -1;
		 for(Bill x : queue)
		 {
			 if(x.getNumber().equals(billNumber))
			 {
				 index = queue.indexOf(x);
			 }
		 }
		 return index;
	 }
	 
	 public void addBill(Bill bill)
	 {
		 queue.add(bill);	 
	 }
	 
	 public void removeBill(String billNumber)
	 {
		Bill bill = this.getBill(billNumber);
		queue.remove(bill);
	 }
	 
	 public void updateBill(Bill bill, String billNumber)
	 {
		 int index = this.getIndexOfABill(billNumber);
		 queue.set(index, bill);
	 }
	 
	 public Bill getBill(String billNumber)
	 {
		 Bill bill = null;
		 for(Bill x : queue)
		 {			 
			 if(x.getNumber().equals(billNumber))
			 {
				 bill = x;
			 }
		 }
		 return bill;
	 }
	 
	 public List<String> getAllBillNumber()
	 {
		 billNumberList.clear();
		 for(Bill x  :  queue)
		 {
			 billNumberList.add(x.getNumber());
		 }
		 return billNumberList;
	 }
	 
	 public boolean billNumberExists(String billNumber)
	 {
		 billNumberList.clear();
		 billNumberList = this.getAllBillNumber();
		 return billNumberList.contains(billNumber);
	 }
	 
	 public Bill getNextBill(String billNumber)
	 {
		 int noOfBills = this.getBillsInListCount();
		 Bill bill = null;	
		 for(Bill x : queue)
		 {
			 if(x.getNumber().equals(billNumber))
			 {
				 int index = queue.indexOf(x);
				 if(index < noOfBills - 1)
				 {
					 bill = queue.get(index + 1);
				 }
				 else if(index == noOfBills - 1)
				 {
					 bill = queue.get(index);
				 }
			 }
		 }  
		 return bill;
	 }
	 
	 public Bill getPreviousBill(String billNumber)
	 {
		 Bill bill = null;	
		 for(Bill x : queue)
		 {
			 if(x.getNumber().equals(billNumber))
			 {
				 int index = queue.indexOf(x);
				 if(index >= 1)
				 {
					 bill = queue.get(index - 1);
				 }
				 else
				 {
					 bill = queue.get(index);
				 }
			 }
		 }  
		 return bill;
	 }
	 
	 public int getBillsInListCount()
	 {
		 int count = 0;
		 for(Bill x : queue)
		 {
			 count++;
		 }
		 return count;
	 }
	 
	 public Bill popBillOutOfQueue(String billNumber)
	 {
		 Bill bill = null;
		 for(Bill x : queue)
		 {
			 if(x.getNumber().equals(billNumber))
			 {
				 bill = x;
			 }
		 }
		 return bill;
	 }
	 
	 public String getExitingBillNumber()
	 {
		 String billNumber = "";
		 for(Bill x : queue)
		 {
			 billNumber = x.getNumber();
		 }
		 return billNumber;
	 }
	 
}
