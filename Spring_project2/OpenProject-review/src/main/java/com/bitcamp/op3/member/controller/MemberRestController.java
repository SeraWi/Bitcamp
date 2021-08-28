package com.bitcamp.op3.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.op3.member.domain.Member;
import com.bitcamp.op3.member.domain.MemberRegRequest;
import com.bitcamp.op3.member.service.MemberRegService;
import com.bitcamp.op3.member.service.MemberRestService;

//@Controller

@RestController
public class MemberRestController {
	
	
	@Autowired
	private MemberRestService restService;
	
	@Autowired
	private MemberRegService regService;
	
	
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
	
	
	@PostMapping("/members/reg1")
	public String regMember1(
			MemberRegRequest regRequest,
			HttpServletRequest request
			) {
		//command 객체 (regRequest)로 폼에 입력한 정보 가져오기
		
		System.out.println(regRequest);
		return Integer.toBinaryString(regService.memberReg(regRequest,request));
	}
	
	@PostMapping("/members/reg2")
	public String regMember2(
			
			@RequestBody MemberRegRequest regRequest,
			HttpServletRequest request
			) {
		System.out.println(regRequest);
		return Integer.toString(regService.memberReg(regRequest,request));
		
	}
	
}
