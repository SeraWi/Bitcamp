package com.bitcamp.op3.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op3.member.dao.Dao;
import com.bitcamp.op3.member.dao.jdbcTemplateMemberDao;
import com.bitcamp.op3.member.dao.mybatisMemberDao;
import com.bitcamp.op3.member.domain.Member;
import com.bitcamp.op3.member.domain.MemberRegRequest;

@Service
public class MemberRegService {
	
	final String UPLOAD_URI ="/uploadfile";
	
//	@Autowired
//	private MemberDao dao;
	
	
//	@Autowired
//	private jdbcTemplateMemberDao dao;
	
//	
//	@Autowired
//	private mybatisMemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	private Dao dao;
	
	public int memberReg(
			MemberRegRequest regRequest,
			HttpServletRequest request
			) {
		int resultCnt = 0;
		File newFile = null;
		
		
		try {
			//1. 파일 저장
			
			//시스템 경로
			String path = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
			
			//새로운 저장 폴더 : File
			File newDir = new File(path);
			
			//폴더가 존재하지 않으면 폴더 생성
			if(!newDir.exists()) {
				newDir.mkdir();
				System.out.println("저장폴더를 생성했습니다.");
			}
			
			//파일 저장시에 파일 이름이 같으면 덮어쓴다->회원별 고유한 파일 이름을 만들자!
			String newFileName = regRequest.getMemberid()+System.currentTimeMillis(); 
			// 멤버아이디+ long타입의 시간
			
			
			//새로운 File객체 필요
			newFile = new File(newDir,newFileName);
			
			//Member 객체 생성하고 저장된 파일의 이름을 set해줘야
			Member member = regRequest.toMember();
			
			//파일 저장
			if(regRequest.getPhoto() != null && !regRequest.getPhoto().isEmpty()) {
				//파일 저장해주기
				regRequest.getPhoto().transferTo(newFile);
				//파일 이름 새롭게 setting
				member.setMemberphoto(newFileName);
			}
			
			//dao 저장
			
			
			
			//사용자가 올린 파일이름 != 받아서 우리가 저장한 파일의 이름
			
			dao = template.getMapper(Dao.class);
			resultCnt  = dao.insertMember(member);
			System.out.println("idx ->"+ member.getIdx());
			
			
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		
		return resultCnt;
	}
}
