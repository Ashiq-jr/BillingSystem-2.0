package product;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.TreeMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import category.Category;
import subCategory.SubCategory;

class ProductRepositoryTest {

	@Test
    @DisplayName("Should Return a TreeMap Of Product Objects")
    public void shouldFetchSubCategoriesFromFile()
    { 
    	TreeMap<Integer, Product> tMap = new TreeMap<Integer,Product>();
    	assertEquals(0, tMap.size());
    	ProductRepository repository = new ProductRepository();
    	try {
    		tMap = repository.loadProductsIntoTreeMap();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	assertNotEquals(0, tMap.size());
    	
    }
	   
    @Test
    @DisplayName("Should Return a Product Object")
    public void shouldReturnAProductGivenItsName()
    {
    	ProductRepository repository = new ProductRepository();
    	String actualName = "RAJMA-500G";
    	int actualId = 0;
    	try {
    		actualId = repository.getIdUsingName(actualName);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	Product product = null;
    	try {
			product = repository.getProductUsingName(actualName);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	String expectedName = product.getName();
    	int expectedid = product.getId();
    	assertEquals(expectedName, actualName);
    	assertEquals(expectedid, actualId);
    	  	
    }
    
    @Test
    @DisplayName("Should Not Return a Product Object if Name is InValid")
    public void shouldThrowIllegalArgumentExceptionGivenUnavailableProduct()
    {
    	ProductRepository repository = new ProductRepository();
    	String actualName = "RAJMA-500";
    	
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		Product product = repository.getProductUsingName(actualName);
    	});
    }

    
    @Test
    @DisplayName("Should Return a New Product Id")
    public void shouldReturnANewProductId()
    {
    	ProductRepository repository = new ProductRepository();
    	int expectedId = 0;
    	TreeMap<Integer, Product> tMap = new TreeMap<Integer, Product>();
    	try {
			tMap = repository.loadProductsIntoTreeMap();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	for(Integer x : tMap.keySet())
    	{
    		expectedId = x;
    	}
    	expectedId++;
    	int actualId = 0;
    	try {
    		actualId = repository.generateProductId();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	assertEquals(expectedId, actualId);
    }
    
    @Test
    @DisplayName("Should Return a Product Id")
    public void shouldReturnAProductIdGivenItsName()
    {
    	ProductRepository repository = new ProductRepository();
    	int actualId = 101;
    	int expectedId = 0;
    	try {
    		expectedId = repository.getIdUsingName("BASMATIRICE-1KG");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	assertEquals(expectedId, actualId);
	
    }
    
    @Test
    @DisplayName("Should Not Return a Product Id if Name is InValid")
    public void shouldThrowIllegalArgumentExceptionGivenInvalidProductName()
    {
    	ProductRepository repository = new ProductRepository();
    	String actualName = "RAJMA-500";
    	
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		int id = repository.getIdUsingName(actualName);
    	});
    }
    
    @Test
    @DisplayName("Should Not Write Illegal Product Values in File")
    public void shouldThrowIllegalArgumentExceptionGivenObjectWithIllegalFields()
    {
    	Category category = new Category("test");
    	SubCategory subCategory = new SubCategory(category, "testsub");
    	TaxCategory taxCategory = new TaxCategory("Test", 2.0);
    	Double unitPrice = 19.0;
    	Product product = new Product(91, "1TestApple", category, subCategory, unitPrice, taxCategory, Status.ACTIVE);
    	ProductRepository repository = new ProductRepository();
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
             repository.addNewProduct(product);
         });
    }
    
    @Test
    @DisplayName("Should Add A New Product")
    public void shouldAddANewProductinFile()
    {
    	Category category = new Category("test");
    	SubCategory subCategory = new SubCategory(category, "testsub");
    	TaxCategory taxCategory = new TaxCategory("Test", 2.0);
    	Double unitPrice = 19.0;
    	ProductRepository repository = new ProductRepository();
    	int id = 0;
    	try {
			id = repository.generateProductId();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	Product product = new Product(id, "TestApple", category, subCategory, unitPrice, taxCategory, Status.ACTIVE);
    	Product expectedProduct = null;
       	TreeMap<Integer, Product> tMap = new TreeMap<Integer,Product>();
    	try {
    		tMap = repository.loadProductsIntoTreeMap();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	int sizeBeforeAdding = tMap.size();    	
    	try {
    		repository.addNewProduct(product);
    		expectedProduct = repository.getProductUsingName("TestApple");
    		tMap = repository.loadProductsIntoTreeMap();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	int sizeAfterAdding = tMap.size(); 
    	String expectedName = expectedProduct.getName();
    	
    	assertEquals(expectedName,"TestApple" );
    	assertEquals(sizeAfterAdding, sizeBeforeAdding + 1 );
    	
    }
    
    @Test
    @DisplayName("Should Not Add Product That Already Exists")
    public void shouldThrowIllegalArgumentExceptionIfWeTryToAddProductThatAlreadyExists() {

    	Category category = new Category("test");
    	SubCategory subCategory = new SubCategory(category, "testsub");
    	TaxCategory taxCategory = new TaxCategory("Test", 2.0);
    	Double unitPrice = 19.0;
    	ProductRepository repository = new ProductRepository();
    	int id = 0;
    	try {
			id = repository.generateProductId();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	Product product = new Product(id, "TestApple", category, subCategory, unitPrice, taxCategory, Status.ACTIVE);
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
            repository.addNewProduct(product);
        });
    	
    }
    
    @Test 
    @DisplayName("Should Upadate A Product Data in File")
    public void shouldChangeExistingProductData() {
    	
    	Category category = new Category("test");
    	SubCategory subCategory = new SubCategory(category, "testsub");
    	ProductRepository repository = new ProductRepository();
    	int id= 0;
    	try {
    		id = repository.getIdUsingName("TestApple");
    		//repository.addNewProduct(product);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	double updatedUnitPrice = 20.0;
    	TaxCategory updatedTaxCategory = new TaxCategory("Test2", 0.0);
    	Product product2 = new Product(id, "TestApple", category, subCategory, updatedUnitPrice, updatedTaxCategory, Status.DISCONTINUED);
    	try {
    		repository.editProduct(product2);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	Product updatedProduct = null;
    	
    	try {
			updatedProduct = repository.getProductUsingName("TestApple");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	assertEquals(updatedProduct.getUnitPrice(), updatedUnitPrice);
    	assertEquals(updatedProduct.getTaxCategory().getName(), "Test2");
    	assertEquals(updatedProduct.getTaxCategory().getValue(), 0.0);
    	assertEquals(updatedProduct.getStatus(), Status.DISCONTINUED);
    	 
    }

}
