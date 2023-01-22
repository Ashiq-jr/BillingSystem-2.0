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
	
	
	@Override
	public String toString()
	{
		return this.name + " " + this.value;
	}
	

}
