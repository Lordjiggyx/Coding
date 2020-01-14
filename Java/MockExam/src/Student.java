

public class Student {
	
	private String name;
	private String studentNumber;
	private int age;
	
	public Student(String name, String studentNumber, int age) {
		this.name = name;
		this.studentNumber = studentNumber;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



}