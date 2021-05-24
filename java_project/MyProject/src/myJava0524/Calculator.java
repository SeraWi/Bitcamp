package myJava0524;

import java.util.Scanner;

public class Calculator {
	// 메소드 -> 기능(재료 -> 처리 -> 반환)
	// 반환타입 메소드 이름(매개변수들){처리 구문}
	void add ( int a, int b) {
		System.out.println(a + b);
	}
	void subtract( int a, int b) {
		System.out.println(a - b);
	}
	void multiply( int a, int b) {
		System.out.println(a * b);
	}
	void devide( int a, int b) {
		System.out.println(a / b);
	}
	double circle( int r) {
		return 2 * r * Math.PI;
	}
	double circleArea( int r) {
		return  Math.PI * r * r;
	}

	public static void main(String[] args) {
		// 인스턴스 생성-> 클래스의 정의가 필요하다. 
		// 클래스 이름 참조변수 = new 클래스 이름
		Scanner scanner = new Scanner(System.in);
		
		Calculator calc = new Calculator();
		calc.add(1, 2); //3
		calc.subtract(5, 3); //2
		calc.multiply(4, 5); //20
		calc.devide(10, 3); //3
		
		System.out.print("반지름을 입력하세요 > ");
		int r = scanner.nextInt();
		System.out.println("원의 둘레는 : "+calc.circle(r));
		System.out.println("원의 넓이는 : "+calc.circleArea(r));
		
		
		
	}
}
