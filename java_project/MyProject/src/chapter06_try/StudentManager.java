package chapter06_try;

public class StudentManager {

	Student [] students;
	public StudentManager(){
		students = new Student[10];
		students[0]= new Student("Julie",20,30,40);
		students[1] = new Student("Sam",35,65,45);
		students[2] = new Student("Smith",80,55,85);
		students[3] = new Student("Son",100,95,72);
		students[4] = new Student("Kim",45,60,45);
		students[5] = new Student("Jay",35,65,45);
		students[6] = new Student("James",35,75,45);
		students[7] = new Student("Sarah",90,65,95);
		students[8] = new Student("Anna",47,82,100);
		students[9] = new Student("Lea",34,79,65);
	}
	void studentInfo() {
		for( Student s : students) {
			s.studentInfo();
		}
	}
}