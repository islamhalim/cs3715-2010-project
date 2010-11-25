package database;

public class AccountLogin {
	private String userName;
	private String password;
	
	public AccountLogin(String sUserName, String sPassword){
		
		this.userName = sUserName;
		this.password = sPassword;
	}
	
	public String getUserName(){
		return userName;
	}
	public String getPassword(){
		return password;
	}
	public void changePassword(String newPassword){
		this. password = newPassword;
	}

}
