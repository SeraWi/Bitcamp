package chapter09;

class Person{
	String name;
	String personNumber;
	Person(String name, String personNumber){
		this.name = name;
		this.personNumber = personNumber;
	}
	
	public boolean equals(Person p) {
		if(this.personNumber == p.personNumber) {
			return true;
		}
		return false;
	}
}

public class PersonNumberTest {
	public static void main(String[] args) {
		Person p1 = new Person("Sam","0000-0000");
		Person p2 = new Person("Sam","0000-0000");
		
		System.out.println(p1.equals(p2));
				
	}
}
