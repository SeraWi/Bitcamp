package Ex_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ObjectSerializable {

	public static void main(String[] args) {
		
		// 인스턴스를 저장
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.ser"));
			
			out.writeObject(new Circle(1,1,2.4));
			out.writeObject(new Circle(3,5,7.4));
			out.writeObject("Hello");
			
			ArrayList<Circle> list = new ArrayList<>();
			list.add(new Circle(1,1,2.4));
			list.add(new Circle(5,6,7.4));
			list.add(new Circle(10,9,8.4));
			list.add(new Circle(11,12,12.4));
			list.add(new Circle(21,21,22.4));
			out.writeObject(list);
			
			out.close();
			
			System.out.println("인스턴스 저장 완료");
			
			//인스턴스 복원
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));
			
			//복원 순서는 저장순서에 맞게 복원해야 한다.
			Circle c1 = (Circle) in.readObject();
			Circle c2 = (Circle) in.readObject();
			String str = (String) in.readObject();
			
			ArrayList<Circle> list2 = (ArrayList<Circle>) in.readObject();
			for(Circle circle : list2) {
				System.out.println(circle);//toString 반환
			}
			
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
	transient double r; // transient: 저장 대상이 되지 않는다 ->0으로 들어감
	
	
	public Circle(int x, int y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public void showData() {
		System.out.println("원점 ["+x+","+y+"]");
		System.out.println("반지름 : "+ r);
	}

	@Override
	public String toString() {
		return "Circle [x=" + x + ", y=" + y + ", r=" + r + "]";
	}
	
}