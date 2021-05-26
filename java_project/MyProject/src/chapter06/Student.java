package chapter06;

public class Student {

	private String name;
	private int korScore;
	private int engScore;
	private int mathScore;

	public void setName(String name) {
		this.name= name;
	}
	public String getName() {
		return this.name;
	}
	public void setkorScore(int korScore) {
		this.korScore = korScore;
	}
	public int getKorScore() {
		return this.korScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	public int getEngScore() {
		return this.engScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	public int getMathScore() {
		return this.mathScore;
	}

	Student(String name, int korScore, int engScore, int mathScore){
		this.name = name;
		this.korScore =korScore;
		this.engScore= engScore;
		this.mathScore = mathScore;
	}

	double totalScore() {
		return korScore + engScore +mathScore;
	}
	double avgScore() {
		return (korScore + engScore +mathScore)/3;
	}

	public static void main(String[] args) {
		Student[] students = new Student[10];
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

		for( int i = 0; i< students.length ; i++) {
			System.out.println("학생 이름: "+ students[i].getName());
			System.out.println("총점: "+ students[i].totalScore());
			System.out.println("평균: "+ students[i].avgScore());
			System.out.println("===========================");
		}
	}
}
