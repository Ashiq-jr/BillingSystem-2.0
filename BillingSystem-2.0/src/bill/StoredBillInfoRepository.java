package bill;

import java.io.IOException;
import java.util.*;

import fileRepository.FileRepository;

public class StoredBillInfoRepository {
	
	static List<StoredBillInfo> billInfoList = new ArrayList<StoredBillInfo>();
	
	
	
	//Method to Load BillInfo's into a List
	
	public void loadStoreInfoList() throws IOException
	{
		billInfoList.clear();
		FileRepository fp = new FileRepository();
		List<String[]> list = fp.getStoredBillInfosAsList();
		
		for(String[] x : list)
		{
			StoredBillInfo info = new StoredBillInfo(x[0], x[1], Integer.parseInt(x[2]), Integer.parseInt(x[3]));
			billInfoList.add(info);			
		}
	}
	
	//Method to Write new BillInfo's inthe File
	
	public void writeNewBillInfo(StoredBillInfo storedBillInfo) throws IOException
	{
		String info = "\n" + storedBillInfo.getBillNumber() + "|" + storedBillInfo.getDate() + "|" + storedBillInfo.getCustomerId() + "|" + storedBillInfo.getEmployeeId();
		FileRepository fp = new FileRepository();
		fp.addStoredBillInfoOnFile(info);
	}

}
