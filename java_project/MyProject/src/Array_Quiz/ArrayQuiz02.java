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
		
		for(int a: arr) {
			
		}
		
		addOneDArr(arr, 10);

		for(int a : arr) { //2차원 enhanced for사용하기
			for(int)
				System.out.println();
		}

	}
}


