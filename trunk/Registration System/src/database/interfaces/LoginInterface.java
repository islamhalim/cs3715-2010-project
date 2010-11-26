package database.interfaces;

import database.Instructor;
import database.Student;

public interface LoginInterface {
	
	public Student studentLogin(String sUserName, String sPassword);
	
	public Instructor instructorLogin(String iUserName, String iPassword);

}
