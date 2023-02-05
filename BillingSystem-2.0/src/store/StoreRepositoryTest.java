package store;



import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class StoreRepositoryTest {

	
    @Test
    @DisplayName("Should Return a Store Object")
    public void shouldLoadStoreDetails()
    {   	
    	StoreRepository repository = new StoreRepository();
    	Store expected = null;
		try {
			expected = repository.loadStoreDetails();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals("RootSuperMarket", expected.getName());
		assertEquals("No:86", expected.getAddress().getDoorNo());
		assertEquals("Palakkarai", expected.getAddress().getArea());
		assertEquals("Trichy", expected.getAddress().getCity());
		assertEquals("Tamilnadu", expected.getAddress().getState());
		assertEquals(620007, expected.getAddress().getPincode());
		assertEquals("33EBLPM1907A1Z5", expected.getGstNumber());
		assertEquals(9899998789l, expected.getMobileNum());
		assertEquals("root.stores@gmail.com", expected.getMailId());				
    }
    
    @Test
    @DisplayName("Should Not Write Empty Values in File")
    public void shouldThrowIllegalArgumentExceptionGivenObjectWithEmptyFields()
    {
    	StoreRepository repository = new StoreRepository();
    	Address address = new Address("No:86", "Palakkarai", "Trichy", "Tamilnadu", 620007);
    	Store expected = new Store("name",address, "", 9899998789l, "root.stores@gmail.com");
    	 Assertions.assertThrows(IllegalArgumentException.class, () -> {
             repository.updateStoreDetails(expected);
         });
    }

}
