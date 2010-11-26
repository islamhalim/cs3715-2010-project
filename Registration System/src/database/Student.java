package database;

import java.util.ArrayList;

import database.interfaces.StudentInterface;

public class Student extends Account implements StudentInterface {
	
	ArrayList<Integer> currCourses;
	
	public Student(String sUserName, String sPassword , String sName, 
						String sEmail, String sAddress, String sPhoneNum){
		
		super(sUserName, sPassword, sName, sEmail, sAddress, sPhoneNum, false);
		this.currCourses = new ArrayList<Integer>();
		
	}
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
	public boolean deleteStudent(){
		
		Database dBase = Database.getInstance();
		return dBase.removeStudent(this);
		
	}
	
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
	
	public boolean addCourse( Course course){
		if(course.courseReg(this))
		{
			this.currCourses.add(course.getCourseNum());
			return true;
		}
		else
			return false;
	}
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
