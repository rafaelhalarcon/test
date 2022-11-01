package test;

public class Student {
	
	private String name;
	private double marks;
	private Student nextStudent;
	
	public Student(String string, double i) {
		name = string;
		marks = i;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double i) {
		marks = i;
	}
	/**
	 * @return the nextStudent
	 */
	public Student getNextStudent() {
		return nextStudent;
	}
	/**
	 * @param nextStudent the nextStudent to set
	 */
	public void setNextStudent(Student nextStudent) {
		this.nextStudent = nextStudent;
	}
	public String getName() {
		return name;
	}

}
