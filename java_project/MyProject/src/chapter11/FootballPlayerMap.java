package chapter11;

import java.util.*;

public class FootballPlayerMap {
	public static void main(String[] args) {
		Map<Integer,FootballPlayer> player = new HashMap<>();
		
		
		player.put(1,new FootballPlayer("Lea", 1, "AAA" ,27));
		player.put(7,new FootballPlayer("Tim", 7, "BBB" ,20));
		player.put(3,new FootballPlayer("Smith", 15, "CCC" ,18));
		
		player.get(1).showData();
		System.out.println("===============");
		player.get(7).showData();
		System.out.println("===============");
		player.get(3).showData();
		System.out.println("===============");
	}
}
