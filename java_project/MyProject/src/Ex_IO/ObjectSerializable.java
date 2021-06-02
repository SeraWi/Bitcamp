package Ex_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSerializable {

	public static void main(String[] args) {
		
		// 인스턴스를 저장
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.ser"));
			
			out.writeObject(new Circle(1,1,2.4));
			out.writeObject(new Circle(3,5,7.4));
			out.writeObject("Hello");
			out.close();
			
			System.out.println("인스턴스 저장 완료");
			
			//인스턴스 복원
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));
			
			//복원 순서는 저장순서에 맞게 복원해야 한다.
			Circle c1 = (Circle) in.readObject();
			Circle c2 = (Circle) in.readObject();
			String str = (String) in.readObject();
			
			System.out.println("복원된 인스턴스의 데이터를 출력");
			c1.showData();
			c2.showData();
			System.out.println(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) { //circle이 같은 클래스여야 한다. 이름만 같은게 아니도록
			e.printStackTrace();
		}
	}
}

class Circle implements Serializable{
	
	//implements Serializable:직렬화 대상임을 의미, 마킹
	int x;
	int y;
	double r;
	
	
	public Circle(int x, int y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public void showData() {
		System.out.println("원점 ["+x+","+y+"]");
		System.out.println("반지름 : "+ r);
	}
	
}