package database.interfaces;

import java.util.ArrayList;

import database.Course;

public interface StudentInterface {
	
	/**
	 * Creates a Student Account from the information.
	 * All below are of type String.
	 * @param sUserName - User name for the Account
	 * @param sPassword - Password for the account.
	 * @param sName	-	the Real name of the User.
	 * @param sEmail-	the email address of the User .
	 * @param sAddress	-	Address of the User.
	 * @param sPhoneNum - Phone number of the user.
	 * @return - true if the Account creation was successful.
	 */
	public boolean createStudent(String sUserName, String sPassword, String sName, String sEmail,
			String sAddress, String sPhoneNum);
	
	/**
	 * 
	 * @return true if student was deleted from database
	 */
	public boolean deleteStudent();
	
	/**
	 * 
	 * @return an ArrayLIst of All courses not Already Registered by the User
	 */
	public ArrayList<Course> getAllCourse();
	
	/**
	 * Adds a course to a Student account.
	 * @param course -  Course to be added.
	 * @return true if course was successful added.
	 */
	public boolean addCourse( Course course);
	
	/**
	 * Unregister for a course
	 * @param course
	 * @return true if course was successfully droped
	 */
	public boolean dropCourse( Course course);
	
	public ArrayList<Course> getCourseList();

}
