package chapter09;

public class SumCount {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int sum = 0;
		for(int i= 0; i<=100000000; i++) {
			sum += i;
		}
		System.out.println(sum);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
