package com.bitcamp.op2.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op2.jdbc.ConnectionProvider;
import com.bitcamp.op2.jdbc.JdbcUtil;
import com.bitcamp.op2.member.dao.Dao;
import com.bitcamp.op2.member.dao.JdbctemplateMemberDao;
import com.bitcamp.op2.member.dao.MemberDao;
import com.bitcamp.op2.member.dao.MybatisMemberDao;
import com.bitcamp.op2.member.domain.Member;
import com.bitcamp.op2.member.domain.MemberRegRequest;

@Service
public class MemberRegService {
	
	final String UPLOAD_URI = "/uploadfile";
	
//	@Autowired
//	private MemberDao dao;
	
//	@Autowired
//	private JdbctemplateMemberDao dao;
	
//	@Autowired
//	private MybatisMemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	private Dao dao;
	
	public int memberReg(
			MemberRegRequest regRequest,
			HttpServletRequest request
			) {
		
		int resultCnt = 0;
		//Connection conn = null;
		File newFile = null;
		
		
		try {
			// 1. 파일 저장
			
			// 시스템 경로
			String path = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
			// 새로운 저장 폴더 : File
			File newDir = new File(path);
			
			// 폴더가 존재하지 않으면 폴더 생성
			if(!newDir.exists()) {
				newDir.mkdir();
				System.out.println("저장 폴더를 생성했습니다.");
			}
			// 파일 저장시에 파일 이름이 같으면 덮어쓴다 -> 회원별 고유한 파일 이름을 만들자!!
			String newFileName = regRequest.getMemberid()+System.currentTimeMillis(); 
			//   cool123128936798123987

			// 새로운 File 객체
			newFile = new File(newDir, newFileName);
			
			// Member 객체 생성 
			Member member = regRequest.toMember(); //파일 이름 null인 상태
			
			// 파일 저장
			if(regRequest.getPhoto() != null && !regRequest.getPhoto().isEmpty()) {
				//파일 저장해주기
				regRequest.getPhoto().transferTo(newFile);
				//파일 이름 새롭게 setting
				member.setMemberphoto(newFileName);
			}
			
			// 2. dao 저장
			//conn = ConnectionProvider.getConnection();
			
			dao = template.getMapper(Dao.class);
			
			resultCnt = dao.insertMember(member);
			System.out.println("새롭게 등록된 idx=>"+member.getIdx());
			
			//idx값은 자식 테이블의 insert시 외래키로 사용할 수 있다.
			//자식테이블 insert 구문...
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		} finally {
			//JdbcUtil.close(conn);
		}
		
		return resultCnt;
	}

}