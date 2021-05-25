package chapter03;

import java.util.Scanner;

public class Calculator {
	int add( int a, int b) {
		return a + b;
	}
	int subtract(int a, int b) {
		return a - b;
	}
	int multiply( int a, int b) {
		return a * b ;
	}
	double devide( int a, int b) {
		return a / b;
	}
	
	void calcResult( int a, int b) {
		System.out.println("더하기 연산 결과는 :" + add(a,b));
		System.out.println("빼기 연산 결과는 :" + subtract(a,b));
		System.out.println("곱하기 연산 결과는: "+ multiply(a,b));
		System.out.println("나누기 연산 결과는: "+devide(a,b));
	}
	
	double circle( double r) {
		return 2 * Math.PI * r;
	}
	double circleArea(double r) {
		return Math.PI * r * r;
	}
	
	void circleResult(double r) {
		System.out.println("원의 둘레는 :"+ circle(r));
		System.out.println("원의 넓이는 :"+ circleArea(r));
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫번째 숫자를 입력해주세요 >");
		int num1 = scanner.nextInt();
		System.out.print("두번째 숫자를 입력해주세요 >");
		int num2 = scanner.nextInt();
		
		Calculator calc = new Calculator();
		calc.calcResult(num1, num2);
		System.out.println();
		
		System.out.print("원의 반지름 길이를 입력하세요 >");
		double r = scanner.nextDouble();
		calc.circleResult(r);
	}

}
