package chapter13;

import java.util.Scanner;

public class Game {
	// 1~100 사이의 랜덤 한 숫자 추출
	// 사용자에게 숫자 입력받고, 랜덤 숫자와 비교, 높은 숫자인지 낮은 숫자인지 출력
	// 10초 카운팅은 스레드를 이용해서 처리
	// 10초 이전에 맞추면 미션 성공, 10초가 지나면 프로그램 종료하는 흐름

	public static boolean check = false;  

	public static void main(String[] args) {

		UserInputThread uit = new UserInputThread();
		CountDownThread ct = new CountDownThread();

		uit.start();
		ct.start();
	}
}

class UserInputThread extends Thread{ // 사용자 입력받기 -> 랜덤 숫자와 비교하기

	@Override
	public void run() {

		int randomNum = (int)(Math.random()*100)+1; 

		Scanner scanner = new Scanner(System.in);
		System.out.println("하이로우게임을 시작합니다.");
		System.out.println("1~100사이의 숫자를 하나 입력해주세요 > ");
		int userNum = Integer.parseInt(scanner.nextLine());
		Game.check = true;
		
		if(userNum> randomNum) {
			System.out.println("미션 실패: 입력한 숫자 > 추출 숫자");
		}else if(randomNum > userNum) {
			System.out.println("미션 실패: 입력한 숫자 < 추출 숫자");
		}else {
			System.out.println("정답입니다. 미션 성공!!");
		}
	
	}
}

class CountDownThread extends Thread{ // 카운트 다운하기

	@Override
	public void run() {
		try {
			sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		for( int i = 10; i>0 ; i--) {

			if(Game.check) {
				return;
			}

			System.out.println(i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("입력시간이 지나 게임을 종료합니다.");
		System.exit(0);
	}
}









