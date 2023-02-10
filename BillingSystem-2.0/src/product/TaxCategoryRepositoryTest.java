package product;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaxCategoryRepositoryTest {

	@Test
    @DisplayName("Returns a List Of TaxCategory Objects")
    public void shouldFetchTaxCategoriesFromFile()
    { 
    	List<TaxCategory> list = new ArrayList<TaxCategory>();
    	assertEquals(0, list.size());
    	TaxCategoryRepository repository = new TaxCategoryRepository();
    	try {
			list = repository.loadTaxcategory();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	assertNotEquals(0, list.size());
    	
    }
	
	@Test
	@DisplayName("Returns Tax Value Given the Tax Category")
	public void ShouldReturnTaxValue()
	{
		TaxCategoryRepository repository = new TaxCategoryRepository();
		double expectedValue = 0.0;
		try {
			expectedValue = repository.getTaxValue("HIGH");
		} catch (IOException e) {
			e.printStackTrace();
		}
		double actualValue = 18.0;
		
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	@DisplayName("Should Not Return Tax Value If the Given Tax Category Doesnt Exists")
	public void ShouldNotReturnTaxValue_ThrowsIllegalArgumentException()
    {
    	TaxCategoryRepository repository = new TaxCategoryRepository();
    	 Assertions.assertThrows(IllegalArgumentException.class, () -> {
             repository.getTaxValue("high");
         });
    }
	
	@Test
	@DisplayName("Should Return a List Of Tax Category Names")
	public void ShouldReturnTaxCategoriesList() {
		
		List<String> list = new ArrayList<String>();
		TaxCategoryRepository repository = new TaxCategoryRepository();
		assertEquals(0, list.size());
    	try {
			list = repository.getTaxCategoryNamesList();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	assertNotEquals(0, list.size());
    	String actualTax = "NO";
    	String expectedTax = list.get(0);
    	assertEquals(expectedTax, actualTax);
		
	}
	
    @Test
    @DisplayName("Should Not Write Illegal Tax Category Values in File")
    public void shouldThrowIllegalArgumentExceptionGivenObjectWithIllegalFields()
    {
    	TaxCategoryRepository repository = new TaxCategoryRepository();
    	TaxCategory taxCategory = new TaxCategory("1", 1.0);
    	 Assertions.assertThrows(IllegalArgumentException.class, () -> {
             repository.addTaxCategory(taxCategory);
         });
    }
    
    @Test
    @DisplayName("Should Not Write Duplicate Tax Category Values in File")
    public void shouldThrowIllegalArgumentExceptionGivenDuplicateTaxCategory()
    {
    	TaxCategoryRepository repository = new TaxCategoryRepository();
    	TaxCategory taxCategory = new TaxCategory("NO", 1.0);
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
             repository.addTaxCategory(taxCategory);
         });
    }
    
    @Test
    @DisplayName("Should Write a Tax Category in File")
    public void shouldAddATaxCategoryInFile()
    {
    	List<String> list = new ArrayList<String>();
    	TaxCategoryRepository repository = new TaxCategoryRepository();
    	TaxCategory taxCategory = new TaxCategory("TEST", 1.0);
    	try {
			repository.addTaxCategory(taxCategory);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	try {
			list = repository.getTaxCategoryNamesList();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	boolean expected = list.contains("TEST");
    	
    	assertEquals(expected, true);
    }
    
    
    @Test
    @DisplayName("Should Not Delete a Tax Category If The Given Name Doesnt Exist")
    public void shouldThrowIllegalArgumentExceptionGivenInvalidTaxCategoryNameToDelete()
    {
    	TaxCategoryRepository repository = new TaxCategoryRepository();
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
             repository.removeTaxCategory("no");
         });
    }
    
    @Test
    @DisplayName("Should Delete A TaxCategory Given Its Name.")
    public void shouldDeleteATaxCategory()
    {
    	TaxCategoryRepository repository = new TaxCategoryRepository();
    	TaxCategory taxCategory = new TaxCategory("TEST2", 1.0);
    	List<String> list = new ArrayList<String>();
    	try {  
    		repository.addTaxCategory(taxCategory);
			list = repository.getTaxCategoryNamesList();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	boolean expected = list.contains("TEST2");    	
    	assertEquals(expected, true);
    	
    	try {
    		repository.removeTaxCategory("TEST2");
    		list.clear();
			list = repository.getTaxCategoryNamesList();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	boolean expectedAfterDeletion = list.contains("TEST2");    	
    	assertEquals(expectedAfterDeletion, false);    	
    }
    
    @Test
    @DisplayName("Should Not Update a Tax Category If The Given Name Doesnt Exist")
    public void shouldThrowIllegalArgumentExceptionGivenInvalidTaxCategoryNameToUpdate()
    {
    	TaxCategoryRepository repository = new TaxCategoryRepository();
    	TaxCategory taxCategory = new TaxCategory("no", 0);
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
             repository.editTaxCategory(taxCategory);
         });
    }
    
    @Test
    @DisplayName("Should Update A TaxCategory Given Its Name.")
    public void shouldUpdateATaxCategory()
    {
    	TaxCategoryRepository repository = new TaxCategoryRepository();
    	TaxCategory taxCategory = new TaxCategory("TEST3", 1.0);
    	List<String> list = new ArrayList<String>();
    	try {  
    		repository.addTaxCategory(taxCategory);
			list = repository.getTaxCategoryNamesList();
			double expectedValue1 = repository.getTaxValue("TEST3"); 
			assertEquals(expectedValue1, 1.0);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	try {
    		TaxCategory taxCategoryUpdated = new TaxCategory("TEST3", 2.0);
    		repository.editTaxCategory(taxCategoryUpdated);
    		list.clear();
			list = repository.getTaxCategoryNamesList();
			double expectedValue1 = repository.getTaxValue("TEST3"); 
			assertNotEquals(expectedValue1, 1.0);
			assertEquals(expectedValue1, 2.0);
		} catch (IOException e) {
			e.printStackTrace();
		}
  	
    }
    
    @AfterAll
    @DisplayName("To Delete The Values in File Which were Added During Testing.")
    public static void deleteEntries() {   	
    	try {
        	TaxCategoryRepository repository = new TaxCategoryRepository();
    		repository.removeTaxCategory("TEST");
    		repository.removeTaxCategory("TEST3");
		} catch (IOException e) {
			e.printStackTrace();
		}    	
    }
	

}
