package com.test.app;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.test.app.domain.Report;

@Controller
public class FileUploadController {
	
	final String UPLOAD_URI ="/uploadfile";
	
	@RequestMapping("/upload/uploadForm")
	public String getUploadForm() {
		return "upload/uploadForm";
	}
	
	@RequestMapping(value="/upload/upload1")
	public String upload(
			@RequestParam("sno")String sno,
			@RequestParam("sname")String sname,
			@RequestParam("report")MultipartFile report,
			Model model,
			HttpServletRequest request
			) throws IllegalStateException, IOException {
		
		System.out.println(sno+","+sname+","+report);
		model.addAttribute("sno",sno);
		model.addAttribute("sname",sname);
		model.addAttribute("reportfile",report.getOriginalFilename());
		/*
		 * //저장 경로 : 시스템 경로 String saveDir =
		 * String saveDir = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
		 * 
		 * File newFile = new File(saveDir,report.getOriginalFilename());
		 * 
		 * report.transferTo(newFile);
		 */
		saveFile(request,report);
		return "upload/upload";
	}
	
	//파일 저장 메소드
	private void saveFile(HttpServletRequest request, MultipartFile file) throws IllegalStateException, IOException {
		
		 String saveDir = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
		 
		 File newFile = new File(saveDir,file.getOriginalFilename());
		  
		 file.transferTo(newFile);
	}
	
	@RequestMapping("/upload/upload2")
	public String upload2(
			MultipartHttpServletRequest request,
			Model model
			) throws IllegalStateException, IOException {
		
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		MultipartFile report = request.getFile("report");
		
		
		System.out.println(sno+","+sname+","+report);
		model.addAttribute("sno",sno);
		model.addAttribute("sname",sname);
		model.addAttribute("reportfile",report.getOriginalFilename());
		
		
		saveFile(request,report);
		
		return "upload/upload";
	}
	
	
	@RequestMapping("/upload/upload3")
	public String upload3(
			Report report,
			Model model,
			HttpServletRequest request
			
			) throws IllegalStateException, IOException {
		System.out.println(report.getSno()+","+report.getSname()+","+report.getReport().getOriginalFilename());
		model.addAttribute("sno",report.getSno());
		model.addAttribute("sname",report.getSname());
		model.addAttribute("reportfile",report.getReport().getOriginalFilename());
		
		saveFile(request,report.getReport());
		return "upload/upload";
	}
}
