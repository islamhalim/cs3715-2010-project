package database;

import java.util.ArrayList;

public class Course {
	private int number;
	private int cap = 50;//default course cap of 50 students
	private String name;
	private String instructor;
	private String description = "N/A";
	ArrayList<String> students;
	
	
	public Course(int courseNum, String courseName, int courseCap, String courseInstr, String courseInfo){
		
		this.number = courseNum;
		this.name = courseName;
		this.cap = courseCap;
		this.instructor = courseInstr;
		this.description = courseInfo;
		this.students = new ArrayList<String>();
		
	}
	
	public Course( int courseNum, String courseName, String courseInstr){
		
		this.number = courseNum;
		this.name = courseName; 
		this.instructor = courseInstr;
		this.students = new ArrayList<String>();
		
	}
	
	/**
	 * Removes a student from the Class list
	 * @param student - the student to be removed
	 * @return true if removal was successful.
	 */
	public boolean courseDelete(Student student){
		
		if(students.size() > 0){
			synchronized(this.students)
			{
				return this.students.remove(student);
			}
		}
			return false;
	}
	/**
	 * trys to register the given student into a Course 
	 * @param student - the student to be registered
	 * @return true if course registration was successfull
	 */
	public boolean courseReg(Student student){
		if(this.students.size() < cap)
		{
			synchronized(this.students)
			{
			return this.students.add(student.getUserName());
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @return the ArrayList of Student object that are in the Course.
	 */
	public ArrayList<Student> getClassList()
	{
		Database dBase = Database.getInstance();
		ArrayList<Student> slist = dBase.getStudents();
		ArrayList<Student> regStudents = new ArrayList<Student>();
		for(String str: this.students){
			for(Student s: slist)
			{
				if(str == s.getUserName())
				{
					regStudents.add(s);
					break;
				}
			}
		}
		return regStudents;
	}
	
	/**
	 * gets attributes of the Course object
	 */
	public String getCourseName(){
		return this.name;
	}
	
	public String getCourseDescription(){
		return this.description;
	}
	
	public int getCap(){
		return this.cap;
	}
	/**
	 * Sets the MAx Class size of the Course
	 * 
	 * @param newCap - New max Class size of type int
	 * @return true if Cap was set;
	 */
	public boolean setCap( int newCap)
	{
		if(newCap > this.students.size())
		{
			this.cap = newCap;
			return true;
		}
		else
			return false;
	}
	/**
	 * 
	 * @return the int Corresponding to the Course number of this Course.
	 */
	public int getCourseNum()
	{
		return this.number;
	}
	
	/**
	 * 
	 * @return number of students in the class of type int.
	 */
	public int getClassSize(){
		return this.students.size();
	}
	public void setInstructor( String instruct){
		this.instructor = instruct;
	}
	public void setCourseDescription( String descript)
	{
		synchronized(this)
		{
			this.description = descript;
		}
	}
	/**
	 * Creates a new Course. Should only be called by the admin
	 * @param courseNum
	 * @param courseName
	 * @param courseCap
	 * @param courseInstr
	 * @param courseInfo
	 * @return true if Course creation was successful.
	 */
	public boolean createCourse(int courseNum, String courseName, int courseCap, String courseInstr, String courseInfo)
	{
		Database dBase = Database.getInstance();
		ArrayList<Course> courses = dBase.getCourses();
		
		for(Course c: courses)
		{
			if(c.getCourseNum() == courseNum) return false;
		}
		return dBase.addCourse(new Course(courseNum, courseName, courseCap, courseInstr, courseInfo));
		
	}

}
