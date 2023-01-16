package personalDetails;


public class PersonalDetails {
	
	protected int id;
	protected String name;
	protected long mobileNum;
	protected String mailId;
	
	
	public PersonalDetails() {
	
	}
	
	public PersonalDetails(int id, String name, long mobileNum, String mailId) {
		
		this.id = id;
		this.name = name;
		this.mobileNum = mobileNum;
		this.mailId = mailId;
	}
	
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getMobileNum() {
		return mobileNum;
	}

	public String getMailId() {
		return mailId;
	}

}
