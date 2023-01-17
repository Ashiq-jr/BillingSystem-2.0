package fileRepository;

import java.io.*;
import java.util.*;

public class FileRepository {
	
	final String storeDetailsPath = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\store.txt";
	static List<String[]> list = new ArrayList<String[]>();
	
	
	
	
	
	public List<String[]> getStoreDetailsAsList() throws FileNotFoundException
	{
		list.clear();
		return list = loadFileData(storeDetailsPath);
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


