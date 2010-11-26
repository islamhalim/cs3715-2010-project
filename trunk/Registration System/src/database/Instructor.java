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
	public boolean deleteInstructor(){
		
		Database dBase = Database.getInstance();
		return dBase.removeInstructor(this);
		
	}
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
