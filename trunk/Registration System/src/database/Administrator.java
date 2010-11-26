package database;

import java.util.ArrayList;

public class Administrator  extends Account{
	
	public Administrator(String sUserName, String sPassword, String iName, 
			String iEmail){
		super(sUserName, sPassword, iName, iEmail, true);
	}
	
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
