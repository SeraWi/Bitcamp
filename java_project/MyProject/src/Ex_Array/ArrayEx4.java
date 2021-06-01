package Ex_Array;

public class ArrayEx4 {

	public static void main(String[] args) {
		//45개의 정수값을 저장하기 위한 배열 생성
		int[] ball = new int[45];
		//배열의 각 요소에 1 ~45의 값을 저장한다.
		for(int i=0; i<ball.length; i++) {
			ball[i] = i+1;
		}
		int temp =0; //두 값을 바꾸는데 사용할 임시변수
		int j = 0;
		for( int i = 0; i <100 ;i++) {
			j =(int) (Math.random()*45);// 베열 범위 (0~44)의 임의의 값을  얻는다. 
			temp = ball[0];
			ball[0] = ball[j]; // 배열 첫번째 요소와 임의 요소에 저장된 값을 서로 바꾸기
			ball[j] = temp;
		}
		for(int i = 0; i<6;i++) {// 앞에서 부터 6개의 요소 출력
			System.out.print(ball[i]+" ");
		}
	}
}
