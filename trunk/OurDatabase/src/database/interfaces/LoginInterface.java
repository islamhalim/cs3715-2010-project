package database.interfaces;

import database.Instructor;
import database.Student;
/**
 * This Interface is implemented by the Database class. It is used to gain access to the database via
 * a Student Account or a Instructor Account.
 * 
 * @author matthew
 *
 */
public interface LoginInterface {
	
	/**
	 *  Login to a student account
	 *  
	 * @param sUserName - Username for a Student Account as type string
	 * @param sPassword - Password for a Student Account as type String
	 * @return - a Student Object
	 */
	public Student studentLogin(String sUserName, String sPassword);
	
	/**
	 * Login to a Instructor Account
	 * 
	 * @param iUserName -  Username for a Instructor Account as type string
	 * @param iPassword - Password for a Student Account as type String
	 * @return - An Instructor Object
	 */
	public Instructor instructorLogin(String iUserName, String iPassword);

}
