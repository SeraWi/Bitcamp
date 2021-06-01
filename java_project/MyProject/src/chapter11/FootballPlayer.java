package chapter11;


public class FootballPlayer implements Comparable<FootballPlayer>{

	String name;
	int number;
	String team;
	int age;

	FootballPlayer(String name, int number, String team, int age){
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}
	public void showData() {
		System.out.println("선수 이름: "+ name);
		System.out.println("번호 : "+ number);
		System.out.println("소속팀: "+ team);
		System.out.println("나이: "+ age);
	}
	@Override
	public int hashCode() {
		return number;
	}

	@Override
	public boolean equals(Object obj) {
		// 이름, 팀소속, 나이 같으면 같은 사람
		boolean result = false;

		if(obj != null && obj instanceof FootballPlayer) {
			FootballPlayer p =(FootballPlayer)obj;
			if(this.name == p.name && this.team == p.team
					&& this. age == p.age) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(FootballPlayer f) {
		// 팀이름순으로 정렬하기, 
		// 같은 팀의 선수들은 이름순으로 정렬, 
		// 같은 이름의 선수는 번호순으로 저장

		int result = this.team.compareTo(f.team); // 팀이름 비교
		int nameresult = this.name.compareTo(f.name); // 선수 이름 비교


		if(result == 0) {//팀이름이 같다. 
			if(nameresult == 0) {//선수 이름이 같다
				if(this.number > f.number) {
					return 1;
				}else  {
					return -1;
				}
			}else if(result > 0) {
				return 1;
			}else {
				return -1;
			}
		}else if(result > 0) {
			return 1;
		}else {
			return -1;
		}

	}
}










