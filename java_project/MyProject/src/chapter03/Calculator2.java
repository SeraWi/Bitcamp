package chapter03;

public class Calculator2 {

	// 클래스 이름 -> 대문자 시작, 케멀케이스
	// 변수 이름 -> 소문자 시작, 케멀케이스
	// 상수 -> 모두 대문자
	
	double pi1 = 3.14;
	float pi2 = 3.14f;
	final float PI = 3.14f; // 상수, final: 변경 불가, 대문자로 쓴다
	
	long plus(int num1, int num2) {
		return (long)num1 + num2;
	}
	long minus(int num1, int num2) {
		return (long)num1 - num2;
	}
	long multi(int num1, int num2) {
		return (long)num1 * num2;
	}
	float div(int num1, int num2) {
		return (float)num1 / num2; // (float)int / int -> float
	}
	
	float circum(float r) {
		return 2 * PI * r; //int * float * float = float
	}
	float cirArea(float r) {
		return PI * r * r;
	}
	
	public static void main(String[] args) {
		
		Calculator2  cal = new Calculator2();
		System.out.println(cal.PI);
		System.out.println("1 + 2 ="+cal.plus(1,2));
	}
}
