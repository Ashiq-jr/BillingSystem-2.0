package employee;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.*;

import bill.BillRepository;
import bill.StoredBillInfoRepository;

public class EmployeePerformance {
	
	static List<String> employeeBillsList = new ArrayList<String>();
	static Performance performance;
	
	
	
	
	
	
	public double getTodaysCollection(int empId) throws IOException
	{
		double total = 0;
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String date = LocalDate.now().format(format);
		StoredBillInfoRepository sbRep = new StoredBillInfoRepository();
		BillRepository billRep = new BillRepository();
		employeeBillsList.clear();
		try {
			employeeBillsList = sbRep.getBillNumbersUsingEmployeeId(empId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String billDate = "";
		for(String x :employeeBillsList)
		{
			billDate = sbRep.getBillDateUsingBillNumber(x);
			if(billDate.equals(date))
			{
				double temp = billRep.getTotalUsingBillNumber(x);
				total += temp;
			}
		}
		
		return total;
	}
	
	public double getThisWeeksCollection(int empId) throws IOException
	{
		double total = 0;
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String date = LocalDate.now().format(format);
		int thisWeek = this.getWeekNumber(date);
		StoredBillInfoRepository sbRep = new StoredBillInfoRepository();
		BillRepository billRep = new BillRepository();
		employeeBillsList.clear();
		try {
			employeeBillsList = sbRep.getBillNumbersUsingEmployeeId(empId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String billDate = "";
		for(String x :employeeBillsList)
		{
			billDate = sbRep.getBillDateUsingBillNumber(x);
			int billWeek = this.getWeekNumber(billDate);
			if(billWeek == thisWeek)
			{
				double temp = billRep.getTotalUsingBillNumber(x);
				total += temp;
			}
		}
		
		return total;
	}
	
	public double getThisMonthsCollection(int empId) throws IOException
	{
		double total = 0;
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String date = LocalDate.now().format(format);
		int thisMonth = this.getMonthNumber(date);
		StoredBillInfoRepository sbRep = new StoredBillInfoRepository();
		BillRepository billRep = new BillRepository();
		employeeBillsList.clear();
		try {
			employeeBillsList = sbRep.getBillNumbersUsingEmployeeId(empId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String billDate = "";
		for(String x :employeeBillsList)
		{
			billDate = sbRep.getBillDateUsingBillNumber(x);
			int billMonth = this.getMonthNumber(billDate);
			if(billMonth == thisMonth)
			{
				double temp = billRep.getTotalUsingBillNumber(x);
				total += temp;
			}
		}
		
		return total;
	}
	
	public Performance getToadysPerformance(int empId) throws IOException
	{
		double amount = this.getTodaysCollection(empId);
		if(amount >= 2000)
		{
			performance = Performance.EXCELLENT;
		}
		else if ( amount < 2000 && amount >= 1000 )
		{
			performance = Performance.AVERAGE;
		}
		else
		{
			performance = Performance.POOR;
		}
		
		return performance;
	}
	
	public Performance getThisWeeksPerformance(int empId) throws IOException
	{
		double amount = this.getTodaysCollection(empId);
		if(amount >= 10000)
		{
			performance = Performance.EXCELLENT;
		}
		else if ( amount < 10000 && amount >= 5000 )
		{
			performance = Performance.AVERAGE;
		}
		else
		{
			performance = Performance.POOR;
		}
		
		return performance;
	}
	
	public Performance getThisMonthsPerformance(int empId) throws IOException
	{
		double amount = this.getTodaysCollection(empId);
		if(amount >= 35000)
		{
			performance = Performance.EXCELLENT;
		}
		else if ( amount < 35000 && amount >= 20000 )
		{
			performance = Performance.AVERAGE;
		}
		else
		{
			performance = Performance.POOR;
		}
		
		return performance;
	}
	
	public int getWeekNumber(String inpDate)
	{
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(inpDate, format);
        WeekFields weekFields = WeekFields.of(Locale.getDefault()); 
        int weekNumber = date.get(weekFields.weekOfWeekBasedYear());
        return weekNumber;
	}
	
	public int getMonthNumber(String inpDate)
	{
		String month = inpDate.substring(3, 5);
		return Integer.parseInt(month);
	}
	

}
