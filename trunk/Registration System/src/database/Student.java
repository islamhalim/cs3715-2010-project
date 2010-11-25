package database;

public class Student extends AccountLogin {
	
	private String name;
	private String email;
	private String phoneNumber = "N/A";
	private String address = "N/A";
	
	
	public Student(String sUserName, String sPassword , String sName, 
						String sEmail, String sAddress, String sPhoneNum){
		
		super(sUserName, sPassword);
		this.name = sName;
		this.email = sEmail;
		this.phoneNumber = sPhoneNum;
		this.address = sAddress;

	}
	public Student(String sUserName, String sPassword, String sName, String sEmail){
		super(sUserName, sPassword);
		this.name = sName;
		this.email = sEmail;

		
	}
	
	public String getName(){
		return this.name;
	}
	public String getEmail(){
		return this.email;
	}
	public String getAddress(){
		return this.address;
	}
	public String getPhone(){
		return this.phoneNumber;
	}
	public void setAddress( String sAddress){
		this.address = sAddress;
	}
	public void setEmail( String sEmail){
		this.email = sEmail;
	}
	public void setPhoneNumber( String sPhoneNum){
		this.phoneNumber = sPhoneNum;
	}
}
