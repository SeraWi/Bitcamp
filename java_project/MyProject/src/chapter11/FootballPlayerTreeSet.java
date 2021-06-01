package chapter11;

import java.util.*;

public class FootballPlayerTreeSet {
	public static void main(String[] args) {
		TreeSet<FootballPlayer> player = new TreeSet<>();
		
		player.add(new FootballPlayer("A", 1, "AAA" ,27));
		player.add(new FootballPlayer("B", 22, "AAA" ,20));
		player.add(new FootballPlayer("B", 17, "AAA" ,20));
		
		player.add(new FootballPlayer("Michle", 7, "BBB" ,25));
		player.add(new FootballPlayer("Michle", 9, "BBB" ,25));
		player.add(new FootballPlayer("Mike", 16, "BBB" ,25));
		
		player.add(new FootballPlayer("Jay", 8, "CCC" ,22));
		player.add(new FootballPlayer("Jay", 1, "CCC" ,22)); 
		player.add(new FootballPlayer("Hi", 15, "CCC" ,22)); 
		
		Iterator<FootballPlayer> itr = player.iterator();
		
		while(itr.hasNext()) {
			itr.next().showData();
			System.out.println("=================");
		}
	}
}
