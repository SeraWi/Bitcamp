package com.bitcamp.op3.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.op3.member.domain.Member;
import com.bitcamp.op3.member.service.MemberRestService;

//@Controller

@RestController
public class MemberRestController {
	
	
	@Autowired
	private MemberRestService restService;
	
	
	@RequestMapping("/members/{id}")
//	@ResponseBody
	public Member getMember(
			@PathVariable("id")int idx
			) {
		Member member = restService.getMember(idx);
		System.out.println(member);
		
		return member;
	}
	
	//RestController사용하면
	//GetMapping, PostMapping,DeleteMapping, PutMapping 사용가능
	
	//오로지 get방식으로 들어왔을 때 실행
	@GetMapping("/members")
	public List<Member> getMembers(){
		
		return restService.getMembers();
	}
	
	//Map 형식으로 반환
	@GetMapping("/members1")
	public Map<Integer,Member> getMembers1(){
	
		return restService.getMembers1();
	}
}
