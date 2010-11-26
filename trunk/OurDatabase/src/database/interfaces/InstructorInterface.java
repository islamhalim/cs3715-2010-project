package database.interfaces;

import java.util.ArrayList;

import database.Course;

public interface InstructorInterface {
	
	/**
	 * 
	 * @return An ArrayList of the Courses taught by the instructor
	 */
	public ArrayList<Course> getCourseList();

}
