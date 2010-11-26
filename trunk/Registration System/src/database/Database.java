package database;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import database.interfaces.LoginInterface;

public class Database implements LoginInterface{
	private ArrayList<Course> courses;
	private ArrayList<Student> students;
	private ArrayList<Instructor> instructors;
	private ArrayList<Administrator> admins;
	private boolean adminCreated = false;
	
	private static final Database INSTANCE = new Database();
	
	
	private Database(){
		this.courses = new ArrayList<Course>();
		this.students = new ArrayList<Student>();
		this.instructors = new ArrayList<Instructor>();
		while(!adminCreated);
			
		}
		//create courses and students from XML file;
	public static final Database getInstance(){
		return INSTANCE;
	}
	private Object readResolve() throws ObjectStreamException {
	    return INSTANCE;
	  }
	
//	public boolean createStudent(String sUserName, String sPassword, String sName, String sEmail,
//								String sAddress, String sPhoneNum){
//		for(Student s: students)
//		{
//			if(s.getUserName() == sUserName) return false;
//		}
//		synchronized(this.students)
//		{
//			students.add(new Student(sUserName, sPassword, sEmail, sAddress, sPhoneNum, sPassword ));
//		}
//		return true;
//	}
	
//	
//	public boolean createInstructor(String iUserName, String iPassword, String iName, String iEmail, String iAddress,
//										String iPhoneNum){
//		for(Instructor i: instructors)
//		{
//			if(i.getUserName() == iUserName) return false;
//		}
//		synchronized(this.instructors){
//			if(instructors.add(new Instructor(iUserName, iPassword, iName, iEmail, iAddress, iPhoneNum)))
//				return true;
//			else
//				return false;
//		}
//	}

	
//	private boolean createAdmin( String aUserName, String aPassword, String aName, String aEmail )
//	{
//		if(admins.add(new Administrator(aUserName, aPassword, aName, aEmail))) 
//			return true;
//		else
//			return false;
//	}
	
	public Student studentLogin(String sUserName, String sPassword){
		for(Student s: students)
		{
			if((sUserName == s.getUserName()) && s.login(sPassword))
			{
				return s;
			}
		}
		return null;
	}
	
	public Instructor instructorLogin(String iUserName, String iPassword){
		for(Instructor i: instructors)
		{
			if((iUserName == i.getUserName()) && i.login(iPassword))
			{
				return i;
			}
		}
		return null;
	}
	
	public Administrator adminLogin(String aUserName, String aPassword){
		for(Administrator a: admins)
		{
			if((aUserName == a.getUserName()) && a.login(aPassword))
			{
				return a;
			}
		}
		return null;
	}
	
	//get Courses and Users from database
	public ArrayList<Course> getCourses(){
		return courses;
	}
	public ArrayList<Student> getStudents(){
		return students;
	}
	public ArrayList<Instructor> getInstructors(){
		return instructors;
	}
	public ArrayList<Administrator> getAdmins(){
		return admins;
	}
	
	// add Courses, and Users to database
	public boolean addCourse( Course course)
	{
		for(Course c: courses)
		{
			if(c.getCourseNum() == course.getCourseNum())
			{
				return false;
			}
		}
		synchronized(this.courses)
		{
			return courses.add(course);
		}
	}
	public boolean addStudent( Student student)
	{
		for(Student s: students)
		{
			if(s.getUserName() == student.getUserName())
			{
				return false;
			}
		}
		synchronized(this.students)
		{	
			return students.add(student);
		}
	}
	
	public boolean addAdministrator( Administrator admin)
	{
		for(Administrator a: admins)
		{
			if(a.getUserName() == admin.getUserName())
			{
				return false;
			}
		}
		synchronized(this.admins)
		{	
			return admins.add(admin);
		}
	}
	public boolean addInstructor( Instructor instructor)
	{
		for(Instructor i: instructors)
		{
			if(i.getUserName() == instructor.getUserName())
			{
				return false;
			}
		}
		synchronized(this.instructors)
		{	
			return instructors.add(instructor);
		}
	}
	
	//Remove Courses or Users from database
	public boolean removeCourse( Course course)
	{
		for(Course c: courses)
		{
			if(c.getCourseNum() == course.getCourseNum())
			{
				synchronized(this.courses)
				{
					return courses.remove(course);
				}
			}
		}
		return false;
	}
	public boolean removeStudent( Student student)
	{
		for(Student s: students)
		{
			if(s.getUserName() == student.getUserName())
			{
				synchronized(this.students)
				{
					return students.remove(student);
				}
			}
		}
		return false;
	}
	
	public boolean removeAdministrator( Administrator admin)
	{
		for(Administrator a: admins)
		{
			if(a.getUserName() == admin.getUserName())
			{
				synchronized(this.admins)
				{
					return admins.remove(admin);
				}
			}
		}
		return false;
	}
	public boolean removeInstructor( Instructor instructor)
	{
		for(Instructor i: instructors)
		{
			if(i.getUserName() == instructor.getUserName())
			{
				synchronized(this.instructors)
				{
					return instructors.remove(instructor);
				}
			}
		}
		return false;
	}
	
//	public ArrayList<Course> getCourses(Instructor i )
//	{
//		return i.getCourseList(this.courses);
//	}
//	
//	public ArrayList<Course> getCourses(Student s){
//		
//		return s.getCourseList(this.courses);
//	}
	
//	public ArrayList<Course> getOtherCourse( Student s)
//	{
//		ArrayList<Course> clist = new ArrayList<Course>();
//		for(Course c: courses){
//			boolean add = true;
//			for(Course sCourse : this.getCourses(s))
//			{
//				if( sCourse.getCourseNum() == c.getCourseNum())
//				{
//					add = false;
//					break;
//				}
//			}
//			if(add) clist.add(c);
//		}
//		return clist;
//	}
//	public boolean createCourse(int courseNum, String courseName, int courseCap, String courseInstr, String courseInfo)
//	{
//		for(Course i : courses)
//		{
//			if(i.getCourseNum() == courseNum) return false;
//		}
//		if(courses.add(new Course(courseNum,courseName, courseCap, courseInstr, courseInfo)))
//			return true;
//		else
//			return false;
//	}
}
