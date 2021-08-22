package com.bitcamp.op3.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op3.member.dao.Dao;
import com.bitcamp.op3.member.domain.Member;

@Service
public class MemberRestService {
	
	
	private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	//해당 idx의 멤버 가져오기
	public Member getMember(int idx) {
		
		dao = template.getMapper(Dao.class);
		
		Member member = dao.selectByIdx(idx);
		
		return member;
	}

	//전체 멤버 가져오기 -->List형식으로!
	public List<Member> getMembers() {
		// TODO Auto-generated method stub
		dao =template.getMapper(Dao.class);
		
		
		return dao.selectAll();
	}
	
	
	//전체 멤버 가져오기 -->MAP형식으로!
	public Map<Integer, Member> getMembers1() {
		
		List<Member> list =getMembers();
		
		Map<Integer,Member> members = new HashMap<>();
		
		for(int i= 0; i<list.size(); i++) {
			members.put(list.get(i).getIdx(),list.get(i));
		}
		
		return members;
	}
}
