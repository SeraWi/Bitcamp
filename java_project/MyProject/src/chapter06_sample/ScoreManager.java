package chapter06_sample;

public class ScoreManager {

	public static void main(String[] args) {
		// 1. 국어, 영어, 수학 점수 10개씩을 저장하는 배열을 정의하고 점수를 모두 출력하고, 평균 점수를 출력하는 프로그램을 작성해봅시다. 
		
		//점수를 저장하는 배열
		int[] korScore = new int[10];
		int[] engScore = new int[10];
		int[] mathScore = new int[10];
		// 점수를 입력
		korScore[0] = 100;
		korScore[1] = 65;
		korScore[2] = 74;
		korScore[3] = 83;
		korScore[4] = 99;
		korScore[5] = 22;
		korScore[6] = 52;
		korScore[7] = 39;
		korScore[8] = 48;
		korScore[9] = 77;
		// 점수를 모두 출력
		// 배열의 모든 요소를 출력
		// 배열 -> 일괄처리
		//반복문을 이용해서 공통된 작업을 처리
		for(int idx = 0; idx < korScore.length ; idx++ ) {
			System.out.println(korScore[idx]);
		}
		//합을 구하고 -> 평균을 구한다. 
		//sum = sum + i -> sum += i;
		//합을 구하기 위한 변수 sum 선언
		int sum = 0;
		for(int i = 0; i<korScore.length; i++) {
			sum = sum+ korScore[i];
		}
		System.out.println("국어점수의 합: "+ sum);
		
		//평균 -> 총합/배열의 개수;
		float  avg = (float) sum / korScore.length;
		System.out.println("국어점수의 평균: "+avg);
		
	}
}
