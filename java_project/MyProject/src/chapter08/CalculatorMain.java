package chapter08;

public class CalculatorMain {

	public static void main(String[] args) {
		
		Calculator calc =  new Calculator_Impl();
		
		System.out.println(calc.add(2480,896));
		System.out.println(calc.substract(2480,896));
		System.out.println(calc.multiply(2480325,896));
		System.out.println(calc.divide(2480,896));
		
	}

}
