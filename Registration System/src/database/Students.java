package database;

public class Students {
	
	private StudentID student;
	private String name;
	private String email;
	private String phoneNumber = "N/A";
	private String address = "N/A";
	
	
	
	public Students( String sName, String sEmail, String sAddress, String sPhoneNum, StudentID sID){
		
		this.name = sName;
		this.email = sEmail;
		this.phoneNumber = sPhoneNum;
		this.address = sAddress;
		this.student = sID;
	}
	public Students(String sName, String sEmail, StudentID sID){
		this.name = sName;
		this.email = sEmail;
		this.student = sID;
		
	}
	
	public StudentID getID(){
		return this.student;
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
