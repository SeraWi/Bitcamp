package com.bitcamp.app.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.app.member.domain.Member;
import com.bitcamp.app.member.domain.SearchType;
import com.bitcamp.app.member.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	private MemberListService listService ;
	
	@RequestMapping("/member/list")
	public String getList(
			SearchType searchType,
			Model model
			) {
		System.out.println(searchType);
		List<Member> list = null;
		
		if(searchType.getKeyword() != null && searchType.getKeyword().trim().length()>0) {
			// selectMember
			list = listService.getMemberList(searchType);
		}else {
			//검색창에 아무것도 입력안하고 검색을  눌렀을 때!
			// 또는 처음  nav의 회원리스트보기를 눌럿을때
			//selectAll
			list = listService.getMemberList();
		}
		
		model.addAttribute("memberList", list);
		return "member/list";
	}
	
}
