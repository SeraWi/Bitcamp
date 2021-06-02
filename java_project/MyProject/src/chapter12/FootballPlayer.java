package chapter12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;


public class FootballPlayer implements Serializable{
	
	String name;
	int number;
	String team;
	int age;
	
	//생성자
	public FootballPlayer(String name, int number, String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	@Override
	public String toString() {
		return "FootballPlayer [name=" + name + ", number=" + number + ", team=" + team + ", age=" + age + "]";
	}

	
	public static void main(String[] args) {
		
		try {
			//인스턴스 저장
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("FootballInfo.ser"));
			
			List<FootballPlayer> players = new ArrayList<>();
			players.add(new FootballPlayer("Son1",7,"Tot", 27));
			players.add(new FootballPlayer("Son2",20,"Tot", 17)); 
			players.add(new FootballPlayer("Park1",7,"Man", 37));
			players.add(new FootballPlayer("Park2",20,"Man", 31));
			players.add(new FootballPlayer("Kim1",21,"Man", 31));
			
			out.writeObject(players);
			out.close();
			System.out.println("인스턴스 저장 완료");
			
			// 인스턴스 복원
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("FootballInfo.ser"));
			
			System.out.println("복원된 데이터를 출력합니다.");
			ArrayList<FootballPlayer> list = (ArrayList<FootballPlayer>) in.readObject();
			for(FootballPlayer p : list) {
				System.out.println(p);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
