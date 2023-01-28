package bill;

import java.util.*;

public class BillQueue {

	
	 static List<Bill> queue = new ArrayList<Bill>();
	 
	 
	 public List<Bill> getQueue() {
		return queue;
	}

	public static List<Integer> getBillNumberList() {
		return billNumberList;
	}

	static List<Integer> billNumberList =new ArrayList<Integer>() ;
	 
	 
	 
	 
	 
	 
	 //Method to Generate Temp Bill Number
	 public int getTempBillNumber()
	 {
		 queue.sort(null);
		 int bNo = 0;
		 for(Bill x : queue)
		 {
			 bNo = x.getNumber();
		 }
		 return bNo + 1;
	 }
	 
	 //Method to get Index of a Bill
	 
	 public int getIndexOfABill(int billNumber)
	 {
		 int index  = -1;
		 for(Bill x : queue)
		 {
			 if(x.getNumber() == billNumber)
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
	 
	 public void removeBill(int billNumber)
	 {
		 for(Bill x : queue)
		 {
			 if(x.getNumber() == billNumber)
			 {
				 int index = queue.indexOf(x);
				 queue.remove(index);
			 }
		 }
	 }
	 
	 public void updateBill(Bill bill, int index)
	 {
		 queue.set(index, bill);
	 }
	 
	 public Bill getBill(int billNumber)
	 {
		 Bill bill = null;
		 for(Bill x : queue)
		 {			 
			 if(x.getNumber() == billNumber)
			 {
				 bill = x;
			 }
		 }
		 return bill;
	 }
	 
	 public List<Integer> getAllBillNumber()
	 {
		 billNumberList.clear();
		 for(Bill x  :  queue)
		 {
			 billNumberList.add(x.getNumber());
		 }
		 return billNumberList;
	 }
	 
	 public boolean billNumberExists(int billNumber)
	 {
		 billNumberList.clear();
		 billNumberList = this.getAllBillNumber();
		 return billNumberList.contains(billNumber);
	 }
	 
	 public Bill getNextBill(int billNumber)
	 {
		 int noOfBills = this.getBillsInListCount();
		 Bill bill = null;	
		 for(Bill x : queue)
		 {
			 if(x.getNumber() == billNumber)
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
	 
	 public Bill getPreviousBill(int billNumber)
	 {
		 int noOfBills = this.getBillsInListCount();
		 Bill bill = null;	
		 for(Bill x : queue)
		 {
			 if(x.getNumber() == billNumber)
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
	 
}
