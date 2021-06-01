package chapter11_Sample;

import java.util.*;

public class FootballPlayer implements Comparable<FootballPlayer>{
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

	@Override
	public boolean equals(Object obj) {
		//팀과 이름 나이가 같으면 같은 선수라 판단
		boolean chk = false;
		if( obj != null && obj instanceof FootballPlayer) {
			FootballPlayer player = (FootballPlayer)obj; //형변환
			if(this.team.equals(player.team)&& 
					this.name.equals(player.name)&&
					this.age == player.age) {
				chk = true;
			}
		}
		return chk;
	}

	@Override
	public int hashCode() {
		return age % 10;
	}


	@Override
	public int compareTo(FootballPlayer o) {
		int result = this.team.compareTo(o.getTeam()); //result 결과: 양수, 음수 , 0
		if(result == 0) {
			result = this.name.compareTo(o.getName());
			if(result == 0) {
				result = this.number - o.getNumber();
			}
		}
		return result;
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
		//List<FootballPlayer> players = new ArrayList<>();
		//Set<FootballPlayer> players = new HashSet<>();
		TreeSet<FootballPlayer> players = new TreeSet<>();

		//데이터 저장
		players.add(new FootballPlayer("Son1",7,"Tot", 27));
		players.add(new FootballPlayer("Park1",7,"Man", 37));
		players.add(new FootballPlayer("Son1",9,"Tot", 27)); 
		players.add(new FootballPlayer("Son2",20,"Tot", 17)); 
		players.add(new FootballPlayer("Park2",20,"Man", 31));
		players.add(new FootballPlayer("Park2",21,"Man", 31));
		System.out.println("요소의 개수: "+ players.size());

		//정렬
		Iterator<FootballPlayer> itr = players.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}













