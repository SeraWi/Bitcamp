package chapter08;

public class CalculatorImpl implements Calculator {
	
	long n1;
	long n2;
	CalculatorImpl(){}
	CalculatorImpl(long n1, long n2){
		this.n1 = n1;
		this.n2 = n2;
	}
	@Override
	public long add(long n1, long n2) {
		return n1 + n2;
	}

	@Override
	public long substract(long n1, long n2) {
		return n1 - n2;
	}

	@Override
	public long multiply(long n1, long n2) {
		return n1 * n2;
	}

	@Override
	public double divide(double n1, double n2) {
		return n1 / n2;
	}

}
