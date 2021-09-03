package com.bitcamp.orl.feed.domain;

import java.sql.Timestamp;

import org.springframework.stereotype.Repository;


@Repository
public class Feed {
	//피드 업로드 할 떄 쓸 class -> 아직 안씀
	
	
	private int boardIdx;
	private String boardPhoto;
	private String boardDiscription;
	private String boardDate;
	private Timestamp hashtag;
	private int memberIdx;
	
}
