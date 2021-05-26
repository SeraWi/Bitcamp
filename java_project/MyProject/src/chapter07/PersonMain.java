package chapter07;

public class PersonMain {

	public static void main(String[] args) {
		Male m = new Male("Tom", "920504-1000000", "남성", "computer", "010-1234-5678");
		m.hello();
		m.studying();
		
		Female f = new Female("Kate", "780707-2000000", "여성", "Music", "010-9876-5432");
		f.hello();
		f.studying();
	}
}
