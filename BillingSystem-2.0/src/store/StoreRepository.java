package store;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import fileRepository.FileRepository;

public class StoreRepository extends Store {
	
		
		//Method to load Store Data from File as Store Object
		public Store loadStoreDetails() throws FileNotFoundException
		{
			FileRepository fp = new FileRepository();
			List<String[]> list = fp.getStoreDetailsAsList();
			Store store = null;
			for(String[] x : list)
			{
				String name = x[0];
				String doorNo = x[1];
				String area = x[2];
				String city = x[3];
				String state = x[4];
				int pinCode = Integer.parseInt(x[5]);
				Address address = new Address(doorNo, area, city, state, pinCode);
				String gstNumber = x[6];
				long mobileNum = Long.parseLong(x[7]);
				String mailId = x[8];
				store = new Store(name,address, gstNumber, mobileNum, mailId);
			}
			return store;
		}
		
		//Method to Update Store Details
		public void updateStoreDetails(Store store) throws IOException
		{
			Address address = store.getAddress();		
			String temp = store.getName() + "|" + address.getDoorNo() + "|" + address.getArea() + "|" + address.city + "|" + address.getState() + "|" + address.getPincode() + "|" + store.getGstNumber() + "|" + store.getMobileNum() + "|" + store.getMailId();
			FileRepository fp = new FileRepository();
			fp.updateStoreInfoOnFile(temp);
		}

}
