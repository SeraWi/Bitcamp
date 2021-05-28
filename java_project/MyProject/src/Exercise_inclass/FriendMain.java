package Exercise_inclass;

public class FriendMain {

	public static void main(String[] args) {
		Friend f1 = new Friend("손흥민");
		Friend f2 = new Friend("이강인");
		Friend f3 = new Friend("손흥민");
		
		System.out.println(f1);// f1.toString
		System.out.println(f2);
		System.out.println(f3);
		
		System.out.println(f1 == f3); //false
		System.out.println(f1.equals(f3));
	}
}

class Friend{
	String myName;
	Friend(String name){
		this.myName = name;
	}
	public String toString() { //오버라이딩
		return "나의 이름은 "+myName+" 입니다.";
	}
	
	public boolean equals(Object o) {//오버라이딩
		
		boolean result = false;
		if(o != null && o instanceof Friend) {
			Friend f = (Friend) o;
			if(myName.equals(f.myName)) {
				result = true;
			}
		}	
		return result;
	}
}


