package com.bitcamp.app.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.app.member.domain.Member;
import com.bitcamp.app.member.mapper.MemberMapper;


@Service
public class MemberRestService {
	
	@Autowired
	private SqlSessionTemplate template;
	private MemberMapper dao;
	
	//idx로 검색한 member정보
	public Member getMember(int idx) {
		dao = template.getMapper(MemberMapper.class);
				
		return  dao.selectByIdx(idx);
	}

	
	//모든 member 정보
	public List<Member> getMembers() {
		
		dao=template.getMapper(MemberMapper.class);
		
		
		return dao.selectAll();
	}


	public Map<Integer, Member> getMembers1() {
		
		
		List<Member> list = getMembers();
		Map<Integer,Member> members = new HashMap<Integer,Member>();
		
		for(int i= 0; i<list.size();i++) {
			members.put(list.get(i).getIdx(),list.get(i)); //앞에는 idx, 뒤에는 객체 반환
		}
		
		return members;
	}
}
