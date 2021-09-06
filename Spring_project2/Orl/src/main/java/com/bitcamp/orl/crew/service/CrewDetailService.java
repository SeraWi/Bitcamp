package com.bitcamp.orl.crew.service;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.dao.CrewDao;
import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewInfo;
import com.bitcamp.orl.member.domain.Member;


@Service
public class CrewDetailService {
	
	private CrewDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	//민주 -> CrewInfo 가져옴
	public CrewInfo getCrewInfo(
			HttpSession session, 
			int crewIdx
			) {
		
		CrewInfo crewinfo = getCrew(crewIdx).crewToCrewInfo();
		Member member = (Member)session.getAttribute("member");
		
		//비어있는 세가지 채우기
		
		//크루원 수 
		crewinfo.setCrewMemberNum(getCrewMemberNum(crewIdx));
		
		//댓글 전체 갯수
		crewinfo.setCrewCommentNum(getCrewCommentNum(crewIdx));
		
		if(member != null) {
			//크루원인지....
			crewinfo.setIsReg(getIsCrewMember(member.getMemberIdx(), crewIdx));
		} else {
			crewinfo.setIsReg(false);
		}
		
		return crewinfo;
	}
	
	
	// 세라 오버로딩
//	public CrewInfo getCrewInfo(
//			int memberIdx,
//			int crewIdx
//			) {
//		
//		CrewInfo crewinfo = getCrew(crewIdx).crewToCrewInfo();
////		Member member = (Member)session.getAttribute("member");
//		
//		//크루원들의 수 ?
//		crewinfo.setCrewMemberNum(getCrewMemberNum(crewIdx));
//		
//		//크루 코멘트 갯수?
//		crewinfo.setCrewCommentNum(getCrewCommentNum(crewIdx));
//		
//		//크루 멤버인지 확인
//		crewinfo.setIsReg(getIsCrewMember(memberIdx, crewIdx));
//		
////		if(member != null) {
////			crewinfo.setIsReg(getIsCrewMember(member.getMemberIdx(), crewIdx));
////		} else {
////			crewinfo.setIsReg(false);
////		}
//		
//		return crewinfo;
//	}
	
	//크루 하나의 정보 가져오기
	public Crew getCrew(int crewIdx) {
		dao = template.getMapper(CrewDao.class);
		Crew crew = dao.selectCrew(crewIdx);
		return crew;
	}
	
	//크루원들의 수 가져오기
	public int getCrewMemberNum(int crewIdx) {
		dao = template.getMapper(CrewDao.class);
		int crewMemberNum = dao.selectCrewMemberNum(crewIdx);
		return crewMemberNum;
	}
	
	// 크루 상세보기 댓글 전체 갯수
	public int getCrewCommentNum(int crewIdx) {
		dao = template.getMapper(CrewDao.class);
		int crewCommentNum = dao.selectCrewCommentNum(crewIdx);
		return crewCommentNum;
	}
	
	// 내가 크루 멤버인지아닌지
	public boolean getIsCrewMember(int memberIdx, int crewIdx) {
		boolean chk = false;
		dao = template.getMapper(CrewDao.class);
		int chkInt = dao.selectCountMemberToRegCrew(memberIdx, crewIdx);
		if(chkInt != 0) {
			chk = true;
		}
		return chk;
	}
}
