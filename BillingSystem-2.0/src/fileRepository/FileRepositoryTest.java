package fileRepository;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

public class FileRepositoryTest {
	
	
    @Test
    @DisplayName("Should not Load File to Read When the Path is Invalid")
    public void shouldThrowFileNotFoundExceptionGivenInvalidFilePathToRead()
    {   
    	FileRepository repository = new FileRepository();
        String path = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\store1.txt";
        Assertions.assertThrows(FileNotFoundException.class, () -> {
        	repository.loadFileData(path);
        });
    }
    
    @Test
    @DisplayName("Should not Load File to Write When the Path is Invalid")
    public void shouldThrowFileNotFoundExceptionGivenInvalidFilePathToWrite()
    {
    	FileRepository repository = new FileRepository();
        String path = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\store1.txt";
        String text = "";
        Assertions.assertThrows(FileNotFoundException.class, () -> {
            repository.writeNewInfoOnFile(path, text);
        });
    }
    
    @Test
    @DisplayName("Should not Load File to OverWrite When the Path is Invalid")
    public void shouldThrowFileNotFoundExceptionGivenInvalidFilePathToOverWrite()
    {
    	FileRepository repository = new FileRepository();
        String path = "C:\\Users\\ashiq\\git\\BillingSystem-2.0\\BillingSystem-2.0\\src\\resources\\store1.txt";
        String text = "";
        Assertions.assertThrows(FileNotFoundException.class, () -> {
            repository.overWriteDataInFile(path, text);
        });
    }
}
