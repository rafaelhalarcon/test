package test;

public class DemoLinkedStructure {

	public static void main(String[] args) {
		Student st1 = new Student("MJ", 90);
		Student st2 = new Student("RJ", 85);
		Student st3 = new Student("CJ", 85);
		Student st4 = new Student("DJ", 85);
		
		st1.setNextStudent(st2);
		st2.setNextStudent(st3);
		st3.setNextStudent(st4);
		
		//temporary variables, we need to keep track of the first node
		Student first = st1;
		Student temp = first;
		
		while (temp != null) {
			System.out.println(temp.getName());
			temp = temp.getNextStudent();
			
		}
		
		
		st1.setNextStudent(st2);//Assign a reference to the next student
		System.out.println(st1.getMarks());
		st2 = st1;
		System.out.println(st2.getMarks()); //output will be 90
		st2.setMarks(100);
		System.out.println(st1.getMarks()); // output will be 100
		
		//returns the next connected student calling the getter to find marks
		System.out.println(st1.getNextStudent().getMarks());
	}

}
