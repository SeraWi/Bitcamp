package ContactApplication_Edit;

import java.util.regex.Pattern;

public class testapp {
	

	public static boolean phoneNumTypeCheck(String phoneNum) {
		//핸드폰 번호가 형식에 맞지 않으면 false리턴한다.
		//핸드폰 번호는 : 000-0000-0000형식
		return Pattern.matches("^01([0|1|6|7|8|9])-([0-9]{3,4})-([0-9]{4})$" , phoneNum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean result = phoneNumTypeCheck("01000000000");
		System.out.println(result);
	}

//	
//	public static String phoneNumCheck(String phoneNum) throws PhoneNumException {
//		// 전화번호가 형식에 맞지 않을 때 예외처리
//		
//		try {
//			if(phoneNum != null ) {//일단 입력되었는지 체크
//				if(phoneNumTypeCheck(phoneNum)) { //그 다음 핸드폰 번호 입력 형태 체크
//					//true ->제대로 입력됨
//					// 전화번호가 동일할 경우 예외처리 -> 입력되지 않도록 처리
//					// 리스트에 저장된 phonenum을 비교해서 같은지 확인-> 같은 경우 예외처리 하도록
//					for( int i = 0 ; i< contacts.size(); i++) { // 세번째로 동일한 전화번호가 있는지 체크
//						if(!phoneNum.equals(contacts.get(i).getPhonenNum()) ) {
//							// 동일한 전화번호 없다.
//						}else {
//							//같다 -> 예외처리
//							throw new PhoneNumException("동일한 전화번호가 존재합니다.");
//						}
//					}
//					
//				}else {
//					throw new PhoneNumException("전화번호 입력이 형식에 맞지않습니다.");
//				}
//			}else {
//				System.out.println("전화번호가 입력되지 않았습니다.");
//			}
//		}catch(PhoneNumException ex) {
//			System.out.println(ex.getMessage());
//		}
//		
//		return phoneNum;
//		
//				
//		
//	}
	
//	for(int i = 0; i< contacts.size(); i++) {
//		if(searchName.equals(contacts.get(i).getName())) { //검색 이름과 비교!
//			System.out.println(contacts.get(i).getName()+" : "+contacts.get(i).getPhoneNum());
//			return;
//		}
//	}
//	System.out.println("찾으시는 이름이 없습니다.");
	
	
}
