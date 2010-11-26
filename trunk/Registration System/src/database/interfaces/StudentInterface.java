package database.interfaces;

import java.util.ArrayList;

import database.Course;

public interface StudentInterface {
	
	public boolean createStudent(String sUserName, String sPassword, String sName, String sEmail,
			String sAddress, String sPhoneNum);
	
	public boolean deleteStudent();
	
	public ArrayList<Course> getAllCourse();
	
	public boolean addCourse( Course course);
	
	public boolean dropCourse( Course course);
	
	public ArrayList<Course> getCourseList();

}
