package Array_Quiz;

public class ArrayQuiz03 {
	
	static int[][] moveArray(int[][] arr){
		int[] tmp= arr[arr.length-1];
		for(int i = arr.length-1 ; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = tmp;
		return arr;
	}
	
	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		moveArray(arr);// 행 이동
		for( int[] tmp: arr) {
			for( int i: tmp) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
