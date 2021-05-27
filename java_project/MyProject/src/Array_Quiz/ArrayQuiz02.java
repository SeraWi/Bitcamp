package Array_Quiz;


public class ArrayQuiz02 {

	public static void addOneDArr(int[][] arr, int add) {
		for(int i=0; i < arr.length ; i++) {
			for(int j =0; j < arr[i].length; j++) {
				arr[i][j] += add;
			}
		}
	}

	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		arr= new int[][]{
			{1,2,3,4,5},
			{6,7,8,9,10},
			{11,12,13,14,15},
			{16,17,18,19,20},
			{21,22,23,24,25}
		};
		
		for( int[] tmp: arr) {
			for(int i: tmp) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
		System.out.println("==================");
		addOneDArr(arr, 10); // 10증가 시키기
		
		for( int[]tmp : arr) {
			for(int i : tmp) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}


