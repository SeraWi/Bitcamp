package chapter11;

import java.util.*;

public class FootballPlayerList {
	public static void main(String[] args) {
		List<FootballPlayer> player = new ArrayList<>();
		
		player.add(new FootballPlayer("Lea", 1, "AAA" ,27));
		player.add(new FootballPlayer("Mike", 7, "BBB" ,25));
		player.add(new FootballPlayer("Jay", 8, "CCC" ,22));
		player.add(new FootballPlayer("Tim", 22, "AAA" ,20));
		
		
		Iterator <FootballPlayer>  itr = player.iterator();
		while(itr.hasNext()) {
			itr.next().showData();
			System.out.println("================");
		}
	}
}
