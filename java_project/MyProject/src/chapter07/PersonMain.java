package chapter07;

public class PersonMain {

	public static void main(String[] args) {
		Male m = new Male("Tom", 2002, "남성", "computer", "010-1234-5678");
		m.personInfo();
		m.studying();
		
		Female f = new Female("Kate", 1998, "여성", "Music", "010-9876-5432");
		f.personInfo();
		f.studying();
	}
}
