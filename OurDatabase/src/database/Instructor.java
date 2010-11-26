package database;

import java.util.ArrayList;

import database.interfaces.InstructorInterface;

public class Instructor extends Account implements InstructorInterface {
	
	private ArrayList<Integer> courses;
	
	public Instructor(String iUserName, String iPassword, String iName, 
			String iEmail, String iAddress, String iPhoneNum)
	{
		super( iUserName, iPassword, iName, 
				 iEmail,  iAddress, iPhoneNum, false);
		
		courses = new ArrayList<Integer>();
	}
	
	/**
	 * get a ArrayList of the COurses taught by the Instructor
	 */
	public ArrayList<Course> getCourseList()
	{
		Database dBase = Database.getInstance();
		ArrayList<Course> clist = dBase.getCourses();
		ArrayList<Course> currCourses = new ArrayList<Course>();
		for(Integer i: this.courses){
			for(Course c: clist)
			{
				if(c.getCourseNum() == i.intValue())
				{
					currCourses.add(c);
					break;
				}
			}
		}
		return currCourses;
	}

	/**
	 * Creates an Account of type Instructor
	 * 
	 * @param iUserName
	 * @param iPassword
	 * @param iName
	 * @param iEmail
	 * @param iAddress
	 * @param iPhoneNum
	 * @return - true if account creation was successfull
	 */
	public boolean createInstructor(String iUserName, String iPassword, String iName, String iEmail, String iAddress,
										String iPhoneNum){
		Database dBase = Database.getInstance();
		ArrayList<Instructor> instructors = dBase.getInstructors();
		for(Instructor i: instructors)
		{
			if(i.getUserName() == iUserName)
				return false;
		}
		
		return dBase.addInstructor(new Instructor(iUserName, iPassword, iName, iEmail, iAddress, iPhoneNum));
	}
	/**
	 * deletes an Instructor from the Database
	 * 
	 * @return true if the Instructor was successfully removed from the Database
	 */
	public boolean deleteInstructor(){
		
		Database dBase = Database.getInstance();
		return dBase.removeInstructor(this);
		
	}
	/**
	 * Add a new course to the list of courses taught. Should only be called by the Admin.
	 * @param course - of type int, is the courseNum to be added to the list of course taught by
	 * 					an instructor.
	 * @return - true if course was added.
	 */
	public boolean addCourse(int course)
	{
		for(Integer i : courses)
		{
			if( course == i.intValue())
			{
				return false;
			}
		}
		courses.add(new Integer(course));
		return true;
	}
	
	/**
	 * removes course from Instructors list of courses. Should only be called by the Admin
	 * 
	 * @param course
	 * @return
	 */
	public boolean removeCourse(int course){
		
		for(Integer i : courses)
		{
			if( course == i.intValue())
			{
				
				return courses.remove(i);
			}
		}
		return false;
	}
	
}
