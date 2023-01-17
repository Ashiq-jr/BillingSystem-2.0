package fileRepository;

import java.io.*;
import java.util.*;

public class FileRepository {
	
	static List<String[]> list = new ArrayList<String[]>();
	
	final String storeDetailsPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\store.txt";
	final String OperatorLoginDetailsPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\logDetails.txt";

	
	
	
	
	
	public List<String[]> getStoreDetailsAsList() throws FileNotFoundException
	{
		list.clear();
		return list = loadFileData(storeDetailsPath);
	}
	
	public List<String[]> getOperatorLoginInfosAsList() throws FileNotFoundException
	{
		list.clear();
		return list = loadFileData(OperatorLoginDetailsPath);
	}
	
	public static List<String[]> loadFileData(String path) throws FileNotFoundException
	{
		File file = new File(path);
		list.clear();
		Scanner sc = new Scanner(file);
		while(sc.hasNext())
		{
			String temp[] = sc.nextLine().split("\\|");
			list.add(temp);
		}
		sc.close();
		return list;
	}

}


