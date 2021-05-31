package chapter08;

public abstract class AbstractCalculator implements Calculator{
	public long add(long n1, long n2) {
		return n1 + n2;
	}
	public long substract(long n1, long n2) {
		return n1 + n2 ;
	}
	public abstract long multiply(long n1, long n2);
	public abstract double divide(double n1, double n2);
}
