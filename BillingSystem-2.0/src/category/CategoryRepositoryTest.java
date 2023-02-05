package category;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CategoryRepositoryTest {

	@Test
    @DisplayName("Should Return a List Of SubCategory Objects")
    public void shouldFetchSubCategoriesFromFile()
    { 
    	List<Category> list = new ArrayList<Category>();
    	assertEquals(0, list.size());
    	CategoryRepository repository = new CategoryRepository();
    	try {
			list = repository.loadCategory();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	assertNotEquals(0, list.size());
    	
    }
    
    @Test
    @DisplayName("Should Not Write Illegal Category Values in File")
    public void shouldThrowIllegalArgumentExceptionGivenObjectWithIllegalFields()
    {
    	CategoryRepository repository = new CategoryRepository();
    	 Assertions.assertThrows(IllegalArgumentException.class, () -> {
             repository.addCategory("1");
         });
    }
    
    @Test
    @DisplayName("Should Add a Category")
    public void shouldAddACategoryInFile()
    {
    	List<Category> list = new ArrayList<Category>();
    	assertEquals(0, list.size());
    	CategoryRepository repository = new CategoryRepository();
    	try {
			list = repository.loadCategory();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	int sizeBeforeAdding = list.size();

        try {
			repository.addCategory("test1");
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
   	 	try {
   	 		list.clear();
			list = repository.loadCategory();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	int sizeAfterAdding = list.size();
    	assertNotEquals(sizeBeforeAdding, sizeAfterAdding);
    }
    
    @Test
    @DisplayName("Should Not Write a Duplicate Category in File")
    public void shouldThrowIllegalArgumentExceptionGivenDuplicateName()
    {
    	CategoryRepository repository = new CategoryRepository();
        try {
			repository.addCategory("test2");
		} catch (IOException e1) {
			e1.printStackTrace();
		} 

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            repository.addCategory("test2");
        });

    }
    
    @Test
    @DisplayName("Should Remove a Category")
    public void shouldRemoveACategoryInFile()
    {
    	List<Category> list = new ArrayList<Category>();
    	assertEquals(0, list.size());
    	CategoryRepository repository = new CategoryRepository();
        try {
			repository.addCategory("test19");
		} catch (IOException e1) {
			e1.printStackTrace();
		}	 
    	 try {
    		list.clear();
			list = repository.loadCategory();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	int sizeBeforeRemoving = list.size();
    	
    	try {
			repository.removeCategory("test19");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
   	 	try {
   	 		list.clear();
			list = repository.loadCategory();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	int sizeAfterRemoving = list.size();
    	assertNotEquals(sizeBeforeRemoving, sizeAfterRemoving);
    }
    
    @AfterAll
    @DisplayName("Remove Changes Made During Testing In File.")
    public static void removeCreatedEntries()
    {
    	CategoryRepository repository = new CategoryRepository();
    	try {
			repository.removeCategory("test2");
			repository.removeCategory("test1");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
