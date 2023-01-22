package store;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import fileRepository.FileRepository;

public class StoreRepository extends Store {
	
		// method to get Store Details as Object
		public Store getStoreDetails() throws FileNotFoundException
		{
			this.loadStoreDetails();
			Store store = new Store(this.name, this.address, this.gstNumber, this.mobileNum, this.mailId);
			return store;
		}
		
		//Method to load Store Data from File
		public void loadStoreDetails() throws FileNotFoundException
		{
			FileRepository fp = new FileRepository();
			List<String[]> list = fp.getStoreDetailsAsList();
			for(String[] x : list)
			{
				this.name = x[0];
				String doorNo = x[1];
				String area = x[2];
				String city = x[3];
				String state = x[4];
				int pinCode = Integer.parseInt(x[5]);
				Address address = new Address(doorNo, area, city, state, pinCode);
				this.address = address;
				this.gstNumber = x[6];
				this.mobileNum = Long.parseLong(x[7]);
				this.mailId = x[8];
			}
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
