package chapter11;

import java.util.*;

public class FootballPlayerSet {
	public static void main(String[] args) {
		// number다르면 다른 사람이다!
		Set<FootballPlayer> player = new HashSet<>();
		
		player.add(new FootballPlayer("Lea", 1, "AAA" ,27));
		player.add(new FootballPlayer("Lea", 4, "AAA" ,27));
		player.add(new FootballPlayer("Lea", 1, "AAA" ,27));
		
		Iterator <FootballPlayer>  itr = player.iterator();
		while(itr.hasNext()) {
			itr.next().showData();
			System.out.println("================");
		}		
	}
}
