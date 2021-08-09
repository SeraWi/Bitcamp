package com.bitcamp.op.member.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.bitcamp.op.member.domain.RegisterRequest;
import com.bitcamp.op.member.service.MemberRegService;


@Controller
@RequestMapping("/member/register")
public class MemberRegController {
	
	@Autowired
	private MemberRegService regService;
	
	final String UPLOAD_URI ="/uploadfile"; //파일 저장되는 경로
	
	@RequestMapping(method=RequestMethod.GET)
	public String getRegForm() {
		return "member/memberRegForm";
	}
	
	
	//사용자의 파라미터 받기
	@RequestMapping(method=RequestMethod.POST)
	public String register(
			@ModelAttribute("registerRequest")RegisterRequest registerRequest,
			HttpServletRequest request,
			Model model
			) throws IllegalStateException, IOException {
		
		
		//사용자가 업로드한 파일 저장하기!
		saveFile(request,registerRequest.getMemberphoto());
		
		//받아온 데이터를 서비스로 넘겨서 처리하기
		int resultCnt = regService.register(registerRequest);
		
		//결과를 model에 저장
		model.addAttribute("resultCnt", resultCnt);
		return "member/memberReg";
	}
	
	//사용자가 업로드한 파일을 저장하는 메소드
	private void saveFile(
			HttpServletRequest request,
			MultipartFile file) throws IllegalStateException, IOException {
		
		//저장 경로
		String saveDir = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
		//저장할 파일
		File newFile = new File(saveDir,file.getOriginalFilename());
		
		//파일 저장
		file.transferTo(newFile);
	}
}
