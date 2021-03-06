package member.service;

import member.dao.Dao;
import member.domain.Member;

public class ChangePasswordService {
	
	private Dao dao;
	
	//dao 주입을 위한 setter
	public void setDao(Dao dao) {
		this.dao= dao;
	}
	
	//기본생성자
	public ChangePasswordService() {
		System.out.println("changePasswordService 인스턴스 생성");
	}
	
	public ChangePasswordService(Dao dao) {
		this.dao= dao;
		System.out.println("changePasswordService 인스턴스 생성");
	}
	
	public void changePassword(String email, String oldPw, String newPw) throws Exception {
		//기존 멤버객체 가져오기
		Member member = dao.selectByEmail(email);
		
		if(member == null) {
			throw new Exception("존재하지 않는 회원!");
		}
		
		//패스워드 변경
		member.changePassword(oldPw, newPw);
		
		//멤버 정보 업데이트
		dao.update(member);
	}
}
