package com.bitcamp.firstSpring.dao;

import org.springframework.stereotype.Repository;

@Repository
public class FileUploadDao implements Dao {

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("파일 정보를 저장합니다.");
	}
	
}
