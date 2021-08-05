package member.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import member.dao.Dao;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberRegService2 {
	// anotaion 사용해서 주입 ->생성자나 setter 필요없다
	// appCtx5.xml
	
	//@Autowired
	//@Qualifier("member")
	@Resource(name="guestDao")
	private Dao dao; 
	
	
	public void regMember(RegRequest request) throws Exception {
		//중복 이메일 체크
		Member oldMember = dao.selectByEmail(request.getEmail());
		if(oldMember !=null) {
			throw new Exception("중복이메일!");
		}
		
		Member  newMember = new Member(
				0,
				request.getEmail(),
				request.getPassword(),
				request.getName(),
				new Date()
				);
		
		dao.insert(newMember);
	}
}
