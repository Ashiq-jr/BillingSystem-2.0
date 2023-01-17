import java.io.FileNotFoundException;
import java.util.*;

import fileRepository.FileRepository;
import product.*;
import store.Store;


public class App {

	public static void main(String[] args) throws FileNotFoundException {
		
		Store store = new Store();
		store.getStoreDetails();
		System.out.println(store);

	}

}
