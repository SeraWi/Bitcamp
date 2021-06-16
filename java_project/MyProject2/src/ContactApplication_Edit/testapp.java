package ContactApplication_Edit;

import java.util.regex.Pattern;

public class testapp {
	
	public static boolean phoneNumTypeCheck(String phoneNum) {
		//핸드폰 번호가 형식에 맞지 않으면 false리턴한다.
		//핸드폰 번호는 : 000-0000-0000형식 혹은 01000000000 형식
		return Pattern.matches("^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$" , phoneNum);
	}
	
	public static boolean phoneNumTypeCheck2(String phoneNum) {
		//핸드폰 번호가 형식에 맞지 않으면 false리턴한다.
		//핸드폰 번호는 : 000-0000-0000형식 혹은 01000000000 형식
		return Pattern.matches("^\\d{2,3}\\d{3,4}\\d{4}$" , phoneNum);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean result =phoneNumTypeCheck("010-3333-3333");
		System.out.println(result);
		boolean result2 =phoneNumTypeCheck("01033333333");
		System.out.println(result2);
		
		boolean result3 =phoneNumTypeCheck("01033333333");
		System.out.println(result3);
		boolean result4 =phoneNumTypeCheck("010111");
		System.out.println(result4);
		

	}

}
