package member.service;

import java.util.Date;

import member.dao.Dao;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberRegService {
	
	
	//Dao dao = new Dao();
	Dao dao;
	
	public MemberRegService(Dao dao) {
		this.dao = dao;
	}
	
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
