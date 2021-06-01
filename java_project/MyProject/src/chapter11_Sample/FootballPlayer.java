package chapter11_Sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FootballPlayer {
	private String name;
	private int number;
	private String team;
	private int age;
	
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

	
	//getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public static void main(String[] args) {
		List<FootballPlayer> players = new ArrayList<>();
		
		//데이터 저장
		players.add(new FootballPlayer("Son1",7,"Tot", 27));
		players.add(new FootballPlayer("Park1",7,"Man", 37));
		players.add(new FootballPlayer("Son1",9,"Tot", 27)); 
		players.add(new FootballPlayer("Son2",20,"Tot", 17)); 
		players.add(new FootballPlayer("Park2",20,"Man", 31));
		players.add(new FootballPlayer("Park2",21,"Man", 30));
		
		//정렬
		Iterator<FootballPlayer> itr = players.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}













