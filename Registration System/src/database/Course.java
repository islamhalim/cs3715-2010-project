package database;

import java.util.ArrayList;

public class Course {
	private int number;
	private int cap = 50; //default course cap of 50 students
	private String instructor = "N/A";
	private String description = "N/A";
	ArrayList<AccountLogin> students;
	
	
	public Course(int courseNum, int courseCap, String courseInstr, String courseInfo){
		
		this.number = courseNum;
		this.cap = courseCap;
		this.instructor = courseInstr;
		this.description = courseInfo;
		this.students = new ArrayList<AccountLogin>();
		
	}
	public Course( int courseNum){
		this.number = courseNum;
		this.students = new ArrayList<AccountLogin>();
	}
	

}
