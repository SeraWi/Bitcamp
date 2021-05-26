package chapter06_try;

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
		return (double)korScore + engScore +mathScore;
	}
	double avgScore() {
		return (double)(korScore + engScore +mathScore)/3;
	}
	
	void studentInfo() {
		System.out.println("학생 이름: "+ name);
		System.out.println("총점: "+ totalScore());
		System.out.println("평균: "+ avgScore());
		System.out.println("===========================");
	}

}
