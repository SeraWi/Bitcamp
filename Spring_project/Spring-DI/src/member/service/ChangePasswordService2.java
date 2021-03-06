package member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import member.dao.Dao;
import member.domain.Member;

public class ChangePasswordService2 {
	
	
	@Autowired
	@Qualifier("guest")
	private Dao dao;
	
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
