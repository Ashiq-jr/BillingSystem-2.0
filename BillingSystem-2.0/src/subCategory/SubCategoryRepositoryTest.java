package subCategory;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import category.Category;

class SubCategoryRepositoryTest {

    @Test
    @DisplayName("Should Return a List Of SubCategory Objects")
    public void shouldFetchSubCategoriesFromFile()
    { 
    	List<SubCategory> list = new ArrayList<SubCategory>();
    	assertEquals(0, list.size());
    	SubCategoryRepository repository = new SubCategoryRepository();
    	try {
			list = repository.loadSubCategory();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	assertNotEquals(0, list.size());
    	
    }
    
    @Test
    @DisplayName("Should Not Write Illegal SubCategory Values in File")
    public void shouldThrowIllegalArgumentExceptionGivenObjectWithIllegalFields()
    {
    	SubCategoryRepository repository = new SubCategoryRepository();
    	Category category = new Category("1");
    	SubCategory subCategory = new SubCategory(category, "test");
    	 Assertions.assertThrows(IllegalArgumentException.class, () -> {
             repository.addSubCategory(subCategory);
         });
    }
    
    @Test
    @DisplayName("Should Add a SubCategory")
    public void shouldAddASubCategoryInFile()
    {
    	List<SubCategory> list = new ArrayList<SubCategory>();
    	assertEquals(0, list.size());
    	SubCategoryRepository repository = new SubCategoryRepository();
    	try {
			list = repository.loadSubCategory();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	int sizeBeforeAdding = list.size();

    	Category category = new Category("test1");
    	SubCategory subCategory = new SubCategory(category, "test");
        try {
			repository.addSubCategory(subCategory);
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
   	 	try {
   		list.clear();
			list = repository.loadSubCategory();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
    	int sizeAfterAdding = list.size();
    	assertNotEquals(sizeBeforeAdding, sizeAfterAdding);
    }
    
    @Test
    @DisplayName("Should Not Write a Duplicate SubCategory in File")
    public void shouldThrowIllegalArgumentExceptionGivenDuplicateName()
    {

    	SubCategoryRepository repository = new SubCategoryRepository();
    	Category category1 = new Category("test2");
    	SubCategory subCategory1 = new SubCategory(category1, "test2");
        try {
			repository.addSubCategory(subCategory1);
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
        Category category2 = new Category("test1");
    	SubCategory subCategory2 = new SubCategory(category2, "test2");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            repository.addSubCategory(subCategory2);
        });

    }
    
    @Test
    @DisplayName("Should Remove a SubCategory")
    public void shouldRemoveASubCategoryInFile()
    {
    	List<SubCategory> list = new ArrayList<SubCategory>();
    	assertEquals(0, list.size());
    	SubCategoryRepository repository = new SubCategoryRepository();
    	try {
			list = repository.loadSubCategory();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	Category category = new Category("test1");
    	SubCategory subCategory = new SubCategory(category, "test3");
        try {
			repository.addSubCategory(subCategory);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	 
    	 try {
    		list.clear();
			list = repository.loadSubCategory();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
    	int sizeBeforeRemoving = list.size();
    	
    	try {
			repository.removeSubCategory("test3");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
   	 	try {
   		list.clear();
			list = repository.loadSubCategory();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

    	int sizeAfterRemoving = list.size();
    	assertNotEquals(sizeBeforeRemoving, sizeAfterRemoving);
    }
    
    @AfterAll
    @DisplayName("Remove Changes Made During Testing In File.")
    public static void removeCreatedEntries()
    {
    	SubCategoryRepository repository = new SubCategoryRepository();
    	try {
			repository.removeSubCategory("test2");
			repository.removeSubCategory("test");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    


}