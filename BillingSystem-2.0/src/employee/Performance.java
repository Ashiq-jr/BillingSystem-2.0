package employee;


public enum Performance {
	
	EXCELLENT,
	AVERAGE,
	POOR;
	
	
	//Validate
	public boolean performanceExists(String name) {
		
		Performance[] performances = Performance.values();
		for(Performance x : performances)
		{
			if(x.name().equals(name))
			{
				return true;
			}
		}
		return false;		
	}
	
	public void validatePerformance(String name) {
		
		if(!performanceExists(name))
		{
			throw new IllegalArgumentException("Invalid Perfromance");
		}
	}	

}
