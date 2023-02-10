package product;

import java.io.IOException;
import java.util.*;

import fileRepository.FileRepository;

public class TaxCategory {

	String name;
	double value;
	
 	
	//Constructors
	public TaxCategory() {

	}
	
	public TaxCategory(String name, double value) {
		this.name = name;
		this.value = value;
	}
	
	//Getters	
	public String getName() {
		return name;
	}

	public double getValue() {
		return value;
	}
	
	//Validation
	public void validateName()
	{
		if(this.getName().isBlank() || this.getName().length() < 2 || this.getName().length() > 15)
		{
			throw new IllegalArgumentException("Invalid Tax Name.");
		}
		else if( this.getName().startsWith("0") || this.getName().startsWith("1") || this.getName().startsWith("2") || this.getName().startsWith("3")|| this.getName().startsWith("4") || 
				this.getName().startsWith("5") || this.getName().startsWith("6") ||this.getName().startsWith("7")|| this.getName().startsWith("8") || this.getName().startsWith("9") )
		        {
		            throw new IllegalArgumentException("Invalid Tax Name. ");
		        }	
	}
	
	public void validateTaxValue() {
		
		String valueString = String.valueOf(this.getValue());
		
		if(valueString.isBlank())
		{
			throw new IllegalArgumentException("Invalid Tax Value.");
		}		
	}
	
	
	@Override
	public String toString()
	{
		return this.name + " " + this.value;
	}
	

}
