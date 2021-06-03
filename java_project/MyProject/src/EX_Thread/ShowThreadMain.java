package EX_Thread;

public class ShowThreadMain {

	public static void main(String[] args) {
		// 스레드 인스턴스 생성
		
		ShowThread t1 = new ShowThread("스레드 1");
		ShowThread t2 = new ShowThread("      스레드 2");
		
		//쓰레드 실행
		
		t1.start(); // run() 메소드 실행된다.
		t2.start();

	}

}
