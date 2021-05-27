package Array_Quiz;

import java.util.Scanner;

public class ArrayQuiz01 {
	
	public static int maxValue(int[] arr) {
		// 최대값 반환 메서드
		for(int i = 0; i< arr.length ; i++) {
			for( int j = 0; j< arr.length -1 -i ; j++) {
				if( arr[j] > arr[j+1]) {
					//옆의 값이 크면 서로 바꾼다. 
					int temp =arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr[arr.length-1];
	}
	
	public static int minValue(int[] arr) {
		//최소값 반환 메서드
		for(int i = 0; i< arr.length ; i++) {
			for( int j = 0; j< arr.length -1 -i ; j++) {
				if( arr[j] > arr[j+1]) {
					int temp =arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr[0];
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] numbers = new int[5]; // 5개 숫자 저장 배열 
		
		for( int i= 0; i< numbers.length ; i++) { // 사용자에게 숫자 5개 받기
			System.out.print("숫자를 입력하세요 >");
			numbers[i]= Integer.parseInt(scanner.nextLine());
		}
		System.out.println("최대값은: " +maxValue(numbers));
		System.out.println("최소값은: " +minValue(numbers));
	}
}
