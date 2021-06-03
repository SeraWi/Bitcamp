package EX_Thread;

import javax.swing.JOptionPane;

public class ThreadEx1 {
	public static boolean chk = false;

	public static void main(String[] args) {

		InputThread it = new InputThread();
		CountDownThread ct = new CountDownThread();

		it.start();
		ct.start();
	}
}

class InputThread extends Thread{
	public void run() {
		String name = JOptionPane.showInputDialog("이름을 입력해주세요");
		ThreadEx1.chk = true; //입력했다면 true로 바꾼다.-> 카운트 다운 더이상 하지 않는다.
		System.out.println("안녕하세요. "+name+ "님");
	}
}



class CountDownThread extends Thread{

	@Override
	public void run() {
		for( int i= 10; i > 0; i--) {

			if(ThreadEx1.chk) {
				return; //run() 종료
			}

			System.out.println(i);
			try {
				sleep(1000);//1초
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 

		}
		System.out.println("입력시간이 지나 프로그램을 종료합니다.");
		System.exit(0);
	}
}