package Ex_Collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
		// HashSet 저장 공간 생성: 
		// 인스턴스 저장, 중복 저장을 허용하지 않는다.
		// 저장순서를 저장하지 않는다.
		
		HashSet<String> hashSet = new HashSet<>();
		
		//데이터 저장
		hashSet.add("First");
		hashSet.add("Second");
		hashSet.add("Third");
		hashSet.add("First");
		
		// 데이터의 일괄 처리
		Iterator<String> itr = hashSet.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		HashSet<Integer> hashSet2 = new HashSet<>();
		
		hashSet2.add(1); //auto boxing
		hashSet2.add(2);
		hashSet2.add(1);
		hashSet2.add(2);
		hashSet2.add(3);
		Iterator<Integer> itr2 = hashSet2.iterator();
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}
	}
}
