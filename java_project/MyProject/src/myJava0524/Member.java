package myJava0524;

class Calculator{
	int add ( int a, int b) {
		return a + b;
	}
	int subtract( int a, int b) {
		return a - b;
	}
	int multiply( int a, int b) {
		return a * b; 
	}
	double devide( int a, int b) {
		return a / b;
	}
}
public class Member {
	public static void main(String[] args) {
		System.out.println("Sera Wi");
		Calculator calc = new Calculator();
	}

}
