package employee;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.TreeMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import product.Product;
import product.ProductRepository;

class EmployeeRepositoryTest {

	@Test
    @DisplayName("Should Return a TreeMap Of Employee Objects")
    public void shouldFetchEmployeesFromFile()
    { 
    	TreeMap<Integer, Employee> tMap = new TreeMap<Integer,Employee>();
    	assertEquals(0, tMap.size());
    	EmployeeRepository repository = new EmployeeRepository();
    	try {
    		tMap = repository.loadEmployeeInfo();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	assertNotEquals(0, tMap.size());
    	
    }
	
	@Test
    @DisplayName("Should Return a List Of Employee Id's")
    public void shouldGiveAListOfEmployeeIds()
    { 
    	List<Integer> list = new ArrayList<Integer>();
    	assertEquals(0, list.size());
    	EmployeeRepository repository = new EmployeeRepository();
    	try {
			list = repository.getEmployeeIdList();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	boolean expected = list.contains(101);
    	assertNotEquals(0, list.size());
    	assertEquals(expected, true);
    	
    }
	
	 @Test
	    @DisplayName("Should Return a Employee Object Given His Id")
	    public void shouldReturnAEmployeeGivenHisId()
	    {
		 	EmployeeRepository repository = new EmployeeRepository();
	    	String actualName = "ASHIQ";
	    	String actualPosition = "ADMIN";
	    	int id = 101;
	    	Employee employee = null;
	    	try {
	    		employee = repository.findEmployeeById(id);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	    	
	    	String expectedName = employee.getName();
	    	String expectedPosition = employee.getDesignation().toString();
	    	assertEquals(expectedName, actualName);
	    	assertEquals(expectedPosition, actualPosition);
	    	  	
	    }
	    
	    @Test
	    @DisplayName("Should Not Return a Employee Object if Id is InValid Id")
	    public void shouldThrowIllegalArgumentExceptionGivenUnavailableId()
	    {
	    	EmployeeRepository repository = new EmployeeRepository();
	    	int id = 100;
	    	
	    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    		Employee employee = repository.findEmployeeById(id);
	    	});
	    }
	    
	    @Test
	    @DisplayName("Should Return a Employee Object Given His Name")
	    public void shouldReturnAEmployeeGivenHisName()
	    {
		 	EmployeeRepository repository = new EmployeeRepository();
	    	String actualName = "ASHIQ";
	    	String actualPosition = "ADMIN";
	    	int actualId = 101;
	    	Employee employee = null;
	    	try {
	    		employee = repository.findEmployeeByName(actualName);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	    	
	    	String expectedName = employee.getName();
	    	int expectedId = employee.getId();
	    	String expectedPosition = employee.getDesignation().toString();
	    	assertEquals(expectedName, actualName);
	    	assertEquals(expectedId, actualId);
	    	assertEquals(expectedPosition, actualPosition);
	    	  	
	    }
	    
	    @Test
	    @DisplayName("Should Not Return a Employee Object if Id is InValid Name")
	    public void shouldThrowIllegalArgumentExceptionGivenUnavailableName()
	    {
	    	EmployeeRepository repository = new EmployeeRepository();
	    	String name = "ram";
	    	
	    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    		Employee employee = repository.findEmployeeByName(name);
	    	});
	    }
	    
	    @Test
	    @DisplayName("Should Return a Employee's Name Given His Id")
	    public void shouldReturnEmployeeNameGivenHisId()
	    {
		 	EmployeeRepository repository = new EmployeeRepository();
	    	String actualName = "ASHIQ";
	    	int id = 101;
	    	String expectedName = "";
	    	try {
	    		expectedName = repository.getNameUsingId(id);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	    	assertEquals(expectedName, actualName); 	
	    }
	    
	    @Test
	    @DisplayName("Should Not Return Employee's Name Given InValid Id")
	    public void shouldThrowIllegalArgumentExceptionGivenUnavailableIdToGetName()
	    {
	    	EmployeeRepository repository = new EmployeeRepository();
	    	int id = 100;
	    	
	    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    		String employeeName = repository.getNameUsingId(id);
	    	});
	    }
	    
	    @Test
	    @DisplayName("Should Return a Employee's Id Given His Name")
	    public void shouldReturnEmployeeIdGivenHisName()
	    {
		 	EmployeeRepository repository = new EmployeeRepository();
	    	String name = "ASHIQ";
	    	int actualId = 101;
	    	int expectedId= 0;
	    	try {
	    		expectedId = repository.getIdUsingName(name);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	    	assertEquals(expectedId, actualId); 	
	    }
	    
	    @Test
	    @DisplayName("Should Not Return Employee's Id Given InValid Name")
	    public void shouldThrowIllegalArgumentExceptionGivenUnavailableNameToGetId()
	    {
	    	EmployeeRepository repository = new EmployeeRepository();
	    	String name = "ram";
	    	
	    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    		int id = repository.getIdUsingName(name);
	    	});
	    }
	    
	    @Test
	    @DisplayName("Should Generate New Employee Id.")
	    public void shouldGenerateEmployeeId() {
	    	List<Integer> list = new ArrayList<Integer>();
	    	assertEquals(0, list.size());
	    	EmployeeRepository repository = new EmployeeRepository();
	    	try {
				list = repository.getEmployeeIdList();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	int actualId = 0;
	    	for(Integer x : list)
	    	{
	    		actualId = x;
	    	}
	    	int expectedId = 0;
	    	try {
				expectedId = repository.generateNewEmployeeId();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	    	assertEquals(expectedId, actualId+1);
	    }
	    
	    @Test
	    @DisplayName("Should Return True If a Employee's Id Exists")
	    public void shouldReturnTrueIfEmployeeIdExists()
	    {
		 	EmployeeRepository repository = new EmployeeRepository();
	    	int id = 101;
	    	boolean expectedResult = false;
	    	try {
	    		expectedResult = repository.checkIfIdExists(id);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	    	assertEquals(expectedResult, true); 	
	    }
	      
	    @Test
	    @DisplayName("Should Throw Illegal Argument Exception Given Invalid Id")
	    public void shouldThrowIllegalArgumentExceptionGivenInvalidId()
	    {
	    	EmployeeRepository repository = new EmployeeRepository();
	    	int id = 100;
	    	
	    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    		boolean expectedResult = repository.checkIfIdExists(id);
	    	});
	    }
	    
	    @Test
	    @DisplayName("Should Return False If a Given Phone Number Doesnt Exists")
	    public void shouldReturnFalseIfAMobileNumberDoesntExists()
	    {
		 	EmployeeRepository repository = new EmployeeRepository();
	    	long mobileNum = 7396892452l;
	    	boolean expectedResult = true;
	    	try {
	    		expectedResult = repository.checkIfPhNumberExists(mobileNum);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	    	assertEquals(expectedResult, false); 	
	    }
	    
	    @Test
	    @DisplayName("Should Throw Illegal Argument Exception Given Mobile Number That Already Exists")
	    public void shouldThrowIllegalArgumentExceptionGivenDuplicateMobileNum()
	    {
	    	EmployeeRepository repository = new EmployeeRepository();
	    	long mobileNum = 7395892452l;
	    	
	    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    		boolean expectedResult = repository.checkIfPhNumberExists(mobileNum);
	    	});
	    }
	    
	    @Test
	    @DisplayName("Should Return False If a Given Email Doesnt Exists")
	    public void shouldReturnFalseIfAEmailIdDoesntExists()
	    {
		 	EmployeeRepository repository = new EmployeeRepository();
	    	String mailId = "123@gmail.com";
	    	boolean expectedResult = true;
	    	try {
	    		expectedResult = repository.checkIfEmailExists(mailId);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	    	assertEquals(expectedResult, false); 	
	    }
	    
	    @Test
	    @DisplayName("Should Throw Illegal Argument Exception Given Email Id That Already Exists")
	    public void shouldThrowIllegalArgumentExceptionGivenDuplicateEmailId()
	    {
	    	EmployeeRepository repository = new EmployeeRepository();
	    	String mailId = "ashiqjr7@gmail.com";
	    	
	    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    		boolean expectedResult = repository.checkIfEmailExists(mailId);
	    	});
	    }
	    
	    @Test
	    @DisplayName("Should Add An Employee")
	    public void shouldAddAnEmployee() 
	    {
	    	EmployeeRepository repository = new EmployeeRepository();
	    	int id = 0;
			try {
				id = repository.generateNewEmployeeId();
				Employee employee = new Employee(id, "ARUN", 9767089098l, "arun34@gmail.com", Designation.OPERATOR);
				repository.addEmployee(employee);
			} catch (IOException e) {				
				e.printStackTrace();
			}
			
			List<Integer> list = new ArrayList<Integer>();
	    	assertEquals(0, list.size());
	    	try {
				list = repository.getEmployeeIdList();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	boolean expected = list.contains(id);
			assertEquals(expected, true);
			
	    	
	    }
	    
	    @Test
	    @DisplayName("Should Not Add A Duplicate Employee")
	    public void shouldThrowIllegalArgumentExceptionIfEmployeeAlreadyExists() 
	    {
	    	EmployeeRepository repository = new EmployeeRepository();
	    	
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				int id = repository.generateNewEmployeeId();
				Employee employee = new Employee(id, "ASHIQ", 7395892452L, "ashiqjr7@gmail.com", Designation.ADMIN);
				repository.addEmployee(employee);
	    	});
				    	
	    }
	    
	    @AfterAll
	    @DisplayName("To Remove Details Added In File During Testing.")
	    public static void removeValuesInFileAddedDuringTesting()
	    {
	    	EmployeeRepository repository = new EmployeeRepository();
	    	List<Integer> list = new ArrayList<Integer>();
	    	try {
				list = repository.getEmployeeIdList();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	int id = 0;
	    	for(Integer x : list)
	    	{
	    		id = x;
	    	}
	    	try {
				repository.removeEmploee(id);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }

	    

}
