import java.io.FileNotFoundException;
import java.util.*;

import fileRepository.FileRepository;
import loginInfo.LoginInfo;
import product.*;
import store.Store;


public class App {

	public static void main(String[] args) throws FileNotFoundException {
		
		LoginInfo li = new LoginInfo();
		LoginInfo li2 = li.getInfoUsingId(102);
		System.out.println(li2);


	}

}
