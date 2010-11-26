package database;

import java.util.ArrayList;

import database.interfaces.StudentInterface;

public class Student extends Account implements StudentInterface {
	
	ArrayList<Integer> currCourses;
	/**
	 * Constructor 
	 * 
	 * @param sUserName - User name for Student as type String.
	 * @param sPassword - password for Student as type String.
	 * @param iName	- name of User for Student as type String.
	 * @param iEmail - the email address of the Student.
	 * @param sAddress - address for 
	 * @param sPhoneNum
	 */
	public Student(String sUserName, String sPassword , String sName, 
						String sEmail, String sAddress, String sPhoneNum){
		
		super(sUserName, sPassword, sName, sEmail, sAddress, sPhoneNum, false);
		this.currCourses = new ArrayList<Integer>();
		
	}
	//Use to create a student
	public boolean createStudent(String sUserName, String sPassword, String sName, String sEmail,
			String sAddress, String sPhoneNum){
		
		Database dBase = Database.getInstance();
		
		ArrayList<Student> students = dBase.getStudents();
		
		for(Student s: students)
		{
			if(s.getUserName() == sUserName) return false;
		}
		 return dBase.addStudent(new Student(sUserName, sPassword, sName, sEmail, sAddress, sPhoneNum));
	}
	
	//deletes a student Account from the database, called by he User.
	public boolean deleteStudent(){
		
		Database dBase = Database.getInstance();
		return dBase.removeStudent(this);
		
	}
	
	/**
	 * gets an ArrayList of all the Courses not registered by the user
	 * 
	 */
	public ArrayList<Course> getAllCourse()
	{
		Database dBase = Database.getInstance();
		ArrayList<Course>courses = dBase.getCourses();
		ArrayList<Course> clist = new ArrayList<Course>();
		
		for(Course c: courses){
			boolean add = true;
			for(Course sCourse : this.getCourseList())
			{
				if( sCourse.getCourseNum() == c.getCourseNum())
				{
					add = false;
					break;
				}
			}
			if(add) clist.add(c);
		}
		return clist;
	}
	/**
	 * Registers the student for a Course. Adds Course Number to the Students list of 
	 * Registered Courses. Returns true if course was added.
	 * 
	 */
	public boolean addCourse( Course course){
		if(course.courseReg(this))
		{
			this.currCourses.add(course.getCourseNum());
			return true;
		}
		else
			return false;
	}
	/**
	 * Find the course in the Students list of Register courses and remove course from list.
	 */
	public boolean dropCourse( Course course){
		for(Integer c: currCourses)
		{
			if(course.getCourseNum() == c.intValue())
			{
				if(course.courseDelete(this)){
					currCourses.remove(c);
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * get an Arrraylist of courses current taken by the User
	 */
	public ArrayList<Course> getCourseList()
	{
		Database dBase = Database.getInstance();
		ArrayList<Course> clist = dBase.getCourses();
		ArrayList<Course> regCourses = new ArrayList<Course>();
		for(Integer i: this.currCourses){
			for(Course c: clist)
			{
				if(c.getCourseNum() == i.intValue())
				{
					regCourses.add(c);
					break;
				}
			}
		}
		return regCourses;
	}
	
}
