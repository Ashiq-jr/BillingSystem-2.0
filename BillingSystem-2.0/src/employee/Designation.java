package employee;

import product.Status;

public enum Designation {
	
	ADMIN,
	MANAGER,
	OPERATOR;
	
	//Validation
	public boolean designationExists(String name) {
		
		Designation[] desigs = Designation.values();
		for(Designation x : desigs)
		{
			if(x.name().equals(name))
			{
				return true;
			}
		}
		return false;		
	}
	
	public void validateDesignation(String name) {
		
		if(!designationExists(name))
		{
			throw new IllegalArgumentException("Invalid Designation");
		}
	}	

}
