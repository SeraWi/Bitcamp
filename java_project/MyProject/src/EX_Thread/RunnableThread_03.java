package EX_Thread;

public class RunnableThread_03 {
	public static void main(String[] args) {


		// Runnable 타입의 인스턴스 생성
		AdderThread at1 = new AdderThread(1,50);
		AdderThread at2 = new AdderThread(51,100);

		// Thread 인스턴스 생성
		// new Thread(Runnable target)

		Thread t1 = new Thread(at1);
		Thread t2 = new Thread(at2);

		// Thread start() 실행시작
		t1.start();
		t2.start();

		try { //여기 없을 때: 1~100까지의 숫자 합: 0
			t1.join(); //main 쓰레드 멈춘다.
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1~100까지의 숫자 합: "+(at1.getNum()+at2.getNum()));
	}
}

class AdderThread extends Sum implements Runnable{

	int startNum;
	int endNum;

	AdderThread(int n1, int n2){
		this.startNum = n1;
		this.endNum = n2;
	}

	@Override
	public void run() { //Runnable인터페이스 구현, 작업해야 하는거!
		for(int i = startNum; i <= endNum; i++) {
			addNum(i);
		}
	}
}

class Sum {
	int num;

	public void addNum(int n) {
		num+= n;
	}

	public int getNum() {
		return num;
	}
}


