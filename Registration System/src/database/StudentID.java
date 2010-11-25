package database;

public class StudentID {
	
	private int studentID;
	
	public StudentID( String id){
		this.studentID = Integer.parseInt(id);
	}
	
	public int getStudentID(){
		return studentID;
	}

}
