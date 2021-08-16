package com.bitcamp.op3.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.op3.member.domain.Member;
import com.bitcamp.op3.member.domain.SearchType;
import com.bitcamp.op3.member.service.MemberListService;

@Controller
public class MemberListController {
	
	@Autowired
	private MemberListService service;
	
	@RequestMapping("/member/list")
	public String getList(
			SearchType searchType,
			Model model
			) {
		List<Member> list= null;
		
		if(searchType.getKeyword() != null && searchType.getKeyword().length()>0) {
			//검색창 키워드에 입력했을 때
			list = service.getMemberList(searchType);
		} else {
			//입력창에 아무것도 안쓰고 그냥 검색버튼 눌렀을 때-> 전체 리스트 보여주기
			list= service.getMemberList();
		}
		
		model.addAttribute("memberList",list);
		
		return "member/list";
	}
	
	
	
}


