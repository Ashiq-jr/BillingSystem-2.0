package product;

public enum TaxCategory {
	
    NO(0),
    LOW(5),
    MID(12),
    HIGH(18),
    LUX(28);
	
	final double percentage;
	
	public double getPercentage()
	{
		return this.percentage;
	}
	
	
	
	TaxCategory(double percentage)
	{
		this.percentage = percentage;
	}
}
