package database;

import java.util.ArrayList;

public class Database {
	ArrayList<Course> courses;
	ArrayList<Student> students;
	
	public Database(){
		this.courses = new ArrayList<Course>();
		this.students = new ArrayList<Student>();
		//create courses and students from XML file;
	}
	
	public boolean createStudent(String sUserName, String sPassword, String sName, String sEmail, String sAddress, String sPhoneNum){
		for(Student s: students){
			if(s.getUserName() == sUserName) return false;
		}
		synchronized(this.students){
			students.add(new Student(sUserName, sPassword, sEmail, sAddress, sPhoneNum, sPassword ));
		}
		return true;
	}
	
	public boolean createStudent(String sUserName, String sPassword, String sName, String sEmail){
		for(Student s: students){
			if(s.getUserName() == sUserName) return false;
		}
		synchronized(this.students){
			students.add(new Student( sUserName, sPassword, sName, sEmail));
		}
		return true;
	}


}
