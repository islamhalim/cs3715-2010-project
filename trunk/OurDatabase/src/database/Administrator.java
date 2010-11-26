package database;

import java.util.ArrayList;


public class Administrator  extends Account{
	
	/**
	 * Constructor
	 * 
	 * @param sUserName - User name for Admin as type String.
	 * @param sPassword - password for Admin as type String.
	 * @param iName	- name of User for Admin as type String.
	 * @param iEmail - the email addres of the Admin.
	 */
	public Administrator(String sUserName, String sPassword, String iName, 
			String iEmail){
		super(sUserName, sPassword, iName, iEmail, true);
	}
	
	/**
	 * Create an Admin
	 * 
	 * param sUserName - User name for Admin as type String.
	 * @param sPassword - password for Admin as type String.
	 * @param iName	- name of User for Admin as type String.
	 * @param iEmail - the email addres of the Admin.
	 * @return returns true if account creation was successful;
	 */
	public boolean createAdmin( String aUserName, String aPassword, String aName, String aEmail )
	{
		Database dBase = Database.getInstance();
		ArrayList<Administrator> admins = dBase.getAdmins();
		for(Administrator a: admins)
		{
			if(a.getUserName() == aUserName) return false;
		}
		return dBase.addAdministrator(new Administrator(aUserName, aPassword, aName, aEmail)); 
		
	}

}
