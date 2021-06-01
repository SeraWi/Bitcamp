package Ex_Collection;

import java.util.*;

public class ComparablePerson {

	public static void main(String[] args) {
		TreeSet <Person> set = new TreeSet<>();
		
		//데이터 저장
		set.add(new Person("Lee", 24));
		set.add(new Person("Hong", 29));
		set.add(new Person("Park", 21));
		
		//정렬
		Iterator<Person> itr = set.iterator();
		while(itr.hasNext()) {
			itr.next().showData();
		}
	}

}
class Person implements Comparable<Person>{
	String name;
	int age;
	
	//생성자
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public void showData() {
		System.out.printf("%s, %d \n", this.name, this.age);
	}

	@Override
	public int compareTo(Person o) {
//		if(this. age > o.age) {
//			return 10000; //양수
//		}else if(this.age < o.age) {
//			return -1; //음수
//		}else {
//			return 0;
//		}
		//return this.age - o.age; //오름차순으로 정렬된다
		return o.age - this.age; //내림차순으로 정렬된다
	}
	
}


