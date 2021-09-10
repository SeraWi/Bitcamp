package com.bitcamp.orl.feed.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.feed.dao.FeedDao;
import com.bitcamp.orl.feed.domain.NewFeedList;

@Service
public class FeedSearchService {

	FeedDao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	public List<NewFeedList> getSearchByHashtag(String hashtagSearch) {
		
		List<NewFeedList> searchByHashtag = null;
		
		
		dao =template.getMapper(FeedDao.class);
		searchByHashtag = dao.selectByHashtag(hashtagSearch);
		
		return searchByHashtag;
	}
	
	
}
