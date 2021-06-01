package chapter09;

class Person{
	String name;
	String personNumber;
	Person(String name, String personNumber){
		this.name = name;
		this.personNumber = personNumber;
	}
	
	public boolean equals(Object obj) {
		boolean result = false;
		if( obj != null && obj instanceof Person) {
			Person p = (Person) obj;
			result = this.personNumber.equals(p.personNumber);
		}
		return result;
	}
}
public class PersonNumberTest {
	public static void main(String[] args) {
		Person p1 = new Person("Sam","0000-0000");
		Person p2 = new Person("Sam","0000-0000");
		Person p3 = new Person("Sam","1234-4567");
		
		System.out.println(p1.equals(p2));
		System.out.println(p3.equals(p2));
				
	}
}
