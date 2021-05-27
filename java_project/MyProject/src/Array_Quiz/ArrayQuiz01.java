package Array_Quiz;

import java.util.Scanner;

public class ArrayQuiz01 {
	
	public static int maxValue(int[] arr) {
		int max = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public static int minValue(int[] arr) {
		int min = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] numbers = new int[5]; 
		for( int i= 0; i< numbers.length ; i++) { // 사용자에게 숫자 5개 받기
			System.out.print("숫자를 입력하세요 >");
			numbers[i]= Integer.parseInt(scanner.nextLine());
		}
		
		System.out.println("최대값: " +maxValue(numbers));
		System.out.println("최소값: " +minValue(numbers));
	}
}
