package Ex_Collection;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(1);
		treeSet.add(5);
		treeSet.add(4);
		treeSet.add(2);
		treeSet.add(3);
		treeSet.add(1);
		
		//정렬
		Iterator<Integer> itr = treeSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}// 1 2 3 4 5로 정렬되어있음(오름차순으로)
	}
}
