package database;

import org.jasypt.util.password.*;

/**
 * An Abstract class implemented by any class that wants to be an Account on this database.
 * @author matthew
 *
 */
public abstract class Account {
	
	private String userName;
	private String password;
	private boolean isAdmin = false;
	private BasicPasswordEncryptor passwordEncryptor;
	protected String name;
	protected String email;
	protected String phoneNumber;
	protected String address = "N/A";
	protected boolean loggedIn;
	
	
	
	/**
	 * Constructor - For creating Student Accounts
	 * 
	 * @param sUserName -of Type String the user name for the Account
	 * @param sPassword - Password for the Account
	 */
	public Account(String aUserName, String aPassword, String aName, String aEmail, boolean admin){
		
		this.passwordEncryptor = new BasicPasswordEncryptor();
		this.userName = aUserName;
		this.name = aName;
		this.email = aEmail;
		this.password = createEncryptedPassword(aPassword);
		
	}
	/**
	 * Constructor -  for system Administrators
	 * 
	 * @param sUserName - of Type String the user name for the Account
	 * @param sPassword - Password for the Account
	 * @param isAdmin - of type boolean. true is account is an administrator false otherwise.
	 * @param isInstruct - of type Boolean.true if account is an Instructor, false otherwise.
	 */
	public Account(String aUserName, String aPassword, String aName, 
			String aEmail, String aAddress, String aPhoneNum, boolean isAdmin){
		
		this.passwordEncryptor = new BasicPasswordEncryptor();
		this.userName = aUserName;
		this.password = createEncryptedPassword(aPassword);
		this.isAdmin = isAdmin;
		this.name = aName;
		this.email = aEmail;
		this.phoneNumber = aPhoneNum;
		this.address = aAddress;
		
	}
	
	/**
	 * 
	 * @return returns the user name for this Account as a String
	 */
	public String getUserName(){
		return this.userName;
	}
	
	public boolean checkIfAdmin(){
		return this.isAdmin;
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
	public void setAddress( String aAddress){
		this.address = aAddress;
	}
	public void setEmail( String aEmail){
		this.email = aEmail;
	}
	public void setPhoneNumber( String aPhoneNum){
		this.phoneNumber = aPhoneNum;
	}

	/**
	 * This function changes the password of the Account only if the current password is known to the user.
	 * 
	 * @param newPassword - The new Password to be used as type String;
	 * @param OldPassword - The Old Password the current password as type String
	 * @return - returns true if changePassword was successful.
	 */
	public boolean changePassword(String newPassword, String OldPassword)
	{
		if(this.checkPassword(OldPassword))
		{
			this.password = createEncryptedPassword(newPassword);
			return true;
		}
		else
			return false;
		
	}
	public String getPassword(){
		return this.password;
	}
	
	/**
	 * this function uses the jasypt-1.7 library to help encrypt the Password 
	 * 
	 * @param sPassword - The Password to be encrypted of type string.
	 * @return the encrypted password of type String.
	 */
	
	private String createEncryptedPassword(String sPassword){
		
		String encryptedPassword = passwordEncryptor.encryptPassword(sPassword);
		return encryptedPassword;
	}
	
	/**
	 * Checks If given Password Matches that of the Account.
	 * 
	 * @param aPassword - a non-encrypted Password that will be checked against the actual password of type String. 
	 * @return true if the password matches the actual password of the Account, false otherwise
	 */
	private boolean checkPassword( String aPassword){
		return passwordEncryptor.checkPassword(aPassword, this.password);
	}
	public boolean login( String aPassword){
		
		if(checkPassword(aPassword))
		{
			loggedIn = true;
			return true;
		}
		else
			return false;
	}
	public boolean logout(){
		loggedIn = false;
		return true;
	}
	
}
