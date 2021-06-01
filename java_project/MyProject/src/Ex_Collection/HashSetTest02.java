package Ex_Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest02 {
	public static void main(String[] args) {
		
		Set<SimpleNumber> hashSet = new HashSet<>();
		// 상위 인터페이스 타입     
		
		//데이터 저장
		hashSet.add(new SimpleNumber(10));
		hashSet.add(new SimpleNumber(20));
		hashSet.add(new SimpleNumber(20));
		
		// 데이터의 일괄 처리
		Iterator<SimpleNumber> itr = hashSet.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		} 
	}
}

class SimpleNumber{
	
	int num;
	SimpleNumber(int num){
		this.num = num;
	}
	
	public String toString() {
		return String.valueOf(num);
	}
	
	@Override
	public int hashCode() {
		return num % 3; // 0,1,2-> 세개의 그룹으로 나눠짐
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		/// obj는 null이 아니고, obj 는 SimpleNumber타입으로 형번환이 가능
		if(obj != null && obj instanceof SimpleNumber) {
			SimpleNumber sNum =(SimpleNumber)obj;
			if(this.num == sNum.num) {
				result = true;
			}
		}
		return result;
	} 
}











