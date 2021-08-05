package com.bitcamp.firstSpring.domain;

import org.springframework.web.multipart.MultipartFile;

public class Report {
	private String sno;
	private String sname;
	private MultipartFile report;
	
	//커맨드 객체로 받기 위해서는 반드시 default생성자 필요하다
	public Report() {}
	
	public Report(String sno, String sname, MultipartFile report) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.report = report;
	}
	
	//getter setter
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public MultipartFile getReport() {
		return report;
	}

	public void setReport(MultipartFile report) {
		this.report = report;
	}
	
	
	
	
}
