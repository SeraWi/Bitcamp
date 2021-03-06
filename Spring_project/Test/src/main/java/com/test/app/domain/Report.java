package com.test.app.domain;

import org.springframework.web.multipart.MultipartFile;

public class Report {
	private String sno;
	private String sname;
	private MultipartFile report;
	
	
	//기본 생성자 명시적으로 해주기
	public Report() {}
	
	public Report(String sno, String sname, MultipartFile report) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.report = report;
	}
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
