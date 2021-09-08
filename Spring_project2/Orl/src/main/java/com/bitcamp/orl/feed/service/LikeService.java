package com.bitcamp.orl.feed.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.feed.dao.FeedDao;

@Service
public class LikeService {
	
	//좋아요 버튼 누르기, 취소하기 처리하기
	
	private FeedDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	
	
}
